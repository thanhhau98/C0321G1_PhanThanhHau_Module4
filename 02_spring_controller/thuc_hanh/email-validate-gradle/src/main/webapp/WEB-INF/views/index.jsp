<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 8/23/2021
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Email Validation</title>
  </head>
  <body>
  <h1>Email Validate</h1>
  <h3 style="color: red"> ${message}</h3>
  <form action="/validate" method="post">
    <input type="text" name="email"><br>
    <input type="submit" value="Validate">
  </form>
  </body>
</html>
