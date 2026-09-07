<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách Phiếu mượn - Thư Viện DVC</title>
    <!-- Bootstrap 5 CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body { 
            background-color: #f8f9fa; 
            font-family: system-ui, -apple-system, "Segoe UI", Roboto, sans-serif;
            font-size: 14px;
        }
        .navbar-dark { background-color: #2b3035 !important; }
        .nav-link { color: #adb5bd !important; }
        .nav-link.active { color: #ffffff !important; }
        .card-table { 
            border-radius: 6px; 
            border: 1px solid #e9ecef; 
            box-shadow: 0 1px 3px rgba(0,0,0,0.02); 
        }
        .table > :not(caption) > * > * { 
            padding: 12px 16px; 
            vertical-align: middle;
        }
        .btn-filter { 
            border-radius: 4px; 
            padding: 5px 12px; 
            font-size: 14px; 
        }
        .badge-status {
            font-weight: 500;
            font-size: 12px;
            padding: 4px 8px;
            border-radius: 4px;
        }
        /* CSS Modal Thuần dự phòng */
        .custom-modal-backdrop {
            display: none;
            position: fixed;
            top: 0; left: 0; width: 100%; height: 100%;
            background: rgba(0,0,0,0.5);
            z-index: 1050;
            align-items: center;
            justify-content: center;
        }
        .custom-modal-backdrop.show {
            display: flex !important;
        }
    </style>
</head>
<body class="d-flex flex-column min-vh-100">

    <!-- NAVBAR TOP -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark px-3 py-2">
        <div class="container-fluid">
            <a class="navbar-brand fw-bold d-flex align-items-center gap-2 fs-6" href="#">
                <i class="bi bi-book-fill"></i> Thư Viện DVC
            </a>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item"><a class="nav-link" href="#"><i class="bi bi-house-door"></i> Trang chủ</a></li>
                    <li class="nav-item"><a class="nav-link" href="#"><i class="bi bi-journal-bookmark"></i> Sách</a></li>
                    <li class="nav-item"><a class="nav-link" href="#"><i class="bi bi-tags"></i> Thể loại</a></li>
                    <li class="nav-item"><a class="nav-link" href="#"><i class="bi bi-person-lines-fill"></i> Tác giả</a></li>
                    <li class="nav-item"><a class="nav-link" href="#"><i class="bi bi-people"></i> Độc giả</a></li>
                    <li class="nav-item"><a class="nav-link active fw-semibold" href="#"><i class="bi bi-arrow-left-right"></i> Mượn/Trả sách</a></li>
                    <li class="nav-item"><a class="nav-link" href="#"><i class="bi bi-bar-chart"></i> Thống kê</a></li>
                    <li class="nav-item"><a class="nav-link" href="#"><i class="bi bi-person-gear"></i> Tài khoản NV</a></li>
                </ul>
                <div class="d-flex align-items-center text-white gap-2 fs-6">
                    <i class="bi bi-person-circle"></i> Quản Trị Viên 
                    <span class="badge bg-light text-dark fw-bold px-2 py-1" style="font-size: 10px;">ADMIN</span>
                </div>
            </div>
        </div>
    </nav>

    <!-- CONTENT BODY -->
    <div class="container-fluid px-4 py-4 flex-grow-1">
        
        <!-- HEADER & BUTTON LẬP PHIẾU MỚI -->
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h4 class="fw-bold mb-0 text-dark d-flex align-items-center gap-2">
                <i class="bi bi-arrow-left-right"></i> Danh sách Phiếu mượn
            </h4>
            <button class="btn btn-primary d-flex align-items-center gap-1 px-3 shadow-sm" onclick="lapPhieuMoi()">
                <i class="bi bi-plus-circle"></i> Lập phiếu mượn mới
            </button>
        </div>

        <!-- BỘ LỌC VÀ TÌM KIẾM -->
        <div class="d-flex justify-content-between align-items-center mb-3">
            <div class="btn-group" role="group">
                <button type="button" class="btn btn-filter btn-secondary active" onclick="filterStatus('all', this)">Tất cả</button>
                <button type="button" class="btn btn-filter btn-outline-primary" onclick="filterStatus('Đang mượn', this)">Đang mượn</button>
                <button type="button" class="btn btn-filter btn-outline-danger" onclick="filterStatus('Quá hạn', this)">Quá hạn</button>
                <button type="button" class="btn btn-filter btn-outline-success" onclick="filterStatus('Đã trả', this)">Đã trả</button>
            </div>
            <div class="input-group style-search" style="width: 280px;">
                <span class="input-group-text bg-white border-end-0"><i class="bi bi-search text-muted"></i></span>
                <input type="text" id="searchInput" class="form-control border-start-0" placeholder="Tìm theo tên độc giả..." onkeyup="searchTable()">
            </div>
        </div>

        <!-- TABLE DATA -->
        <div class="card card-table bg-white">
            <div class="card-body p-0">
                <div class="table-responsive">
                    <table class="table table-hover mb-0" id="loanTable">
                        <thead>
                            <tr class="border-bottom text-secondary" style="font-size: 13px;">
                                <th class="ps-4 fw-bold">Mã PM</th>
                                <th class="fw-bold">Độc giả</th>
                                <th class="fw-bold">Nhân viên lập</th>
                                <th class="fw-bold">Ngày mượn</th>
                                <th class="fw-bold">Hạn trả</th>
                                <th class="fw-bold">Trạng thái</th>
                                <th class="text-end pe-4 fw-bold">Thao tác</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Row 1 -->
                            <tr>
                                <td class="ps-4 fw-semibold text-secondary">#3</td>
                                <td class="fw-semibold text-dark reader-name">Nguyễn Hoàng Anh</td>
                                <td>Nguyễn Văn Thủ Thư</td>
                                <td>2026-02-05</td>
                                <td>2026-02-19</td>
                                <td><span class="badge bg-danger badge-status status-text">Quá hạn</span></td>
                                <td class="text-end pe-4">
                                    <button type="button" class="btn btn-sm btn-outline-primary px-2 py-1" 
                                            onclick="viewDetail('#3', 'Nguyễn Hoàng Anh', '2026-02-05', '2026-02-19', 'Quá hạn', ['Lập trình Java nâng cao', 'Cấu trúc dữ liệu & Giải thuật'])">
                                        <i class="bi bi-eye"></i> Chi tiết
                                    </button>
                                </td>
                            </tr>
                            
                            <!-- Row 2 -->
                            <tr>
                                <td class="ps-4 fw-semibold text-secondary">#2</td>
                                <td class="fw-semibold text-dark reader-name">Lê Văn C</td>
                                <td>Nguyễn Văn Thủ Thư</td>
                                <td>2026-02-10</td>
                                <td>2026-02-24</td>
                                <td><span class="badge bg-danger badge-status status-text">Quá hạn</span></td>
                                <td class="text-end pe-4">
                                    <button type="button" class="btn btn-sm btn-outline-primary px-2 py-1" 
                                            onclick="viewDetail('#2', 'Lê Văn C', '2026-02-10', '2026-02-24', 'Quá hạn', ['Thiết kế CSDL SQL Server'])">
                                        <i class="bi bi-eye"></i> Chi tiết
                                    </button>
                                </td>
                            </tr>

                            <!-- Row 3 -->
                            <tr>
                                <td class="ps-4 fw-semibold text-secondary">#1</td>
                                <td class="fw-semibold text-dark reader-name">Trần Thị B</td>
                                <td>Nguyễn Văn Thủ Thư</td>
                                <td>2026-02-01</td>
                                <td>2026-02-15</td>
                                <td><span class="badge bg-success badge-status status-text">Đã trả</span></td>
                                <td class="text-end pe-4">
                                    <button type="button" class="btn btn-sm btn-outline-primary px-2 py-1" 
                                            onclick="viewDetail('#1', 'Trần Thị B', '2026-02-01', '2026-02-15', 'Đã trả', ['Đắc Nhân Tâm', 'Nhà Giả Kim'])">
                                        <i class="bi bi-eye"></i> Chi tiết
                                    </button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </div>

    <!-- MODAL XEM CHI TIẾT (Hỗ trợ mở bằng CSS thuần) -->
    <div class="custom-modal-backdrop" id="detailModal">
        <div class="modal-dialog modal-dialog-centered style-modal-box" style="width: 100%; max-width: 500px;">
            <div class="modal-content bg-white p-3 rounded shadow">
                <div class="modal-header d-flex justify-content-between align-items-center border-bottom pb-2">
                    <h5 class="modal-title fw-bold" id="modalTitle">Chi tiết Phiếu mượn</h5>
                    <button type="button" class="btn-close" onclick="closeModal()"></button>
                </div>
                <div class="modal-body py-3">
                    <div class="mb-3">
                        <p class="mb-1"><strong>Độc giả:</strong> <span id="modalReader"></span></p>
                        <p class="mb-1"><strong>Ngày mượn:</strong> <span id="modalBorrowDate"></span></p>
                        <p class="mb-1"><strong>Hạn trả:</strong> <span id="modalDueDate"></span></p>
                        <p class="mb-1"><strong>Trạng thái:</strong> <span id="modalStatus"></span></p>
                    </div>
                    <hr>
                    <h6 class="fw-bold mb-2">Danh sách sách mượn:</h6>
                    <ul class="list-group" id="modalBookList">
                        <!-- Thêm bằng Javascript -->
                    </ul>
                </div>
                <div class="modal-footer border-top pt-2 d-flex justify-content-end gap-2">
                    <button type="button" class="btn btn-secondary btn-sm" onclick="closeModal()">Đóng</button>
                    <button type="button" class="btn btn-success btn-sm" onclick="xacNhanTraSach()"><i class="bi bi-check2-circle"></i> Xác nhận trả sách</button>
                </div>
            </div>
        </div>
    </div>

    <!-- FOOTER -->
    <footer class="text-center py-3 text-secondary border-top bg-white mt-auto" style="font-size: 13px;">
        &copy; 2026 Thư viện DVC (Servlet/JSP)
    </footer>

    <!-- Bootstrap 5 JS CDN -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/bootstrap.bundle.min.js"></script>

    <!-- SCRIPT CHỨC NĂNG -->
    <script>
        function viewDetail(code, reader, borrowDate, dueDate, status, books) {
            document.getElementById('modalTitle').innerText = 'Chi tiết Phiếu mượn ' + code;
            document.getElementById('modalReader').innerText = reader;
            document.getElementById('modalBorrowDate').innerText = borrowDate;
            document.getElementById('modalDueDate').innerText = dueDate;

            let statusBadge = status === 'Quá hạn' 
                ? '<span class="badge bg-danger">Quá hạn</span>' 
                : '<span class="badge bg-success">Đã trả</span>';
            document.getElementById('modalStatus').innerHTML = statusBadge;

            let bookListHtml = '';
            for (let i = 0; i < books.length; i++) {
                bookListHtml += '<li class="list-group-item d-flex align-items-center gap-2"><i class="bi bi-book text-primary"></i> ' + books[i] + '</li>';
            }
            document.getElementById('modalBookList').innerHTML = bookListHtml;

            // Bật Modal bằng class CSS trực tiếp (Không lo lỗi CDN Bootstrap)
            document.getElementById('detailModal').classList.add('show');
        }

        function closeModal() {
            document.getElementById('detailModal').classList.remove('show');
        }

        function searchTable() {
            let input = document.getElementById("searchInput").value.toLowerCase();
            let rows = document.querySelectorAll("#loanTable tbody tr");

            rows.forEach(function(row) {
                let name = row.querySelector(".reader-name").innerText.toLowerCase();
                row.style.display = name.includes(input) ? "" : "none";
            });
        }

        function filterStatus(status, btn) {
            document.querySelectorAll(".btn-filter").forEach(function(b) {
                b.classList.remove("active", "btn-secondary");
                b.classList.add("btn-outline-primary", "btn-outline-danger", "btn-outline-success");
            });
            btn.classList.add("active", "btn-secondary");

            let rows = document.querySelectorAll("#loanTable tbody tr");
            rows.forEach(function(row) {
                let rowStatus = row.querySelector(".status-text").innerText.trim();
                if (status === 'all' || rowStatus === status) {
                    row.style.display = "";
                } else {
                    row.style.display = "none";
                }
            });
        }

        function lapPhieuMoi() {
            alert("Chức năng Mở form Lập phiếu mượn mới!");
        }

        function xacNhanTraSach() {
            alert("Đã cập nhật trạng thái: ĐÃ TRẢ SÁCH!");
            closeModal();
        }
    </script>
</body>
</html>