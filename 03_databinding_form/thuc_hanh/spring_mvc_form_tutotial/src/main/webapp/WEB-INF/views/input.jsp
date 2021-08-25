<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 8/23/2021
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>converter</title>
</head>
<body>
<h2>Currency Converter</h2>
<form action="/result" method="post">
    <label>First operand: </label><br/>
    <input type="text" name="first_operand" placeholder="first" value="0"/><br/>
    <label>Operator: </label><br/>
    <select id="operator" name="operator" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
        <option selected>Choose operator</option>
        <option value="1">+</option>
        <option value="2">-</option>
        <option value="3">*</option>
        <option value="4">/</option>
    </select><br/>
    <label>Second operand: </label><br/>
    <input type="text" name="second_operand" placeholder="USD" value="0"/><br/>
    <input type = "submit" id = "submit" value = "Converter"/>
</form>
</body>
</html>
