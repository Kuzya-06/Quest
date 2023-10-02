<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Quest</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>

<form class="form-horizontal" action="/start" method="post">

    <fieldset>

        <!-- Form Name -->
        <legend>${requestScope.gameId.question}</legend>


        <!-- Multiple Radios -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="radios"></label>

            <div class="col-md-4">

                <div class="radio">
                    <label for="radios-0">
                        <input type="radio" name="radios" id="radios-0" value=${requestScope.gameId.idNext1} checked="checked">
                        ${requestScope.gameId.answer1}
                    </label>
                </div>

                <div class="radio">
                    <label for="radios-1">
                        <input type="radio" name="radios" id="radios-1" value=${requestScope.gameId.idNext2} >

                        ${requestScope.gameId.answer2}

                    </label>
                </div>

            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-primary">Ответить</button>
            </div>
        </div>

    </fieldset>
</form>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>

</body>
</html>
