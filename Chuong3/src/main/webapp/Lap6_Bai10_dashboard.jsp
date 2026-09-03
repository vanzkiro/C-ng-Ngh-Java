<%-- 
    Document   : Lap6_Bai10_dashboard
    Created on : Sep 3, 2026, 10:06:20 AM
    Author     : DELL
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="Lap6_Bai3.Student"%>
<%@page import="Lap6_Bai3.StudentStore"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect(request.getContextPath() + "/Lap6_Bai4_login.jsp");
        return;
    }

    String loginTime = (String) session.getAttribute("loginTime");
    if (loginTime == null) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        loginTime = sdf.format(new Date());
        session.setAttribute("loginTime", loginTime);
    }

    List<Student> students = StudentStore.findAll();
    int totalStudents = (students != null) ? students.size() : 0;

    // Thống kê số lượng sinh viên theo lớp
    Map<String, Integer> classCountMap = new HashMap<>();
    if (students != null) {
        for (Student s : students) {
            String className = s.getClassName();
            if (className == null || className.trim().isEmpty()) {
                className = "Chưa xếp lớp";
            }
            classCountMap.put(className, classCountMap.getOrDefault(className, 0) + 1);
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard - Bảng điều khiển</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <!-- Navbar header -->
    <nav class="navbar navbar-dark bg-primary px-4 shadow-sm">
        <span class="navbar-brand mb-0 h1">HỆ THỐNG QUẢN LÝ</span>
        <div class="text-white">
            Xin chào, <strong><%= username %></strong> | 
            <a href="Lap6_Bai4_login.jsp?action=logout" class="btn btn-outline-light btn-sm ms-2">Đăng xuất</a>
        </div>
    </nav>

    <div class="container mt-4">
        <h2 class="text-primary mb-4">DASHBOARD TỔNG QUAN</h2>

        <!-- Khối thông tin tổng quan -->
        <div class="row mb-4">
            <div class="col-md-6 mb-3">
                <div class="card bg-info text-white shadow-sm p-3">
                    <div class="card-body">
                        <h5 class="card-title">TỔNG SỐ SINH VIÊN</h5>
                        <p class="display-4 fw-bold mb-0"><%= totalStudents %></p>
                    </div>
                </div>
            </div>
            
            <div class="col-md-6 mb-3">
                <div class="card bg-secondary text-white shadow-sm p-3">
                    <div class="card-body">
                        <h5 class="card-title">THỜI GIAN ĐĂNG NHẬP</h5>
                        <p class="fs-4 fw-semibold mt-3 mb-0"><%= loginTime %></p>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bảng thống kê theo từng lớp & Liên kết quản lý -->
        <div class="row">
            <div class="col-md-8 mb-3">
                <div class="card shadow-sm">
                    <div class="card-header bg-dark text-white fw-bold">
                        THỐNG KÊ SINH VIÊN THEO LỚP
                    </div>
                    <div class="card-body p-0">
                        <table class="table table-bordered table-hover mb-0">
                            <thead class="table-light text-center">
                                <tr>
                                    <th>STT</th>
                                    <th>Tên lớp</th>
                                    <th>Số lượng sinh viên</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% 
                                    if (!classCountMap.isEmpty()) {
                                        int stt = 1;
                                        for (Map.Entry<String, Integer> entry : classCountMap.entrySet()) {
                                %>
                                    <tr>
                                        <td class="text-center"><%= stt++ %></td>
                                        <td><strong><%= entry.getKey() %></strong></td>
                                        <td class="text-center span fw-bold text-success"><%= entry.getValue() %></td>
                                    </tr>
                                <% 
                                        }
                                    } else {
                                %>
                                    <tr>
                                        <td colspan="3" class="text-center text-muted">Chưa có dữ liệu sinh viên.</td>
                                    </tr>
                                <% } %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <!-- Khối liên kết quản lý -->
            <div class="col-md-4 mb-3">
                <div class="card shadow-sm">
                    <div class="card-header bg-success text-white fw-bold">
                        LIÊN KẾT NHANH
                    </div>
                    <div class="card-body d-grid gap-2">
                        <a href="Lap6_Bai3_student-list.jsp" class="btn btn-outline-primary text-start">
                            Xem Danh sách Sinh viên
                        </a>
                        <a href="Lap6_Bai3_student-form.jsp" class="btn btn-outline-success text-start">
                            Thêm Sinh viên mới
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>