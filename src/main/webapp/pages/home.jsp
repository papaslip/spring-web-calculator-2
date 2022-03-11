<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.01.2022
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">
    </a>
    <img height="30" width="30" src="https://cdn2.iconfinder.com/data/icons/ios7-inspired-mac-icon-set/512/Calculator_512.png" alt="MDN logo">
    <a class="navbar-brand" href="#">
        <a class="navbar-brand" href="/">HOME</a>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <c:if test="${sessionScope.user==null}">
                <div class="navbar-nav">
                    <a class="nav-item nav-link" href="/reg">Registration</a>
                    <a class="nav-item nav-link" href="/login">Authorization</a>
                </div>
            </c:if>
            <c:if test="${sessionScope.user!=null}">
                <div class="navbar-nav">
                    <a class="nav-item nav-link" href="/calculator">Calculator</a>
                    <a class="nav-item nav-link" href="/logout">Logout</a>
                </div>
            </c:if>

        </div>
</nav>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>