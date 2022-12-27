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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*profile and all users for only logged in */
public class GroupPrivate extends HttpServlet {

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

        // Check if there is a logged in user
        User loggedInUser = (User) request.getSession().getAttribute("loggedInUser");

        if (loggedInUser == null) {
            String message;

            message = "Must be logged in to use this feature";

            request.setAttribute("message", message);
            String url = "/index.jsp";

            getServletContext().getRequestDispatcher(url).forward(request, response);
            return;
        }

        //---------------------------------
        // if there is a logged in user
        String url = "/index.jsp";
        String action = request.getParameter("action");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String status = request.getParameter("status");
        String password2 = request.getParameter("password2");
        String passwordError = "";
        String emailError = "";
        String statusError = "";
        if (action == null) {
            action = "no action";
        }
        HashMap<String, String> errors = new HashMap();
        switch (action) {
            case "goToProfile": {
                url = "/profile.jsp";
                break;
            }
            case "goToAllUsers": {
                url = "/display.jsp";
                try {
                    HashMap<String, User> allUsers = UserDA.selectAll();
                    request.setAttribute("allUsers", allUsers);
                } catch (SQLException e) {
                    errors.put("selectAll", "Error with SQL in the database.");
                } catch (Exception e) {
                    errors.put("selectAll", "Error with the database.");
                }

                break;
            }
            case "no action": {
                url = "/profile.jsp";
                break;
            }
            case "edit": {
                url = "/profile.jsp";
                if (password2 != null && password2 != "") {
                    if (password2.equals(password) && password2.length() >= 10) {
                        loggedInUser.setPassword(password);
                    } else {
                        passwordError = "Invalid Password";
                    }
                }

                if (email != null) {
                    //
                    try {
                        HashMap<String, User> allUsers = UserDA.selectAll();
                        String checkEmail = "";
                        for (Map.Entry<String, User> Key : allUsers.entrySet()) {
                            User emailCheck = new User();
                            emailCheck = Key.getValue();
                            checkEmail = emailCheck.getEmail();

                        }
                        if (checkEmail == email) {
                            emailError = "There is an account already"
                                    + " registered with that email. ";
                        } else {

                            if (email.contains("@") && email.contains(".")) {
                                int symbol1 = email.indexOf("@");
                                int symbol2 = email.indexOf(".");
                                if (symbol1 < symbol2) {
                                    loggedInUser.setEmail(email);
                                }
                            } else {
                                emailError = "Please enter a valid email. ";
                            }
                        }

                    } catch (SQLException e) {
                        errors.put("selectAll", "Error with SQL in the database.");
                    } catch (Exception e) {
                        errors.put("selectAll", "Error with the database.");
                    }
                }
                if (status != "" && status != null) {
                    loggedInUser.setStatus(status);
                }
                if (emailError != "" || passwordError != "" || statusError != "") {
                    url = "/profile.jsp";
                    request.setAttribute("emailError", emailError);
                    request.setAttribute("passwordError", passwordError);
                    request.setAttribute("statusError", statusError);
                } else {
                    try {
                        UserDA.update(loggedInUser);
                    } catch (SQLException e) {
                        errors.put("update", "Error with SQL in the database.");
                    } catch (Exception e) {
                        errors.put("update", "Error with the database.");
                    }
                }
                break;
            }
            
            case "logout": {
                loggedInUser = null;
                url = "/index.jsp";
                request.setAttribute("message", "log out successful");
                request.getSession().setAttribute("loggedInUser", loggedInUser);
                break;
            }
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
