<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Lập phiếu mượn - Thư Viện DVC" scope="request"/>
<%@ include file="../common/header.jsp" %>

<h4 class="mb-3"><i class="bi bi-plus-circle"></i> Lập phiếu mượn mới</h4>

<div class="card">
  <div class="card-body">
    <form method="post" action="${pageContext.request.contextPath}/phieumuon" id="frmPhieuMuon">
      <div class="row g-3 mb-3">
        <div class="col-md-6">
          <label class="form-label">Độc giả <span class="text-danger">*</span></label>
          <select name="maDg" class="form-select" required>
            <option value="">-- Chọn độc giả --</option>
            <c:forEach var="dg" items="${docGiaList}">
              <c:if test="${dg.trangThai == 1}">
                <option value="${dg.maDg}">${dg.hoTen} - ${dg.sdt}</option>
              </c:if>
            </c:forEach>
          </select>
        </div>
        <div class="col-md-6">
          <label class="form-label">Ghi chú</label>
          <input type="text" name="ghiChu" class="form-control" placeholder="Ghi chú (không bắt buộc)">
        </div>
      </div>

      <hr>
      <div class="d-flex justify-content-between align-items-center mb-2">
        <label class="form-label mb-0 fw-bold">Danh sách sách mượn</label>
        <button type="button" class="btn btn-sm btn-outline-primary" id="btnAddRow"><i class="bi bi-plus"></i> Thêm dòng</button>
      </div>

      <table class="table" id="tblSach">
        <thead><tr><th style="width:60%">Sách</th><th style="width:20%">Số lượng</th><th></th></tr></thead>
        <tbody>
          <tr>
            <td>
              <select name="maSach" class="form-select" required>
                <option value="">-- Chọn sách --</option>
                <c:forEach var="s" items="${sachList}">
                  <c:if test="${s.trangThai == 1 && s.soLuongCon > 0}">
                    <option value="${s.maSach}">${s.tenSach} (còn ${s.soLuongCon})</option>
                  </c:if>
                </c:forEach>
              </select>
            </td>
            <td><input type="number" name="soLuongMuon" class="form-control" min="1" value="1" required></td>
            <td><button type="button" class="btn btn-sm btn-outline-danger btnRemoveRow"><i class="bi bi-x"></i></button></td>
          </tr>
        </tbody>
      </table>

      <div class="mt-4">
        <button type="submit" class="btn btn-primary"><i class="bi bi-save"></i> Lập phiếu mượn</button>
        <a href="${pageContext.request.contextPath}/phieumuon" class="btn btn-outline-secondary">Hủy</a>
      </div>
    </form>
  </div>
</div>

<script>
document.getElementById('btnAddRow').addEventListener('click', function () {
  var tbody = document.querySelector('#tblSach tbody');
  var newRow = tbody.rows[0].cloneNode(true);
  newRow.querySelectorAll('select, input').forEach(function (el) {
    if (el.tagName === 'SELECT') el.selectedIndex = 0;
    if (el.tagName === 'INPUT') el.value = 1;
  });
  tbody.appendChild(newRow);
});
document.querySelector('#tblSach tbody').addEventListener('click', function (e) {
  var btn = e.target.closest('.btnRemoveRow');
  if (!btn) return;
  var tbody = document.querySelector('#tblSach tbody');
  if (tbody.rows.length > 1) btn.closest('tr').remove();
});
</script>

<%@ include file="../common/footer.jsp" %>
