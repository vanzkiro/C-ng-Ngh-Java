<%-- 
    Document   : students
    Created on : Aug 27, 2026, 10:09:18 AM
    Author     : DELL
--%>

<%@page import="Lap6_Bai6.Student"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách sinh viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

    <h2 class="text-center text-primary mb-4">QUẢN LÝ SINH VIÊN</h2>

    <!-- Ô tìm kiếm -->
    <form action="${pageContext.request.contextPath}/students" method="GET" class="row g-2 mb-4 justify-content-center">
        <div class="col-auto">
            <input type="text" name="keyword" class="form-control" 
                   placeholder="Nhập họ tên sinh viên..." 
                   value="<%= request.getAttribute("keyword") != null ? request.getAttribute("keyword") : "" %>">
        </div>
        <div class="col-auto">
            <button type="submit" class="btn btn-primary">Tìm kiếm</button>
            <a href="${pageContext.request.contextPath}/students" class="btn btn-secondary">Làm mới</a>
        </div>
    </form>

    <%
        List<Student> students = (List<Student>) request.getAttribute("students");
        if (students != null && !students.isEmpty()) {
    %>
        <table class="table table-bordered table-hover border-primary">
            <thead class="table-dark text-center">
                <tr>
                    <th>STT</th>
                    <th>Mã SV</th>
                    <th>Họ và tên</th>
                    <th>Quê quán</th>
                </tr>
            </thead>
            <tbody>
                <% for (Student s : students) { %>
                    <tr>
                        <td class="text-center"><%= s.getStt() %></td>
                        <td><%= s.getMaSV() %></td>
                        <td><%= s.getName() %></td>
                        <td><%= s.getQueQuan() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    <%
        } else {
    %>
        <div class="alert alert-warning text-center" role="alert">
            Không tìm thấy sinh viên nào phù hợp với từ khóa!
        </div>
    <%
        }
    %>

</body>
</html>