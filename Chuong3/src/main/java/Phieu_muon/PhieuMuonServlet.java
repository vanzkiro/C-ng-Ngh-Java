package Phieu_muon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/phieumuon")
public class PhieuMuonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "add":
                // Dữ liệu mẫu hiển thị lên form
                req.setAttribute("docGiaList", getMockDocGiaList());
                req.setAttribute("sachList", getMockSachList());
                req.getRequestDispatcher("/WEB-INF/views/phieumuon/form.jsp").forward(req, resp);
                break;

            case "detail":
                // Dữ liệu mẫu chi tiết phiếu mượn
                PhieuMuon pmDetail = getMockPhieuMuonDetail();
                req.setAttribute("phieuMuon", pmDetail);
                req.getRequestDispatcher("/WEB-INF/views/phieumuon/detail.jsp").forward(req, resp);
                break;

            case "traSach":
                req.getSession().setAttribute("flashSuccess", "Ghi nhận trả sách thành công (Mô phỏng).");
                int maPm = req.getParameter("maPm") != null ? Integer.parseInt(req.getParameter("maPm")) : 1;
                resp.sendRedirect(req.getContextPath() + "/phieumuon?action=detail&id=" + maPm);
                break;

            case "list":
            default:
                req.setAttribute("phieuMuonList", getMockPhieuMuonList());
                req.setAttribute("filter", req.getParameter("filter"));
                req.getRequestDispatcher("/WEB-INF/views/phieumuon/list.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        
        // Mô phỏng tạo phiếu thành công và chuyển sang trang chi tiết
        session.setAttribute("flashSuccess", "Lập phiếu mượn thành công (Mô phỏng). Mã phiếu: 101");
        resp.sendRedirect(req.getContextPath() + "/phieumuon?action=detail&id=101");
    }

    // ==========================================
    // DỮ LIỆU MẪU ĐỂ HIỂN THỊ GIAO DIỆN (MOCK DATA)
    // ==========================================
    
    private List<PhieuMuon> getMockPhieuMuonList() {
        List<PhieuMuon> list = new ArrayList<>();
        
        PhieuMuon pm1 = new PhieuMuon();
        pm1.setMaPm(101);
        pm1.setTenDocGia("Nguyễn Văn A");
        pm1.setTenNhanVien("Trần Thị Thủ Thư");
        pm1.setNgayMuon(LocalDate.now().minusDays(5));
        pm1.setNgayHenTra(LocalDate.now().plusDays(9));
        pm1.setTrangThai("DANG_MUON");
        list.add(pm1);

        PhieuMuon pm2 = new PhieuMuon();
        pm2.setMaPm(102);
        pm2.setTenDocGia("Lê Văn B");
        pm2.setTenNhanVien("Trần Thị Thủ Thư");
        pm2.setNgayMuon(LocalDate.now().minusDays(20));
        pm2.setNgayHenTra(LocalDate.now().minusDays(6));
        pm2.setTrangThai("QUA_HAN");
        list.add(pm2);

        PhieuMuon pm3 = new PhieuMuon();
        pm3.setMaPm(103);
        pm3.setTenDocGia("Phạm Thị C");
        pm3.setTenNhanVien("Nguyễn Văn Quản Lý");
        pm3.setNgayMuon(LocalDate.now().minusDays(30));
        pm3.setNgayHenTra(LocalDate.now().minusDays(16));
        pm3.setTrangThai("DA_TRA");
        list.add(pm3);

        return list;
    }

    private PhieuMuon getMockPhieuMuonDetail() {
        PhieuMuon pm = new PhieuMuon();
        pm.setMaPm(101);
        pm.setTenDocGia("Nguyễn Văn A");
        pm.setTenNhanVien("Trần Thị Thủ Thư");
        pm.setNgayMuon(LocalDate.now().minusDays(5));
        pm.setNgayHenTra(LocalDate.now().plusDays(9));
        pm.setTrangThai("DANG_MUON");
        pm.setGhiChu("Mượn sách cho đồ án tốt nghiệp");

        List<ChiTietPhieuMuon> ctList = new ArrayList<>();
        
        ChiTietPhieuMuon ct1 = new ChiTietPhieuMuon();
        ct1.setMaCt(1);
        ct1.setTenSach("Lập trình Java Web với Servlet & JSP");
        ct1.setSoLuong(1);
        ct1.setDaTra(0);
        ctList.add(ct1);

        ChiTietPhieuMuon ct2 = new ChiTietPhieuMuon();
        ct2.setMaCt(2);
        ct2.setTenSach("Cơ sở dữ liệu MySQL nâng cao");
        ct2.setSoLuong(2);
        ct2.setDaTra(1);
        ct2.setNgayTraThucTe(LocalDate.now());
        ctList.add(ct2);

        pm.setChiTietList(ctList);
        return pm;
    }

    private List<String[]> getMockDocGiaList() {
        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"1", "Nguyễn Văn A - SĐT: 0912345678"});
        list.add(new String[]{"2", "Lê Văn B - SĐT: 0987654321"});
        return list;
    }

    private List<String[]> getMockSachList() {
        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"10", "Lập trình Java Web (Còn: 5)"});
        list.add(new String[]{"11", "Cơ sở dữ liệu SQL Server (Còn: 3)"});
        list.add(new String[]{"12", "Cấu trúc dữ liệu & Giải thuật (Còn: 2)"});
        return list;
    }
}