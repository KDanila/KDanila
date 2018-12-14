<%@ page import="ru.job4j.userservlet.User" %>
<%@ page import="ru.job4j.userservlet.ValidateService" %><%--
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

    <% for (User user : ValidateService.getInstance().findAll().values()) {%>
    <tr>
        <td>
            <%=user.getId()%>
        </td>
        <td>
            <%=user.getLogin()%>
        </td>
        <td>
            <%=user.getName()%>
        </td>
        <td>
            <%=user.getEmail()%>
        </td>
        <td>
            <form name='update' action="<%=request.getContextPath()%>/update" method='get'>
                <input type='submit' value='update'>
                <input type='hidden' name='id' value=<%=user.getId()%>>
            </form>
        </td>
        <td>
            <form name='delete' action="<%=request.getContextPath()%>/user" method='post'>
                <input type='submit' value='delete'>
                <input type='hidden' name='id' value=<%=user.getId()%>>
            </form>
        </td>
    </tr>
    <%}%>
    <tr>
        <form action ="<%=request.getContextPath()%>/create" method ='post'>
           <input type = 'text' name = 'name' value="name"/>
           <input type = 'text' name = 'login' value="login"/>
           <input type = 'text' name = 'email' value="email"/>
           <input type ='submit' name = 'submit' >
           </form>
    </tr>
</table>
</body>
</html>
