<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="header.jsp" />
</head>
<body>
<jsp:include page="menu.jsp"/>
<main>
    <div class="container">
        <div class="row">
            <h2 class="m-1">All Games &ndash;&nbsp;</h2> <a href="/game/add" class="btn btn-warning m-1"><strong>+</strong> Add
            Game</a>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Size</th>
                    <th>Price</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:set var="rowNumber" scope="page" value="${0}"/>
                <c:forEach items="${games}" var="game">
                    <tr class="table-warning">
                        <th scope="row"><c:out value="${rowNumber}"/></th>
                        <td>${game.title}</td>
                        <td>${game.size} GB</td>
                        <td>${game.price} &euro;</td>
                        <td>
                            <a href="/game/edit/<c:out value="${game.id}"/>" class="btn btn-warning btn-sm">Edit</a>
                            <a href="/game/delete/<c:out value="${game.id}"/>" class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                    <c:set var="rowNumber" value="${rowNumber + 1}" scope="page"/>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</main>

<br/>



<jsp:include page="footer.jsp" />