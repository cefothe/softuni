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
                <div class="col-12 text-center">

                    <h1 class="display-3">${game.title}</h1>
                    <br/>

                    <iframe width="560" height="315" src="https://www.youtube.com/embed/${game.trailer}" frameborder="0"
                            allowfullscreen></iframe>

                    <br/>
                    <br/>

                    <p>${game.description}</p>

                    <p><strong>Price</strong> - ${game.price}&euro;</p>
                    <p><strong>Size</strong> - ${game.size} GB</p>
                    <p><strong>Release Date</strong> - ${game.releaseDateString}</p>

                    <jsp:include page="detail-menu-game.jsp"/>
                    <br/>
                    <br/>

                </div>
            </div>
        </div>
    </main>
    <br/>




<jsp:include page="footer.jsp" />