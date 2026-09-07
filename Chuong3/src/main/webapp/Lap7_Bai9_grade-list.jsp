<%-- 
    Document   : Lap7_Bai9_grade-list
    Created on : Sep 4, 2026, 8:27:29 PM
    Author     : DELL
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty gradeList}">
    <c:redirect url="GradeServlet?action=list" />
</c:if>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản Lý Điểm Sinh Viên - Bài 9</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4 bg-light">

    <div class="card shadow p-4">
        <h2 class="text-center text-primary mb-4">BẢNG ĐIỂM SINH VIÊN</h2>

        <div class="d-flex justify-content-between mb-3">
            <a href="${pageContext.request.contextPath}/Lap6_Bai10_dashboard.jsp" class="btn btn-secondary">
                ← Dashboard
            </a>
            <a href="GradeServlet?action=add" class="btn btn-success fw-bold">
                + Nhập Điểm Mới
            </a>
        </div>

        <table class="table table-bordered table-striped align-middle">
            <thead class="table-dark text-center">
                <tr>
                    <th>Mã SV</th>
                    <th>Họ và Tên</th>
                    <th>Chuyên Cần (10%)</th>
                    <th>Giữa Kỳ (30%)</th>
                    <th>Cuối Kỳ (60%)</th>
                    <th>Tổng Kết</th>
                    <th>Xếp Loại</th>
                    <th style="width: 140px;">Thao Tác</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="g" items="${gradeList}">
                    <tr>
                        <td class="text-center"><strong>${g.studentId}</strong></td>
                        <td>${g.studentName}</td>
                        <td class="text-center">${g.attendanceScore}</td>
                        <td class="text-center">${g.midtermScore}</td>
                        <td class="text-center">${g.finalScore}</td>
                        <td class="text-center fw-bold text-primary">${g.totalScore}</td>
                        <td class="text-center fw-bold">
                            <span class="badge ${g.rank == 'A' ? 'bg-success' : (g.rank == 'B' ? 'bg-info' : (g.rank == 'C' ? 'bg-warning text-dark' : 'bg-danger'))}">
                                ${g.rank}
                            </span>
                        </td>
                        <td class="text-center">
                            <a href="GradeServlet?action=edit&id=${g.studentId}" class="btn btn-warning btn-sm fw-bold">Sửa</a>
                            <a href="GradeServlet?action=delete&id=${g.studentId}" 
                               class="btn btn-danger btn-sm fw-bold" 
                               onclick="return confirm('Bạn có chắc chắn muốn xóa điểm của ${g.studentId}?');">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
