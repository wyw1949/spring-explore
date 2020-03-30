<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8" %>
<html>
    <head>
        <title>spittles</title>
        <meta charset="UTF-8">
        <meta http-equiv="content-type" content="text/html; charset=utf-8">
    </head>
    <body>
        <c:forEach items="${spittleList}" var="spittle">
            <li id="spittle_<c:out value='${spittle.id}' />">
                <div>
                    <c:out value="${spittle.message}"/>
                </div>
                <div>
                    <span class="spittleTime">
                        <c:out value="${spittle.time}"/>
                    </span>
                    <span class="spittleLocation">
                        (<c:out value="${spittle.latitude}"/>,<c:out value="${spittle.longitude}"/>)
                    </span>
                </div>
            </li>
        </c:forEach>
    </body>
</html>