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
    <style>
        span {
            color: red;
        }
    </style>
</head>
<body>
<h2 style="text-align: center">TỜ KHAI Y TẾ</h2>
<h3 style="text-align: center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN
    THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h3>
<h4 style="text-align: center;color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử
    lý hình sự</h4>
<form:form action="update" method="post" modelAttribute="information">
    <table>
        <tr>
            <td > <form:label path="hoTen">Họ tên(ghi chữ IN HOA): </form:label> </td>
            <td >
                <form:input path="hoTen"></form:input>
            </td>
        </tr>
        <tr>
            <td colspan="2"><form:label path="namSinh">Năm sinh<span>(*)</span>: </form:label></td>
            <td colspan="2"><form:label path="gioiTinh">Giới tính<span>(*)</span>: </form:label></td>
            <td colspan="2"><form:label path="quocTich">Quốc tịch<span>(*)</span>: </form:label></td>
        </tr>
        <tr>
            <td colspan="2"><form:input path="namSinh"></form:input></td>
            <td colspan="2"><form:input path="gioiTinh"></form:input></td>
            <td colspan="2"><form:input path="quocTich"></form:input></td>
        </tr>
        <tr>
            <td colspan="6"><form:label path="cmnd">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác<span>(*)</span>: </form:label></td>
        </tr>
        <tr>
            <td colspan="6">
                <form:input path="cmnd"></form:input>
            </td>
        </tr>
        <tr>
            <td colspan="6"><form:label path="phuongTien">Thông tin đi lại<span>(*)</span>: </form:label></td>
        </tr>
        <tr>
            <td colspan="6">
                <form:radiobutton path="cmnd" value="1"></form:radiobutton> Tàu bay
                <form:radiobutton path="cmnd" value="2"></form:radiobutton> Tàu thuyền
                <form:radiobutton path="cmnd" value="3"></form:radiobutton> Ô tô
                <form:radiobutton path="cmnd" value="4"></form:radiobutton> Khác (Ghi rõ)
            </td>
        </tr>
        <tr>
            <td colspan="3"><form:label path="ngayKhoiHanh">Ngày khời hành<span>(*)</span>: </form:label></td>
            <td colspan="3"><form:label path="ngayKetThuc">Ngày kết thúc<span>(*)</span>: </form:label></td>
        </tr>
        <tr>
            <td colspan="2"><form:input path="ngayKhoiHanh"></form:input></td>
            <td colspan="2"><form:input path="ngayKetThuc"></form:input></td>
        </tr>
        <tr>
            <td colspan="6"><form:label path="thanhPho">Trong 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào ?<span>(*)</span>: </form:label></td>
        </tr>
        <tr>
            <td colspan="6">
                <form:input path="thanhPho"></form:input>
            </td>
        </tr>
        <tr>
            <td colspan="6"><form:label path="diaChi">Địa chỉ liên lạc<span>(*)</span>: </form:label></td>
        </tr>
        <tr>
            <td colspan="6">
                <form:input path="diaChi"></form:input>
            </td>
        </tr>
        <tr>
            <td colspan="6"><form:label path="dauHieu">Trong 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không?<span>(*)</span>: </form:label></td>
        </tr>
        <tr>
            <td colspan="6">
                <form:input path="dauHieu"></form:input>
            </td>
        </tr>
        <tr>
            <td colspan="6"><form:label path="lichSu">Lịch sử phơi nhiễm: Trong vòng 14 ngày qua , Anh/Chị có<span>(*)</span>: </form:label></td>
        </tr>
        <tr>
            <td colspan="6">
                <form:input path="lichSu"></form:input>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="GỬI TỜ KHAI"></td>
        </tr>

    </table>
</form:form>
</body>
</html>
