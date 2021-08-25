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
<h2 style="text-align: center">TỜ KHAI Y TẾ</h2>
<h3>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h3>
<form:form action="update" method="post" modelAttribute="email">
    <fieldset>
        <legend>Settings</legend>
        <table>
            <tr>
                <td><form:label path="language">languages: </form:label></td>
                <td>
                    <form:select path="language">
                    <form:option value="English">English</form:option>
                    <form:option value="Vietnamese">Vietnamese</form:option>
                    <form:option value="Japanese">Japanese</form:option>
                    <form:option value="Chinese">Chinese</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><form:label path="pageSize">Page Size:</form:label></td>
                <td>Show
                    <form:select path="pageSize" >
                        <form:option value="5">5</form:option>
                        <form:option value="10">10</form:option>
                        <form:option value="15">15</form:option>
                        <form:option value="25">25</form:option>
                        <form:option value="50">50</form:option>
                        <form:option value="100">100</form:option>
                    </form:select>
                    emails per page
                </td>
            </tr>
            <tr>
                <td><form:label path="spamsFilter">Spams Filter:</form:label></td>
                <td><form:checkbox value="true" path="spamsFilter"></form:checkbox> Enale spams filter</td>
            </tr>

            <tr>
                <td><form:label path="signature">Signature:</form:label></td>
                <td><form:textarea path="signature"></form:textarea></td>
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
