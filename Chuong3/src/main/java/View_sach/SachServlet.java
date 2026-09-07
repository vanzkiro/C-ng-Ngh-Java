package View_sach;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/sach")
public class SachServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "add":
                showFormAdd(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "delete":
                deleteSach(request, response);
                break;
            case "search":
                searchSach(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Sach> sachList = getMockData();

        request.setAttribute("sachList", sachList);
        // Sửa lại đường dẫn chính xác tới thư mục WEB-INF
        request.getRequestDispatcher("/WEB-INF/views/sach/list.jsp").forward(request, response);
    }

    private void showFormAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Sửa lại đường dẫn chính xác tới thư mục WEB-INF
        request.getRequestDispatcher("/WEB-INF/views/sach/form.jsp").forward(request, response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    String id = request.getParameter("id");
    
    Sach sach = new Sach("S001", "Lập trình Java Web", "Nguyễn Văn A", "Công nghệ", "NXB Giáo Dục", 2024, 10, 8, 150000, 1, "java.jpg");
    if (id != null) {
        sach.setMaSach(id);
    }
    
    request.setAttribute("sach", sach);
    // Sửa lại đường dẫn chính xác tới thư mục WEB-INF
    request.getRequestDispatcher("/WEB-INF/views/sach/form.jsp").forward(request, response);
    }

    private void deleteSach(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        String id = request.getParameter("id");
        // TODO: Gọi DAO để xóa sách có maSach = id trong CSDL
        response.sendRedirect(request.getContextPath() + "/sach");
    }

    private void searchSach(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keyword = request.getParameter("keyword");

        request.setAttribute("keyword", keyword);
        request.setAttribute("sachList", getMockData());
        // Sửa lại đường dẫn chính xác tới thư mục WEB-INF
        request.getRequestDispatcher("/WEB-INF/views/sach/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if ("insert".equals(action)) {
            // TODO: Đọc dữ liệu từ form (bao gồm cả file hinhAnhFile) và thêm mới vào CSDL
        } else if ("update".equals(action)) {
            // TODO: Đọc dữ liệu từ form và cập nhật vào CSDL
        }

        response.sendRedirect(request.getContextPath() + "/sach");
    }

    // Hàm giả lập dữ liệu danh sách
    private List<Sach> getMockData() {
        List<Sach> sachList = new ArrayList<>();
        sachList.add(new Sach("S001", "Lập trình Java Web", "Nguyễn Văn A", "Công nghệ", "NXB Giáo Dục", 2024, 10, 8, 150000, 1, null));
        sachList.add(new Sach("S002", "Thiết kế UI/UX", "John Doe", "Thiết kế", "NXB Trẻ", 2023, 5, 0, 120000, 0, null));
        return sachList;
    }
}