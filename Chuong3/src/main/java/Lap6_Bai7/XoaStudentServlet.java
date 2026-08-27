/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lap6_Bai7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/xoa-sv")
public class XoaStudentServlet extends HttpServlet {
    private static List<Student1> listStudent;

    // Khởi tạo danh sách mặc định chỉ 1 lần duy nhất khi Server start
    @Override
    public void init() throws ServletException {
        super.init();
        resetData();
    }

    private void resetData() {
        listStudent = new ArrayList<>();
        listStudent.add(new Student1(1, "20231249", "Phạm Quang Văn", "Hà Nội"));
        listStudent.add(new Student1(2, "20231250", "Nguyễn Văn A", "Ninh Bình"));
        listStudent.add(new Student1(3, "20231251", "Trần Thị B", "Nam Định"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // Nếu danh sách vô tình bị null hoặc trống hoàn toàn, nạp lại tự động
        if (listStudent == null || listStudent.isEmpty()) {
            resetData();
        }

        String maSV = request.getParameter("maSV");

        // CHỈ thực hiện xóa khi tham số maSV thực sự tồn tại
        if (maSV != null && !maSV.trim().isEmpty()) {
            final String idToDelete = maSV.trim();
            listStudent.removeIf(s -> s.getMaSV().equalsIgnoreCase(idToDelete));
        }

        // Đóng gói danh sách gửi sang JSP
        request.setAttribute("students", listStudent);
        request.getRequestDispatcher("/xoa_sv.jsp").forward(request, response);
    }
}