<%-- 
    Document   : Lap6_Bai6_student-form
    Created on : Aug 27, 2026, 2:26:29 PM
    Author     : DELL
--%>

<%@page import="Lap6_Bai3.StudentStore"%>
<%@page import="Lap6_Bai3.Student"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- NHÚNG CODE XỬ LÝ KHI NGƯỜI DÙNG BẤM SUBMIT (POST) --%>
<%
    request.setCharacterEncoding("UTF-8");

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String className = request.getParameter("className");
        String email = request.getParameter("email");

        if (id != null && !id.trim().isEmpty()) {
            Student student = new Student(id, name, className, email);
            StudentStore.add(student);
            
            // Chuyển hướng đúng về file danh sách
            response.sendRedirect(request.getContextPath() + "/Lap6_Bai3_student-list.jsp");
            return;
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm sinh viên mới</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4" style="max-width: 500px;">

    <h2 class="text-center text-primary mb-4">THÊM SINH VIÊN MỚI</h2>

    <%-- Sửa action="": Để trống để submit về chính URL hiện tại của trang --%>
    <form action="" method="POST" class="card p-4 shadow-sm">
        <div class="mb-3">
            <label class="form-label">Mã sinh viên:</label>
            <input type="text" name="id" class="form-control" placeholder="Ví dụ: SV003" required />
        </div>

        <div class="mb-3">
            <label class="form-label">Họ và tên:</label>
            <input type="text" name="name" class="form-control" placeholder="Ví dụ: Phạm Quang Văn" required />
        </div>

        <div class="mb-3">
            <label class="form-label">Lớp:</label>
            <input type="text" name="className" class="form-control" placeholder="Ví dụ: DCCNTT12" required />
        </div>

        <div class="mb-3">
            <label class="form-label">Email:</label>
            <input type="email" name="email" class="form-control" placeholder="Ví dụ: van@example.com" required />
        </div>

        <div class="d-flex justify-content-between">
            <a href="${pageContext.request.contextPath}/Lap6_Bai3_student-list.jsp" class="btn btn-secondary">Quay lại</a>
            <button type="submit" class="btn btn-success">Lưu sinh viên</button>
        </div>
    </form>

</body>
</html>