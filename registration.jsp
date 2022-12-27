<%-- 
    Document   : registration
    Created on : Oct 20, 2022, 2:13:28 PM
    Author     : 14023
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <nav>
                <h1 id="header">Sign Up</h1>
                <ul>
                    <li>
                        <form action="GroupPrivate" method="post">
                            <input type="hidden" name="action" value="goToLogin">
                            <input type="submit" value="Login" class="nav_buttons">
                        </form>
                    </li>
                    <li>
                        <form action="GroupPrivate" method="post">
                            <input type="hidden" name="action" value="logout">
                            <input type="submit" value="Logout" class="nav_buttons">
                        </form>
                    </li>
                    <li>
                        <form action="GroupPublic" method="post">
                            <input type="hidden" name="action" value="goToRegistration">
                            <input type="submit" value="Registration" class="nav_buttons">
                        </form>
                    </li>
                    <li>
                        <form action="GroupPrivate" method="post">
                            <input type="hidden" name="action" value="goToProfile">
                            <input type="submit" value="Profile" class="nav_buttons">
                        </form>
                    </li>
                    <li>
                        <form action="GroupPrivate" method="post">
                            <input type="hidden" name="action" value="goToAllUsers">
                            <input type="submit" value="All Users" class="nav_buttons">
                        </form>
                    </li>
                </ul>
            </nav>
            <div id="login">
                <h1>Register Please</h1>
                <span id="registrationMessage">${message}</span>
                <span id="errorMessage">${errors}</span>
                <div id="inputs">
                    <form action="GroupPublic" method="post" id="form">
                        <input type="hidden" name="action" value="signUp">
                        <label>Username:</label><br>
                        <input type="text" name="username" class="textInput" value="${newUser.getUsername()}"><br>
                        <span id="usernameError">${usernameError}</span>
                        <br><br>

                        <label>Password:</label><br>
                        <input type="text" name="password" class="textInput" value="${newUser.getPassword()}"><br>
                        <span id="passwordError">${passwordError}</span>
                        <br><br>

                        <label>Email:</label><br>
                        <input type="text" name="email" class="textInput" value="${newUser.getEmail()}"><br>
                        <span id="emailError">${emailError}</span>
                        <br><br>

                        <label>Birth Date:</label><br>
                        <input type="date" name="birthDate" class="textInput" value="${newUser.getDateOfBirth()}"><br>
                        <span id="dateError">${birthdateError}</span>
                        <br><br>

                        <input type="submit" value="Sign Up" class="indexButtons">

                        <form action="GroupPublic" method="post">
                            <input type="hidden" name="action" value="goToLogin">
                            <input type="submit" value="Back To Sign In" class="indexButtons">
                        </form>
                </div>
                </form>
            </div>
        </div>
    </body>
</html>
