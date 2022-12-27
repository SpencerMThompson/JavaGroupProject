<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                <h1 id="header">Users</h1>
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
            <ol>
                <c:forEach items="${errors}" var="error">
                    <li>${error.key}: ${error.value}</li>
                    </c:forEach>
            </ol>

            <ul>
                <c:forEach items="${allUsers}" var="loggedInUser">
                    <li>${loggedInUser.key}
                        ${loggedInUser.value.password}
                        ${loggedInUser.value.email}
                        ${loggedInUser.value.dateOfBirth}
                        ${loggedInUser.value.status}</li>
                    </c:forEach>
            </ul>
        </div>
    </body>
</html>
