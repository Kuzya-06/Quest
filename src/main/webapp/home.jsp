<%--
  Created by IntelliJ IDEA.
  User: Миша
  Date: 30.09.2023
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h1>Welcome <%=session.getAttribute("username")%>!</h1>
<form action="logout" method="post">
  <input type="submit" value="Logout">
</form>
</body>
</html>
