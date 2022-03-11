<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.01.2022
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">
    </a>
    <img height="30" width="30" src="https://cdn2.iconfinder.com/data/icons/ios7-inspired-mac-icon-set/512/Calculator_512.png" alt="MDN logo">
    <a class="navbar-brand" href="#">
        <a class="navbar-brand" href="/">HOME</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-item nav-link" href="/calculator">Calculator</a>
                <a class="nav-item nav-link" href="/history">History</a>
            </div>
        </div>
</nav>
<form action="/calc" method="post">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-5">
                <div class="form-group row my-2">
                    <label class="col-sm-2 col-form-label">Number1</label>
                    <div class="col-sm-10">
                        <input type="text" name="num1" class="form-control" placeholder="Number1" pattern="[\d]+[.]?[\d]*" required>
                    </div>
                </div>
                <div class="form-group row my-2">
                    <label class="col-sm-3 col-form-label">Operator</label>
                    <div class="form-group col-md-3">
                        <select type = "button" name = "operator" class="form-control">

                            <option value="sum">+</option>
                            <option value="sub">-</option>
                            <option value="mul">*</option>
                            <option value="div">/</option>
                        </select>
                    </div>
                    <c:if test="${requestScope.ErrorMessage!=null}">
                        <h6>
                            <div class="alert alert-danger my-2" role="alert">
                                    ${requestScope.ErrorMessage}
                            </div>
                        </h6>
                    </c:if>
                </div>
                <div class="form-group row my-2">
                    <label class="col-sm-2 col-form-label">Number2</label>
                    <div class="col-sm-10">
                        <input type="text" name="num2" class="form-control" placeholder="Number2" pattern="[\d]+[.]?[\d]*" required>
                    </div>
                </div>
                <br>
                <button class="btn btn-outline-dark my-2">Submit</button>
                <c:if test="${requestScope.calculatorMessage!=null}">
                    <input type="checkbox" class="btn-check" id="btn-check-2-outlined" checked autocomplete="off">
                    <label class="btn btn-outline-secondary" for="btn-check-2-outlined">${requestScope.calculatorMessage}</label>
                </c:if>
                <br>
            </div>
        </div>
    </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
