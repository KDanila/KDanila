<%--
  Created by IntelliJ IDEA.
  User: Данила
  Date: 09.01.2019
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Вход в систему </h1>
<form action = "${pageContext.servletContext.contextPath}/signin" method="post">
    Login : <input type = "text" name="login"><br/>
    Password : <input type = "password" name = "password"><br/>
    <input type="submit">
</form>
</body>
</html>
