<%--
  Created by IntelliJ IDEA.
  User: Миша
  Date: 30.09.2023
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Winner</title>
    <link rel="stylesheet" type="text/css" href="static/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
</head>
<body>
<div>
    </br>
   <h1> ${requestScope.answer} </h1>
</div>
</br>

 <img src=${requestScope.answerImg} />

<%--    <a href="/servlet-quest">Начать сначала!</a><br>--%>
<form class="form-horizontal" action="/login.jsp">
    <fieldset>

        <!-- Form Name -->
        <legend></legend>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-success">Начать сначала</button>
            </div>
        </div>

    </fieldset>
</form>

</body>
</html>
