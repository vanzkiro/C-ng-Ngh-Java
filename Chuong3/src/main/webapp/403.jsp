<%-- 
    Document   : 403
    Created on : Sep 3, 2026, 8:42:16 PM
    Author     : DELL
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>403 - Truy cập bị từ chối</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light d-flex align-items-center justify-content-center vh-100">

    <div class="card shadow p-4 text-center" style="max-width: 500px;">
        <h1 class="display-1 text-danger fw-bold">403</h1>
        <h3 class="text-dark mb-3">TRUY CẬP BỊ TỪ CHỐI</h3>
        <p class="text-muted mb-4">
            Tài khoản của bạn không có quyền thực hiện chức năng quản trị (thêm, sửa, xóa).
        </p>
        <div>
            <a href="Lap6_Bai10_dashboard.jsp" class="btn btn-primary me-2">Về Dashboard</a>
            <a href="Lap6_Bai3_student-list.jsp" class="btn btn-outline-secondary">Xem Danh sách</a>
        </div>
    </div>

</body>
</html>