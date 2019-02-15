<%--
  Created by IntelliJ IDEA.
  User: Данила
  Date: 15.12.2018
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Обновить данные пользователя </h1>
<form action="${pageContext.servletContext.contextPath}/update" method='post'>
    <input type='text' name='name' value="${user.name}">
    <input type='text' name='login' value="${user.login}">
    <input type='text' name='email'  value="${user.email}">
    <input type='text' name='password'  value="${user.password}">
    <input type='hidden' name='id'  value="${user.id}">
    <input type='submit' name='submit'>
</form>
</body>
</html>
