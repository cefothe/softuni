<%@ page import="java.util.List" %>
<%@ page import="servlet.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="menu.jsp" />
    <%! int age=55;  %>
    <%= new String("Hello from JSP") %>
    <% age++; %>
    <%= age %>

    <%! int element =10; %>
    <% for (int i =0; i < element; i++){ %>
        <div style="color:green">
            <%=i%>
        </div>
    <%}%>

    <%! List<String> weekdays; %>
    <%
        weekdays = (List<String>)request.getAttribute("weekdays");
        weekdays.add("Monday");

    %>
    <% for (String weekday: weekdays) { %>
        <p>
        <%=weekday%>
        </p>
    <%}%>

    <%! int readBooks = 5; %>
    <% if(readBooks>6) { %>
        <div>Book is more then 6</div>
    <% }else { %>
        <div>Book is less then 6</div>
    <% } %>

<%! Person person = new Person(); %>
</body>
</html>
