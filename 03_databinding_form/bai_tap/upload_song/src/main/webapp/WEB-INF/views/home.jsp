<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 8/25/2021
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Email</title>
</head>
<body>
<h3>Home</h3>
<form:form action="update" method="post" modelAttribute="song">
    <fieldset>
        <legend>Settings</legend>
        <table>
            <tr>
                <td><form:label path="name">Name: </form:label></td>
                <td><form:input path="name"></form:input></td>
            </tr>
            <tr>
                <td><form:label path="singer">Singer: </form:label></td>
                <td><form:input path="singer"></form:input></td>
            </tr>
            <tr>
                <td><form:label path="category">Signature:</form:label></td>
                <td><form:textarea path="category"></form:textarea></td>
            </tr>
            <tr>
                <td><form:label path="link">Link: </form:label></td>
                <td><form:input path="link"></form:input></td>
            </tr>
            <tr>
                <td><input type="submit" value="Update"></td>
                <td><input type="submit" value="Cancel"></td>
            </tr>

        </table>
    </fieldset>
</form:form>
</body>
</html>
