<%-- 
    Document   : BT_C3_Bai2
    Created on : Aug 26, 2026, 1:06:28 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bài 2 - Bảng Sinh Viên Bootstrap</title>
        <!-- Nhúng Bootstrap 5 CDN -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="container mt-4">

        <h2 class="text-center mb-4 text-primary">DANH SÁCH SINH VIÊN</h2>

        <!-- 
            - table             : Class cơ bản tạo định dạng bảng
            - table-bordered    : Tạo màu viền bao quanh tất cả các ô
            - border-primary    : Thiết lập màu viền (màu xanh primary)
            - table-success     : Thiết lập màu nền và màu chữ cho bảng (nền xanh lá nhạt)
            - table-hover       : Hiệu ứng đổi màu nền khi rê chuột qua dòng
        -->
        <table class="table table-bordered border-primary table-success table-hover">
            <!-- Tiêu đề bảng với màu nền tối (table-dark) và màu chữ trắng -->
            <thead class="table-dark text-center">
                <tr>
                    <th>STT</th>
                    <th>Mã SV</th>
                    <th>Họ và tên</th>
                    <th>Quê quán</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="text-center">1</td>
                    <td>20231249</td>
                    <td>Phạm Quang Văn</td>
                    <td>Hà Nội</td>
                </tr>
                <tr>
                    <td class="text-center">2</td>
                    <td>20231221</td>
                    <td>Lê Xuân Huynh</td>
                    <td>Ninh Bình</td>
                </tr>
                <tr>
                    <td class="text-center">3</td>
                    <td>20231177</td>
                    <td>Hứa Đức Lương</td>
                    <td>Nam Định</td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
