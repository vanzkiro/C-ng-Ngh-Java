<%-- 
    Document   : Lap6_Bai3_student-list
    Created on : Aug 27, 2026, 2:27:32 PM
    Author     : DELL
--%>

<%@page import="Lap6_Bai3.StudentStore"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- NHÚNG CODE NẠP DANH SÁCH TỪ STORE VÀO REQUEST --%>
<%
    request.setAttribute("students", StudentStore.findAll());
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách sinh viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

    <h2 class="text-center text-primary mb-4">DANH SÁCH SINH VIÊN</h2>

    <div class="mb-3 text-end">
        <%-- Sửa lại đường dẫn khớp với tên file form thực tế --%>
        <a href="${pageContext.request.contextPath}/Lap6_Bai3_student-form.jsp" class="btn btn-primary">
            + Thêm sinh viên mới
        </a>
    </div>

    <table class="table table-bordered table-striped table-hover align-middle">
        <thead class="table-dark text-center">
            <tr>
                <th>Mã SV</th>
                <th>Họ tên</th>
                <th>Lớp</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <%-- Sử dụng JSTL c:forEach để duyệt danh sách --%>
            <c:forEach var="sv" items="${students}">
                <tr>
                    <td class="text-center"><strong>${sv.id}</strong></td>
                    <td>${sv.name}</td>
                    <td class="text-center">${sv.className}</td>
                    <td>${sv.email}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>