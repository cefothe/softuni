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
                <div class="text-center"><h1 class="display-3">Register</h1></div>
                <br/>

                <c:forEach items="${constraintViolations}" var="violation">
                    <div class="alert alert-danger alert-dismissable">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Error!</strong> ${violation.getMessage()}
                    </div>
                </c:forEach>
                <c:choose>
                    <c:when test="${passwordMismatch != null}">
                        <div class="alert alert-danger alert-dismissable">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <strong>Error!</strong> Passwords are not matching
                        </div>
                    </c:when>
                </c:choose>
                <form method="post">

                    <div class="form-group row">
                        <label class="sr-only">Email</label>
                        <input class="form-control" placeholder="somebody@example.com" name="email"/>
                    </div>

                    <div class="form-group row">
                        <label class="sr-only">Full Name</label>
                        <input pattern="^[a-zA-Z -.]+$" class="form-control" placeholder="Full Name" name="fullName"/>
                    </div>

                    <div class="form-group row">
                        <label class="sr-only">Password</label>
                        <input pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" class="form-control" type="password" placeholder="Password" name="password"/>
                    </div>

                    <div class="form-group row">
                        <label class="sr-only">Confirm Password</label>
                        <input pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" class="form-control" type="password" placeholder="Confirm Password" name="repeatPassword"/>
                    </div>

                    <input type="submit" class="btn btn-outline-warning btn-lg btn-block"
                           value="Register"/>
                </form>
                <br/>
            </div>
        </div>
    </div>
</main>

<jsp:include page="footer.jsp" />