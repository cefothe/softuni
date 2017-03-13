<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <nav class="navbar navbar-toggleable-md navbar-light bg-warning">
        <div class="container">
            <c:choose>
                <c:when test="${applicationUser == 'GUEST'}">
                    <jsp:include page="guest-menu.jsp"/>
                </c:when>
                <c:when test="${applicationUser == 'USER'}">
                    <jsp:include page="user-menu.jsp"/>
                </c:when>
                <c:when test="${applicationUser == 'ADMIN'}">
                    <jsp:include page="admin-menu.jsp"/>
                </c:when>
            </c:choose>

        </div>
    </nav>
</header>
