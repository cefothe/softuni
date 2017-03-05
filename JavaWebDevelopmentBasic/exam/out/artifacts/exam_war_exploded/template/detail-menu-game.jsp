<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${applicationUser == 'ADMIN'}">
        <a class="btn btn-outline-primary" href="/">Back</a>
        <a class="btn btn-warning" href="/admin/game/edit/${game.id}">Edit</a>
        <a class="btn btn-danger" href="/admin/game/delete/${game.id}">Delete</a>
        <a class="btn btn-primary" href="#">Buy</a>
    </c:when>
    <c:otherwise>
        <a class="btn btn-outline-primary" href="/">Back</a>
        <a class="btn btn-primary" href="#">Buy</a>
    </c:otherwise>
</c:choose>