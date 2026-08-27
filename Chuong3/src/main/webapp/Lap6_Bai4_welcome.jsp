<%-- 
    Document   : welcome
    Created on : Aug 27, 2026, 11:12:01 AM
    Author     : DELL
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String loggedUser = (String) session.getAttribute("username");

    if (loggedUser == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }

    // Xử lý nút Đăng xuất
    String action = request.getParameter("action");
    if ("logout".equals(action)) {
        session.invalidate(); // Xóa toàn bộ Session
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang Chào Mừng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5 text-center">

    <div class="card shadow p-5">
        <h1 class="text-success mb-3">CHÀO MỪNG BẠN TRỞ LẠI!</h1>
        <p class="fs-4">Xin chào: <strong class="text-danger"><%= loggedUser %></strong></p>
        
        <div class="mt-4">
            <a href="<%= request.getContextPath() %>/xoa-sv" class="btn btn-info text-white me-2">Quản lý Sinh viên</a>
            <a href="welcome.jsp?action=logout" class="btn btn-outline-danger">Đăng xuất</a>
        </div>
    </div>

</body>
</html>