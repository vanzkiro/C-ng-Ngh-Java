<%-- 
    Document   : Lap7_Bai9_grade-form
    Created on : Sep 4, 2026, 8:27:51 PM
    Author     : DELL
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nhập Điểm Sinh Viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light d-flex align-items-center justify-content-center" style="min-height: 100vh;">

    <div class="card shadow p-4" style="width: 480px;">
        <h3 class="text-center text-primary mb-3">
            ${grade != null && grade.studentId != null ? "CẬP NHẬT ĐIỂM" : "NHẬP ĐIỂM SINH VIÊN"}
        </h3>

        <c:if test="${not empty errorMsg}">
            <div class="alert alert-danger p-2 text-center">${errorMsg}</div>
        </c:if>

        <form action="GradeServlet" method="POST">
            <div class="mb-3">
                <label class="form-label fw-bold">Mã sinh viên:</label>
                <input type="text" name="studentId" class="form-control" value="${grade.studentId}" 
                       ${grade != null && grade.studentId != null ? "readonly" : ""} required />
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Họ và tên:</label>
                <input type="text" name="studentName" class="form-control" value="${grade.studentName}" required />
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Điểm Chuyên Cần (0 - 10):</label>
                <input type="number" step="0.1" name="attendanceScore" class="form-control" value="${grade.attendanceScore}" required />
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Điểm Giữa Kỳ (0 - 10):</label>
                <input type="number" step="0.1" name="midtermScore" class="form-control" value="${grade.midtermScore}" required />
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Điểm Cuối Kỳ (0 - 10):</label>
                <input type="number" step="0.1" name="finalScore" class="form-control" value="${grade.finalScore}" required />
            </div>

            <div class="d-flex justify-content-between">
                <a href="GradeServlet?action=list" class="btn btn-secondary">Hủy bỏ</a>
                <button type="submit" class="btn btn-primary">Lưu Bảng Điểm</button>
            </div>
        </form>
    </div>

</body>
</html>