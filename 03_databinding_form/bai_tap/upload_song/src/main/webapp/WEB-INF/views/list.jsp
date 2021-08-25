<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 8/23/2021
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<table border="1">
    <caption>Songs List</caption>
    <thead>
    <tr>
        <th>Name</th>
        <th>Singer</th>
        <th>Category</th>
        <th>Link</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${songs}">
        <tr>
            <td>
                <c:out value="${c.name}"/>
            </td>
            <td>
                <c:out value="${c.singer}"/>
            </td>
            <td>
                <c:out value="${c.category}"/>
            </td>
            <td>
                <c:out value="${c.link}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
