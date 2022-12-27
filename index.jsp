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
                <h1 id="header">Our Site</h1>
                <ul>
                    <li>
                        <form action="GroupPublic" method="post">
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
                <h1>Login</h1>
                <p>${message}</p>
                <div id="inputs">
                    <form action="GroupPublic" method="post">
                        <input type="hidden" name="action" value="attemptLogin">
                        <label>Username:</label><br>
                        <input type="text" name="username" class="textInput">
                        <br><br>
                        <label>Password:</label><br>
                        <input type="text" name="password" class="textInput"> <!-- change "text" to "password" when finished -->
                        <br><br>
                        <input  class="indexButtons" type="submit" value="Sign In">
                    </form>

                    <form action="GroupPublic" method="post">
                        <input type="hidden" name="action" value="goToRegistration">
                        <input class="indexButtons" type="submit" value="Sign Up">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
