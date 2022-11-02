<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Login</h1>
<form method="POST" action ="login.jsp">

    <label for="username"> Username: </label>
    <input type ="text" id="username" name="username" placeholder="Enter Username">
    <label for="password"> Password: </label>
    <input for="password" id="password" name="password" placeholder="Enter Password">
    <button type="submit"> Login </button>

</form>


    <p> Username: ${param.username}</p>
    <p> Password: ${param.password}</p>


<c:choose>
    <c:when test='${param.username.equals("admin") && param.password.equals("password")}'>
        <% response.sendRedirect("/profile.jsp"); %>
    </c:when>
    <c:otherwise>
        <c:if test ="${param.username != null && param.password != null}">
            <% response.sendRedirect("/login.jsp");%>
        </c:if>
    </c:otherwise>
</c:choose>

</body>
</html>
