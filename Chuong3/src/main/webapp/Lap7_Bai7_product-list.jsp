<%-- 
    Document   : Lap7_Bai7_product-list
    Created on : Sep 3, 2026, 8:53:41 PM
    Author     : DELL
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--Tự động chuyển sang Servlet nếu vào trực tiếp file JSP để load đủ dữ liệu--%>
<c:if test="${empty products}">
    <c:redirect url="ProductServlet?action=list" />
</c:if>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản Lý Sản Phẩm - Lap7_Bai7</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4 bg-light">

    <div class="card shadow p-4">
        <h2 class="text-center text-primary mb-4">QUẢN LÝ SẢN PHẨM</h2>

        <div class="d-flex justify-content-between mb-3">
            <%-- Đã cập nhật đúng liên kết quay lại Dashboard --%>
            
            <a href="ProductServlet?action=add" class="btn btn-success fw-bold">
                + Thêm Sản Phẩm Mới
            </a>
        </div>

        <table class="table table-bordered table-striped align-middle">
            <thead class="table-dark text-center">
                <tr>
                    <th>Mã SP</th>
                    <th>Tên Sản Phẩm</th>
                    <th>Mô Tả</th>
                    <th>Đơn Giá (VNĐ)</th>
                    <th>Số Lượng</th>
                    <th style="width: 150px;">Thao Tác</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${products}">
                    <tr>
                        <td class="text-center"><strong>${p.id}</strong></td>
                        <td>${p.name}</td>
                        <td>${p.description}</td>
                        <td class="text-end fw-bold text-success">
                            <fmt:formatNumber value="${p.price}" pattern="#,##0"/> đ
                        </td>
                        <td class="text-center">${p.quantity}</td>
                        <td class="text-center">
                            <a href="ProductServlet?action=edit&id=${p.id}" class="btn btn-warning btn-sm fw-bold">Sửa</a>
                            <a href="ProductServlet?action=delete&id=${p.id}" 
                               class="btn btn-danger btn-sm fw-bold" 
                               onclick="return confirm('Bạn có chắc chắn muốn xóa sản phẩm ${p.id}?');">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>