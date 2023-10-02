<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>LogIn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<div class="container col-xxl-8 px-4 py-5">
    <div class="row flex-lg-row-reverse align-items-center g-5 py-5">

        <main class="text-center form-signin w-50 m-auto">
            <form action="log-in" method="post">

                <c:if test="${sessionScope.user == null}">
                    <h1 class="h3 mb-3 fw-normal">Пожалуйста, войдите в систему</h1>
<%--                </c:if>--%>

<%--                <c:if test="${sessionScope.user == null}">--%>
                    <div class="form-floating">
                        <input type="text" class="form-control" name="login" id="floatingInput" placeholder="Username">
                        <label for="floatingInput">Имя пользователя</label>
                    </div>
                    <div class="form-floating">
                        <input type="password" class="form-control" name="password" id="floatingPassword"
                               placeholder="Password">
                        <label for="floatingPassword">Пароль</label>
                    </div>
                    <button class="w-100 btn btn-lg btn-primary" type="submit">Войти</button>
                </c:if>

                <c:if test="${sessionScope.user != null}">
                    <h1 class="h3 mb-3 fw-normal">Добро пожаловать, ${sessionScope.user.login}</h1>
                    <br/>
                    <div class="start-button"><a href="/start">Начать Квест</a><br></div>
                    <br/>
<%--                </c:if>--%>

<%--                <c:if test="${sessionScope.user != null}">--%>
                    <a class="btn btn-outline-primary me-2" href="log-out" role="button" aria-expanded="false">
                        Выход
                    </a>
                    <br/>
                </c:if>
                <br/>
                <p>Статистика сыгранных игр:</p>
               <h5>${sessionScope.count}</h5>

            </form>
        </main>
    </div>


</div>
</body>
</html>
