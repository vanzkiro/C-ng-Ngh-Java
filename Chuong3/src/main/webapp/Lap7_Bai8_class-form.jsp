<%-- 
    Document   : Lap7_Bai8_class-form
    Created on : Sep 4, 2026, 8:08:18 PM
    Author     : DELL
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Biểu Mẫu Lớp Học</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light d-flex align-items-center justify-content-center" style="min-height: 100vh;">

    <div class="card shadow p-4" style="width: 480px;">
        <h3 class="text-center text-primary mb-3">
            ${classroom != null && classroom.classId != null ? "CẬP NHẬT LỚP HỌC" : "THÊM LỚP HỌC MỚI"}
        </h3>

        <c:if test="${not empty errorMsg}">
            <div class="alert alert-danger p-2 text-center">${errorMsg}</div>
        </c:if>

        <form action="ClassroomServlet" method="POST">
            <div class="mb-3">
                <label class="form-label fw-bold">Mã lớp:</label>
                <input type="text" name="classId" class="form-control" value="${classroom.classId}" 
                       ${classroom != null && classroom.classId != null ? "readonly" : ""} required />
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Tên lớp học:</label>
                <input type="text" name="className" class="form-control" value="${classroom.className}" required />
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Cố vấn học tập:</label>
                <input type="text" name="advisor" class="form-control" value="${classroom.advisor}" required />
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Sĩ số (>= 0):</label>
                <input type="number" name="studentCount" class="form-control" value="${classroom.studentCount}" required />
            </div>

            <div class="d-flex justify-content-between">
                <a href="ClassroomServlet?action=list" class="btn btn-secondary">Hủy bỏ</a>
                <button type="submit" class="btn btn-primary">Lưu Lớp Học</button>
            </div>
        </form>
    </div>

</body>
</html>
