<%-- 
    Document   : Lap7_Bai7_product-form
    Created on : Sep 3, 2026, 8:54:06 PM
    Author     : DELL
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${product != null && product.id != null ? "Sửa Sản Phẩm" : "Thêm Sản Phẩm Mới"}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light d-flex align-items-center justify-content-center" style="min-height: 100vh;">

    <div class="card shadow p-4 my-4" style="width: 500px;">
        <h3 class="text-center text-primary mb-3">
            ${product != null && product.id != null ? "CẬP NHẬT SẢN PHẨM" : "THÊM SẢN PHẨM MỚI"}
        </h3>

        <!-- Hiển thị thông báo lỗi Validate -->
        <c:if test="${not empty errorMsg}">
            <div class="alert alert-danger p-2 text-center">${errorMsg}</div>
        </c:if>

        <form action="ProductServlet" method="POST">
            <%-- Đánh dấu chế độ Edit --%>
            <c:if test="${product != null && product.id != null}">
                <input type="hidden" name="isEdit" value="true" />
            </c:if>

            <div class="mb-3">
                <label class="form-label fw-bold">Mã sản phẩm:</label>
                <input type="text" name="id" class="form-control" value="${product.id}" 
                       ${product != null && product.id != null ? "readonly" : ""} required />
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Tên sản phẩm:</label>
                <input type="text" name="name" class="form-control" value="${product.name}" required />
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Mô tả:</label>
                <textarea name="description" class="form-control" rows="3">${product.description}</textarea>
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Đơn giá (> 0):</label>
                <input type="number" step="any" name="price" class="form-control" value="${product.price}" required />
            </div>

            <div class="mb-3">
                <label class="form-label fw-bold">Số lượng (>= 0):</label>
                <input type="number" name="quantity" class="form-control" value="${product.quantity}" required />
            </div>

            <div class="d-flex justify-content-between">
                <a href="ProductServlet?action=list" class="btn btn-secondary">Hủy bỏ</a>
                <button type="submit" class="btn btn-primary">Lưu sản phẩm</button>
            </div>
        </form>
    </div>

</body>
</html>