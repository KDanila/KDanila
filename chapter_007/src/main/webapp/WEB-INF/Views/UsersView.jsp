<%@ page import="ru.job4j.userservlet.User" %>
<%@ page import="ru.job4j.userservlet.ValidateService" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Collections" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: Данила
  Date: 14.12.2018
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td> User ID</td>
        <td> Login</td>
        <td> Name</td>
        <td> Email</td>
    </tr>

    <c:forEach items="${users}" var="user">
    <tr>
        <td>
            <c:out value="${user.id}"></c:out>
        </td>
        <td>
            <c:out value="${user.login}"></c:out>
        </td>
        <td>
            <c:out value="${user.name}"></c:out>
        </td>
        <td>
            <c:out value="${user.email}"></c:out>
        </td>
        <td>
            <form name='update' action="${pageContext.servletContext.contextPath}/update" method='get'>
                <input type='submit' value='update'>
                <input type='hidden' name='id' value="${user.id}">
            </form>
        </td>
        <td>
            <form name='delete' action="<%=request.getContextPath()%>/" method='post'>
                <input type='submit' value='delete'>
                <input type='hidden' name='id' value="${user.id}">
            </form>
        </td>
    </tr>
    </c:forEach>
    <tr>
        <form action="${pageContext.servletContext.contextPath}/create" method='post'>
            <input type='text' name='name' value="name"/>
            <input type='text' name='login' value="login"/>
            <input type='text' name='email' value="email"/>
            <input type='submit' name='submit'>
        </form>
    </tr>
</table>
</body>
</html>
