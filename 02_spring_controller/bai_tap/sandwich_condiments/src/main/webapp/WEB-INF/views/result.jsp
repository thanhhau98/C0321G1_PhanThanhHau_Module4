<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 8/23/2021
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<c:forEach items="${condiments}" var="condiment">
    <h1>${condiment}</h1>
</c:forEach>
<h1></h1>
</body>
</html>
