<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="header.jsp" />
</head>
<body>
    <jsp:include page="menu.jsp"/>
<main class="col-4 offset-4 text-center">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="text-center"><h1 class="display-3">Login</h1></div>
                <br/>
                <c:choose>
                    <c:when test="${loginError != null}">
                        <div class="alert alert-danger alert-dismissable">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>Error!</strong> No such user
                        </div>
                    </c:when>
                </c:choose>
                <form method="post">
                    <div class="form-group row">
                        <label class="sr-only">Email</label>
                        <input class="form-control" placeholder="somebody@example.com" name="email"/>
                    </div>
                    <div class="form-group row">
                        <label class="sr-only">Password</label>
                        <input class="form-control" placeholder="Password" type="password" name="password"/>
                    </div>

                    <input type="submit" class="btn btn-outline-warning btn-lg btn-block"
                           value="Login"/>
                </form>
                <br/>
            </div>
        </div>
    </div>
</main>
<br/>



<jsp:include page="footer.jsp" />