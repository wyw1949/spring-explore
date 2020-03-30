<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8" %>
<html>
    <head>
        <title>spittr</title>
        <meta charset="UTF-8">
        <meta http-equiv="content-type" content="text/html; charset=utf-8">
    </head>
    <body>
        <h1>welcome to spittr</h1>
        <a href="<c:url value='/spittles'/>">spittles</a> |
        <a href="<c:url value='/spitter/register'/>">register</a>
    </body>
</html>