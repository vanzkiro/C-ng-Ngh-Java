<%-- 
    Document   : Lap7_Bai8_class-list
    Created on : Sep 4, 2026, 8:07:43 PM
    Author     : DELL
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty classList}">
    <c:redirect url="ClassroomServlet?action=list" />
</c:if>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản Lý Lớp Học - Bài 8</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4 bg-light">

    <div class="card shadow p-4">
        <h2 class="text-center text-primary mb-4">QUẢN LÝ LỚP HỌC</h2>

        <!-- Khối Tìm Kiếm & Nút Điều Hướng -->
        <div class="row mb-3">
            <div class="col-md-6">
                <form action="ClassroomServlet" method="GET" class="d-flex">
                    <input type="hidden" name="action" value="search" />
                    <input type="text" name="keyword" class="form-control me-2" 
                           placeholder="Nhập mã hoặc tên lớp..." value="${keyword}" />
                    <button type="submit" class="btn btn-outline-primary fw-bold">Tìm</button>
                </form>
            </div>
            <div class="col-md-6 text-end">
                <a href="${pageContext.request.contextPath}/Lap6_Bai10_dashboard.jsp" class="btn btn-secondary me-2">
                    ← Dashboard
                </a>
                <a href="ClassroomServlet?action=add" class="btn btn-success fw-bold">
                    + Thêm Lớp Mới
                </a>
            </div>
        </div>

        <table class="table table-bordered table-striped align-middle">
            <thead class="table-dark text-center">
                <tr>
                    <th>Mã Lớp</th>
                    <th>Tên Lớp Học</th>
                    <th>Cố Vấn Học Tập</th>
                    <th>Sĩ Số</th>
                    <th style="width: 150px;">Thao Tác</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="c" items="${classList}">
                    <tr>
                        <td class="text-center"><strong>${c.classId}</strong></td>
                        <td>${c.className}</td>
                        <td>${c.advisor}</td>
                        <td class="text-center fw-bold text-success">${c.studentCount}</td>
                        <td class="text-center">
                            <a href="ClassroomServlet?action=edit&id=${c.classId}" class="btn btn-warning btn-sm fw-bold">Sửa</a>
                            <a href="ClassroomServlet?action=delete&id=${c.classId}" 
                               class="btn btn-danger btn-sm fw-bold" 
                               onclick="return confirm('Bạn có chắc chắn muốn xóa lớp ${c.classId}?');">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
