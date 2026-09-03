<%-- 
    Document   : Lap6_Bai3_student-list
    Created on : Aug 27, 2026, 2:27:32 PM
    Author     : DELL
--%>

<%@page import="Lap6_Bai3.StudentStore"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    request.setAttribute("students", StudentStore.findAll());
    
    // Lấy thông tin role từ Session
    String role = (String) session.getAttribute("role");
    boolean isAdmin = "ADMIN".equalsIgnoreCase(role);
    request.setAttribute("isAdmin", isAdmin);
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

    <div class="d-flex justify-content-between align-items-center mb-3">
        <a href="${pageContext.request.contextPath}/Lap6_Bai10_dashboard.jsp" class="btn btn-secondary">
            ← Quay lại Dashboard
        </a>
        
        <%-- Chỉ ADMIN mới thấy nút Thêm sinh viên --%>
        <c:if test="${isAdmin}">
            <a href="${pageContext.request.contextPath}/Lap6_Bai3_student-form.jsp" class="btn btn-primary">
                + Thêm sinh viên mới
            </a>
        </c:if>
    </div>

    <table class="table table-bordered table-striped table-hover align-middle">
        <thead class="table-dark text-center">
            <tr>
                <th>Mã SV</th>
                <th>Họ tên</th>
                <th>Lớp</th>
                <th>Email</th>
                <c:if test="${isAdmin}">
                    <th style="width: 120px;">Hành động</th>
                </c:if>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="sv" items="${students}">
                <tr>
                    <td class="text-center"><strong>${sv.id}</strong></td>
                    <td>${sv.name}</td>
                    <td class="text-center">${sv.className}</td>
                    <td>${sv.email}</td>
                    
                    <%-- Chỉ ADMIN mới thấy cột và nút Sửa --%>
                    <c:if test="${isAdmin}">
                        <td class="text-center">
                            <a href="${pageContext.request.contextPath}/Lap6_Bai8_student-edit.jsp?id=${sv.id}" 
                               class="btn btn-sm btn-warning fw-bold">
                                Sửa
                            </a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>