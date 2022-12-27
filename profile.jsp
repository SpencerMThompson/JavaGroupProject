<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
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
                <h1 id="header">Profile</h1>
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

            <h2>${message}</h2>
            ${loggedInUser.username}
            ${loggedInUser.password}
            ${loggedInUser.email}
            ${loggedInUser.dateOfBirth}
            ${loggedInUser.status}
            <div id="login">
                <form action="GroupPrivate" method="post">
                    <div id="inputs2">
                        <input type="hidden" name="action" value="edit">
                        <label>Update Password</label><br>
                        <input type="text" name="password" value="${loggedInUser.password}" class="textInput">
                        <span id="passwordError">${passwordError}</span>
                        <br>

                        <label>Confirm New Password<lable><br>
                                <input type="text" name="password2" class="textInput">
                                <br>

                                <label>Update Email</label><br>
                                <input type="text" name="email" value="${loggedInUser.email}" class="textInput">
                                <span id="emailError">${emailError}</span>
                                <br><br>

                                <label>Status</label><br>
                                <input type="text" name="status" class="textInput">
                                <span id="statusError">${statusError}</span>
                                <br><br>
                                <input type="submit" value="Save Changes" class="indexButtons">
                                </div>
                                </form> 
                                </div>
                                <div id="login">
                                    <form action="GroupPrivate" method="post">
                                        <input type="hidden" name="action" value="userPost">
                                        <label>Post: </label>
                                        <input type="text" name="userPost">
                                        <input type="submit" value="Post" class="indexButtons">
                                    </form>
                                    <form>
                                        <table>
                                            <tr>
                                                <th>UserName</th>
                                                <th>Post</th>
                                                <th>Comments</th>
                                            </tr>
                                            <c:forEach items="${posts}" var="post">
                                                <tr>
                                                    <td>${post.value.userName}</td>
                                                    <td>${post.value.post}</td>
                                                    <c:forEach items="${post.value.comments}" var="comment">
                                                        <td>${comment.userName} + ': ' + ${comment.comment}</td>
                                                    </c:forEach>
                                                    
                                                </tr>   
                                            </c:forEach>
                                        </table>
                                    </form>
                                </div>
                                </div>
                                </body>
                                </html>
