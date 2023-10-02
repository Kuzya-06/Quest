<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>SignUp</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="static/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
</head>

<body>
<div class="container col-xxl-8 px-4 py-5">
    <div class="row flex-lg-row-reverse align-items-center g-5 py-5">

        <main class="text-center form-signin w-100 m-auto">
            <form class="row g-3 needs-validation" action="sign-up" method="post" novalidate>
                <div class="col-md-6">
                    <label for="validationCustom03" class="form-label">Имя пользователя</label>
                    <input type="text" class="form-control" name="login" id="validationCustom03" placeholder="Login"
                           required>
                </div>

                <div class="col-md-6">
                    <label class="form-label">Пароль</label>
                    <input type="password" class="form-control" name="password1" id="floatingPassword1"
                           placeholder="Password" required>
                </div>
                <div class="col-md-6">
                    <label class="form-label">Повторите пароль</label>
                    <input type="password" class="form-control" name="password2" id="floatingPassword2"
                           placeholder="Password" required>
                </div>
                <div class="col-12">
                    <button class="btn btn-primary" type="submit">Применить</button>
                </div>
            </form>
        </main>
    </div>
</div>
</body>
</html>
<%--<%@ include file="parts/footer.jsp" %>--%>