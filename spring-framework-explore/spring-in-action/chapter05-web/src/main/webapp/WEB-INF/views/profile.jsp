<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8" %>
<html>
    <head>
        <title>profile</title>
        <meta charset="UTF-8">
        <meta http-equiv="content-type" content="text/html; charset=utf-8">
    </head>
    <body>
        <h1>Your Profile</h1>
        <c:out value="${spitter.username}" /><br/>
        <c:out value="${spitter.firstName}"/> <c:out value="${spitter.lastName}"/>
    </body>
</html>