<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 8/23/2021
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Condiments</title>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form:form action="/save" method="post">
    <table>
        <tr>
            <td><form:label path="condiment">Condiment</form:label></td>
            <td>
                <form:checkboxes items="${condiments}"
                                 path="condiment" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
