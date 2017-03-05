<%--
  Created by IntelliJ IDEA.
  User: cefothe
  Date: 05.03.17
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
        aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
</button>
<a class="navbar-brand" href="/">SoftUni Store</a>

<div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
        <li class="nav-item">
            <a class="nav-link" href="#">Cart</a>
        </li>
    </ul>
    <ul class="navbar-nav">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="http://example.com" id="AdminDropdownMenuLink"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Admin
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                <a class="dropdown-item" href="/admin/game/all">Games</a>
            </div>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="/logout">Logout</a>
        </li>
    </ul>
</div>
