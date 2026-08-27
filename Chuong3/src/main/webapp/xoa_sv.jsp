<%-- 
    Document   : xoa_sv
    Created on : Aug 27, 2026, 10:31:17 AM
    Author     : DELL
--%>

<%@page import="Lap6_Bai7.Student1"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bài 2 - Xóa sinh viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

    <h2 class="text-center text-danger mb-4">DANH SÁCH & XÓA SINH VIÊN</h2>

    <%
        List<Student1> students = (List<Student1>) request.getAttribute("students");
        if (students != null && !students.isEmpty()) {
    %>
        <table class="table table-bordered table-hover align-middle border-danger">
            <thead class="table-dark text-center">
                <tr>
                    <th>STT</th>
                    <th>Mã SV</th>
                    <th>Họ và tên</th>
                    <th>Quê quán</th>
                    <th>Thao tác</th>
                </tr>
            </thead>
            <tbody>
                <% for (Student1 s : students) { %>
                    <tr>
                        <td class="text-center"><%= s.getStt() %></td>
                        <td class="text-center"><%= s.getMaSV() %></td>
                        <td><%= s.getName() %></td>
                        <td><%= s.getQueQuan() %></td>
                        <td class="text-center">
                            <a href="<%= request.getContextPath() %>/xoa-sv?maSV=<%= s.getMaSV() %>" 
                               class="btn btn-danger btn-sm"
                               onclick="return confirm('Bạn có chắc muốn xóa sinh viên mã <%= s.getMaSV() %>?');">
                               Xóa
                            </a>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    <% } else { %>
        <div class="alert alert-info text-center">
            Danh sách sinh viên trống! 
            <br><br>
            <a href="<%= request.getContextPath() %>/xoa-sv" class="btn btn-primary btn-sm">Tải lại danh sách</a>
        </div>
    <% } %>

</body>
</html>