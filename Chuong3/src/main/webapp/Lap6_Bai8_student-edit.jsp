<%-- 
    Document   : Lap6_Bai8_student-edit
    Created on : Sep 3, 2026, 10:24:13 AM
    Author     : DELL
--%>



<%@page import="Lap6_Bai3.Student"%>
<%@page import="Lap6_Bai3.StudentStore"%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("UTF-8");

    // 1. Kiểm tra đăng nhập
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect(request.getContextPath() + "/Lap6_Bai4_login.jsp");
        return;
    }

    String errorMsg = "";
    Student student = null;

    // 2. Xử lý khi nhấn nút "Cập nhật" (Submit Form dạng POST)
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String className = request.getParameter("className");
        String email = request.getParameter("email");

        if (name != null && !name.trim().isEmpty()) {
            // Tạo đối tượng Student mới giữ nguyên Mã SV (id) và cập nhật thông tin khác
            Student updatedStudent = new Student(id.trim(), name.trim(), className.trim(), email.trim());
            
            // Gọi hàm update trong StudentStore
            StudentStore.update(updatedStudent);

            // Cập nhật xong chuyển hướng về trang danh sách sinh viên
            response.sendRedirect(request.getContextPath() + "/Lap6_Bai3_student-list.jsp");
            return;
        } else {
            errorMsg = "Họ và tên không được để trống!";
        }
    } else {
        // 3. Xử lý khi mới mở trang (Request GET truyền id qua URL)
        String id = request.getParameter("id");
        if (id != null && !id.trim().isEmpty()) {
            student = StudentStore.findById(id.trim());
        }

        // Nếu không tìm thấy sinh viên -> Chuyển về danh sách
        if (student == null) {
            response.sendRedirect(request.getContextPath() + "/Lap6_Bai3_student-list.jsp");
            return;
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa thông tin Sinh viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container mt-5" style="max-width: 600px;">
        <div class="card shadow">
            <div class="card-header bg-warning text-dark">
                <h4 class="mb-0">CẬP NHẬT THÔNG TIN SINH VIÊN</h4>
            </div>
            <div class="card-body p-4">

                <% if (!errorMsg.isEmpty()) { %>
                    <div class="alert alert-danger"><%= errorMsg %></div>
                <% } %>

                <form action="Lap6_Bai8_student-edit.jsp" method="POST">
                    <!-- Mã sinh viên (Khóa chính - Không cho sửa) -->
                    <div class="mb-3">
                        <label class="form-label fw-bold">Mã Sinh Viên:</label>
                        <input type="text" name="id" class="form-control bg-light" 
                               value="<%= (student != null) ? student.getId() : request.getParameter("id") %>" 
                               readonly />
                        <small class="text-muted">Mã sinh viên là duy nhất và không thể thay đổi.</small>
                    </div>

                    <!-- Họ và tên -->
                    <div class="mb-3">
                        <label class="form-label fw-bold">Họ và Tên:</label>
                        <input type="text" name="name" class="form-control" 
                               value="<%= (student != null) ? student.getName() : request.getParameter("name") %>" 
                               required />
                    </div>

                    <!-- Lớp -->
                    <div class="mb-3">
                        <label class="form-label fw-bold">Lớp:</label>
                        <input type="text" name="className" class="form-control" 
                               value="<%= (student != null) ? student.getClassName() : request.getParameter("className") %>" />
                    </div>

                    <!-- Email -->
                    <div class="mb-3">
                        <label class="form-label fw-bold">Email:</label>
                        <input type="email" name="email" class="form-control" 
                               value="<%= (student != null) ? student.getEmail() : request.getParameter("email") %>" />
                    </div>

                    <!-- Các nút bấm -->
                    <div class="d-flex justify-content-between mt-4">
                        <a href="Lap6_Bai3_student-list.jsp" class="btn btn-secondary">Quay lại danh sách</a>
                        <button type="submit" class="btn btn-warning fw-bold">Lưu thay đổi</button>
                    </div>
                </form>

            </div>
        </div>
    </div>

</body>
</html>