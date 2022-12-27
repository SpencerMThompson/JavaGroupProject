
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import business.User;
import data.UserDA;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*Login registration and nav bar links*/
public class GroupPublic extends HttpServlet {

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Commit -> Pull -> Merge -> Resolve Merge Conflicts If Any -> Commit -> Push
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp";
        String action = request.getParameter("action");
        HashMap<String, String> errors = new HashMap();
        String message = "";

        if (action == null) {
            action = "no action";
        }

        switch (action) {
            ////////////////////////////////////////////////////////////////////////////
            case "attemptLogin": {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                User attemptLogin = new User();
                boolean isValid = true;

                try {
                    HashMap<String, User> allUsers = UserDA.selectAll();

                    if (allUsers.containsKey(username)) {
                        attemptLogin = allUsers.get(username);
                        if (attemptLogin.getPassword().equals(password)) {
                            request.getSession().setAttribute("loggedInUser", attemptLogin);
                            request.setAttribute("message", "login successful");
                            
                            url = "/Private?action=gotoProfile";
                        } else {
                            url = "/index.jsp";
                            message = "Bad username password combination, try again";
                            isValid = false;
                        }
                    } else {
                        url = "/index.jsp";
                        message = "No users with that username. ";
                        isValid = false;
                    }
                } catch (SQLException e) {
                    errors.put("selectAll", "Error with SQL in the database.");
                } catch (Exception e) {
                    errors.put("selectAll", "Error with the database.");
                }
                request.setAttribute("message", message);

                break;
            }
            ////////////////////////////////////////////////////////////////////////////
            case "signUp": {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String email = request.getParameter("email");
                String birthdate = request.getParameter("birthDate");

                User newUser = new User();

                String usernameError = "";
                String passwordError = "";
                String emailError = "";
                String birthdateError = "";

                String registrationMessage = "Success! Your account has been created. ";
                int yearsBetween = 0;
                boolean isValid = true;
                //--------------------------------------------------------------------
                try {
                    HashMap<String, User> allUsers = UserDA.selectAll();

                    if (username != null && !username.equals("")) {
                        if (!allUsers.containsKey(username)
                                && (username.length() >= 4 && username.length() <= 20)) {
                            newUser.setUsername(username);
                            
                        } else {
                            usernameError = "That name is already taken. ";
                            newUser.setUsername("");
                            isValid = false;
                        }

                    } else {
                        usernameError = "Please make your user name between 4 and 20"
                                + " characters long";
                        newUser.setUsername("");
                        isValid = false;

                    }

                } catch (SQLException e) {
                    errors.put("selectAll", "Error with SQL in the database.");
                } catch (Exception e) {
                    errors.put("selectAll", "Error with the database.");
                }

                // test for uniqueness
                //--------------------------------------------------------------------
                if (email != null && !email.equals("")) {
                    try {
                        HashMap<String, User> allUsers = UserDA.selectAll();
                        String checkEmail = "";
                        for (User user : allUsers.values()) {
                            checkEmail = user.getEmail();
                            if (checkEmail.equals(email)) {
                                isValid = false;
                                emailError = "There is an account already"
                                        + " registered with that email. ";
                            } else {

                                if (email.contains("@") && email.contains(".")) {
                                    int symbol1 = email.indexOf("@");
                                    int symbol2 = email.indexOf(".");
                                    if (symbol1 < symbol2) {
                                        newUser.setEmail(email);
                                    }
                                } else {
                                    emailError = "Please enter a valid email. ";
                                    newUser.setEmail("");
                                    isValid = false;
                                }
                            }
                        }

                    } catch (SQLException e) {
                        errors.put("selectAll", "Error with SQL in the database.");
                    } catch (Exception e) {
                        errors.put("selectAll", "Error with the database.");
                    }

                } else {
                    emailError = "Email is a required field. ";
                    newUser.setEmail("");
                    isValid = false;
                }
                //--------------------------------------------------------------------
                if (password != null && password.length() >= 10) {
                    newUser.setPassword(password);
                } else {
                    passwordError = "Password must be at least 10 characters"
                            + " long.";
                    newUser.setPassword("");
                    isValid = false;
                }
                //--------------------------------------------------------------------
                if (birthdate != null) {
                    
                    LocalDate DOB = null;
                    
                    try {
                        DOB = LocalDate.parse(birthdate);
                        
                        LocalDate currentDate = now();
                        yearsBetween = (int) (ChronoUnit.YEARS.between(DOB, currentDate));
                        if (yearsBetween >= 18) {
                            newUser.setDateOfBirth(DOB);
                        } else {
                            birthdateError += "You must be 18 to create an account. ";
                            newUser.setDateOfBirth(LocalDate.now());
                            isValid = false;
                        }
                    } catch (Exception e) {
                    isValid = false;
                    birthdateError += "Must enter a valid date";
                }

//                if (DOB != null) {
//
//                    LocalDate currentDate = now();
//                    yearsBetween = (int) (ChronoUnit.YEARS.between(DOB, currentDate));
//                    if (yearsBetween >= 18) {
//                        newUser.setDateOfBirth(DOB);
//                    } else {
//                        birthdateError += "You must be 18 to create an account. ";
//                        newUser.setDateOfBirth(LocalDate.now());
//                        isValid = false;
//                    }
//
//                        isValid = false;
//                        birthdateError += "Invalid date input";
//                    }
                          
                } else {
                    birthdateError = "Invalid Date. Date of birth must be in the 'mm/dd/yyyy' format";
                    newUser.setDateOfBirth(LocalDate.now());
                    isValid = false;
                }

                //--------------------------------------------------------------------
                if (isValid) {
                    url = "/index.jsp";

                    request.setAttribute("message", registrationMessage);
                    try {
                        UserDA.insert(newUser);
                    } catch (SQLException e) {
                        errors.put("insert", "Error with SQL in the database.");
                    } catch (Exception e) {
                        errors.put("insert", "Error with the database.");
                    }
                } else {
                    url = "/registration.jsp";
                    
                    request.setAttribute("newUser", newUser);
                
                    request.setAttribute("usernameError", usernameError);
                    request.setAttribute("passwordError", passwordError);
                    request.setAttribute("emailError", emailError);
                    request.setAttribute("birthdateError", birthdateError);

                }

                request.setAttribute("user", newUser);
                //--------------------------------------------------------------------
                break;
            }
            ////////////////////////////////////////////////////////////////////////////
            case "goToLogin": {
                url = "/index.jsp";
                break;
            }
            ////////////////////////////////////////////////////////////////////////////
            case "goToRegistration": {
                url = "/registration.jsp";
                break;
            }
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

}
