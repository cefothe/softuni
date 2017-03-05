<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
            <div class="col-12">
                <div class="text-center"><h1 class="display-3">SoftUni Store</h1></div>

                <form class="form-inline">
                    Filter:
                    <input type="submit" name="filter" class="btn btn-link" value="All"/>
                    <input type="submit" name="filter" class="btn btn-link" value="Owned"/>
                </form>
                <c:set var="rowNumber" scope="page" value="${0}"/>
                <c:set var="ziro" scope="page" value="${0}"></c:set>
                <c:set var="three" scope="page" value="${3}"></c:set>
                <c:forEach items="${games}" var="game">
                <c:choose>
                    <c:when test="${rowNumber == ziro}">
                         <div class="card-group">

                    </c:when>
                </c:choose>
                    <c:set var="rowNumber" value="${rowNumber + 1}" scope="page"/>
                    <div class="card col-4 thumbnail">
                        <img
                                class="card-image-top img-fluid img-thumbnail"
                                onerror="this.src='https://i.ytimg.com/vi/BqJyluskTfM/maxresdefault.jpg';"
                                src="${game.imageThumbnail}">

                        <div class="card-block">
                            <h4 class="card-title">${game.title}</h4>
                            <p class="card-text"><strong>Price</strong> - ${game.price}&euro;</p>
                            <p class="card-text"><strong>Size</strong> - ${game.size} GB</p>
                            <p class="card-text">${fn:substring(game.description, 0, 300)}</p>
                        </div>

                        <div class="card-footer">
                            <a class="card-button btn btn-outline-primary" name="info" href="#">Info</a>
                            <a class="card-button btn btn-primary" name="buy" href="#">Buy</a>
                        </div>

                    </div>
                <c:choose>

                    <c:when test="${rowNumber == three}">
                    </div>
                     <c:set var="rowNumber" value="${0}" scope="page"/>
                    </c:when>
                </c:choose>
                </c:forEach>
            </div>
        </div>
    </div>
</main>
<br/>



<jsp:include page="footer.jsp" />
