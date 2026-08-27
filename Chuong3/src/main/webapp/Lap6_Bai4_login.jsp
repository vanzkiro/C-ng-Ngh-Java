<%-- 
    Document   : login
    Created on : Aug 27, 2026, 11:11:43 AM
    Author     : DELL
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    
    String errorMsg = "";

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        if ("admin".equals(user) && "123456".equals(pass)) {
            session.setAttribute("username", user);
            
            response.sendRedirect(request.getContextPath() + "/welcome.jsp");
            return;
        } else {
            errorMsg = "Tên đăng nhập hoặc mật khẩu không chính xác!";
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bài 4 - Đăng nhập Hệ thống</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light d-flex align-items-center justify-content-center" style="height: 100vh;">

    <div class="card shadow p-4" style="width: 380px;">
        <h3 class="text-center text-primary mb-3">ĐĂNG NHẬP</h3>

        <% if (!errorMsg.isEmpty()) { %>
            <div class="alert alert-danger text-center p-2"><%= errorMsg %></div>
        <% } %>

        <form action="login.jsp" method="POST">
            <div class="mb-3">
                <label class="form-label font-weight-bold">Tên đăng nhập:</label>
                <input type="text" name="username" class="form-control" placeholder="Nhập admin" required />
            </div>

            <div class="mb-3">
                <label class="form-label font-weight-bold">Mật khẩu:</label>
                <input type="password" name="password" class="form-control" placeholder="Nhập 123456" required />
            </div>

            <button type="submit" class="btn btn-primary w-100">Đăng nhập</button>
        </form>
    </div>

</body>
</html>