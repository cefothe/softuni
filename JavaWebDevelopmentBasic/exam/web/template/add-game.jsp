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
                <div class="text-center"><h1 class="display-3">Add Game</h1></div>
                <br/>
                <c:forEach items="${constraintViolations}" var="violation">
                    <div class="alert alert-danger alert-dismissable">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                        <strong>Error!</strong> ${violation.getMessage()}
                    </div>
                </c:forEach>

                <form method="post">
                    <div class="form-group row">
                        <label class="form-control-label">Title</label>
                        <input pattern="[A-Z].{3,100}" class="form-control"
                               placeholder="Enter Game Title" name="title"/>
                    </div>

                    <div class="form-group row">
                        <label class="form-control-label">Description</label>
                        <textarea class="form-control" placeholder="Enter Game Description" minlength="20" name="description"></textarea>
                    </div>

                    <div class="form-group row">
                        <label class="form-control-label">Thumbnail</label>
                        <input type="url" class="form-control" placeholder="Enter URL to Image" name="imageThumbnail"/>
                    </div>

                    <div class="form-group row">
                        <label class="form-control-label">Price</label>
                        <div class="input-group">

                            <input step="0.01" min="0" class="form-control" placeholder="Enter Price" name="price"/>
                            <span class="input-group-addon">&euro;</span>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="form-control-label">Size</label>
                        <div class="input-group">

                            <input step="0.1" min="0" class="form-control" placeholder="Enter Size" name="size"/>
                            <span class="input-group-addon">GB</span>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="form-control-label">YouTube Video URL</label>
                        <div class="input-group">
                            <span class="input-group-addon">https://www.youtube.com/watch?v=</span>
                            <input class="form-control" minlength="11" maxlength="11" name="trailer"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="form-control-label">Release Date</label>
                        <input type="date" class="form-control" placeholder="yyyy-MM-dd" name="releaseDate"/>
                    </div>

                    <input type="submit" id="btn-add-game" class="btn btn-outline-success btn-lg btn-block"
                           value="Add Game"/>
                </form>
                <br/>
            </div>
        </div>
    </div>
</main>
<br/>


<jsp:include page="footer.jsp" />