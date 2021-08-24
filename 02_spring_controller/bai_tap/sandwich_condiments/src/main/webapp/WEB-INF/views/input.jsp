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
<form action="/save" method="post">
    <label>Lettuce</label>
    <input type="checkbox" name="condiments" value="lettuce">
    <label>Tomato</label>
    <input type="checkbox" name="condiments" value="tomato">
    <label>Mustard</label>
    <input type="checkbox" name="condiments" value="mustard">
    <label>Sprouts</label>
    <input type="checkbox" name="condiments" value="sprouts">
    <input type="submit" value="Save">
</form>
</body>
</html>
