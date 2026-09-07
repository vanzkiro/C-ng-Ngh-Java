<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" value="Phiếu mượn - Thư Viện DVC" scope="request"/>
<%@ include file="../common/header.jsp" %>

<div class="d-flex justify-content-between align-items-center mb-3">
  <h4><i class="bi bi-arrow-left-right"></i> Danh sách Phiếu mượn</h4>
  <a href="${pageContext.request.contextPath}/phieumuon?action=add" class="btn btn-primary"><i class="bi bi-plus-circle"></i> Lập phiếu mượn mới</a>
</div>

<div class="mb-3">
  <div class="btn-group">
    <a class="btn btn-outline-secondary ${empty filter ? 'active' : ''}" href="${pageContext.request.contextPath}/phieumuon">Tất cả</a>
    <a class="btn btn-outline-primary ${filter == 'DANG_MUON' ? 'active' : ''}" href="${pageContext.request.contextPath}/phieumuon?filter=DANG_MUON">Đang mượn</a>
    <a class="btn btn-outline-danger ${filter == 'QUA_HAN' ? 'active' : ''}" href="${pageContext.request.contextPath}/phieumuon?filter=QUA_HAN">Quá hạn</a>
    <a class="btn btn-outline-success ${filter == 'DA_TRA' ? 'active' : ''}" href="${pageContext.request.contextPath}/phieumuon?filter=DA_TRA">Đã trả</a>
  </div>
</div>

<div class="card">
  <div class="card-body table-responsive">
    <table class="table table-hover align-middle">
      <thead>
        <tr><th>Mã PM</th><th>Độc giả</th><th>Nhân viên lập</th><th>Ngày mượn</th><th>Hạn trả</th><th>Trạng thái</th><th class="text-center">Thao tác</th></tr>
      </thead>
      <tbody>
        <c:forEach var="pm" items="${phieuMuonList}">
          <tr>
            <td>#${pm.maPm}</td>
            <td>${pm.tenDocGia}</td>
            <td>${pm.tenNhanVien}</td>
            <td>${pm.ngayMuon}</td>
            <td>${pm.ngayHenTra}</td>
            <td>
              <c:choose>
                <c:when test="${pm.trangThai == 'DANG_MUON'}"><span class="badge bg-primary">Đang mượn</span></c:when>
                <c:when test="${pm.trangThai == 'QUA_HAN'}"><span class="badge bg-danger">Quá hạn</span></c:when>
                <c:otherwise><span class="badge bg-success">Đã trả</span></c:otherwise>
              </c:choose>
            </td>
            <td class="text-center">
              <a href="${pageContext.request.contextPath}/phieumuon?action=detail&id=${pm.maPm}" class="btn btn-sm btn-outline-primary"><i class="bi bi-eye"></i> Chi tiết</a>
            </td>
          </tr>
        </c:forEach>
        <c:if test="${empty phieuMuonList}"><tr><td colspan="7" class="text-center text-muted py-4">Không có phiếu mượn nào.</td></tr></c:if>
      </tbody>
    </table>
  </div>
</div>

<%@ include file="../common/footer.jsp" %>
