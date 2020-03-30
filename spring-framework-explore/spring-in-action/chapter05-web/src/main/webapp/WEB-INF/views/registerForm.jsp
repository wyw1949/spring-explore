<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8" %>
<html>
    <head>
        <title>registration</title>
        <meta charset="UTF-8">
        <meta http-equiv="content-type" content="text/html; charset=utf-8">
    </head>
    <body>
        <h1>register</h1>
        <form method="POST" action="<c:url value='/spitter/register'/>">
            <table>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstName"/></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastName"/></td>
                </tr>
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="register"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>