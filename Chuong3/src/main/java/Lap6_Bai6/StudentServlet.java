/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lap6_Bai6;

/**
 *
 * @author DELL
 */

import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    private static final List<Student> listStudent = new ArrayList<>();

    static {
        listStudent.add(new Student(1, "20231249", "Phạm Quang Văn", "Hà Nội"));
        listStudent.add(new Student(2, "20231250", "Nguyễn Văn A", "Ninh Bình"));
        listStudent.add(new Student(3, "20231251", "Trần Thị B", "Nam Định"));
    }

    // Hàm phụ trợ: Chuyển chuỗi Tiếng Việt có dấu thành KHÔNG DẤU và viết thường
    private String removeAccent(String s) {
        if (s == null) return "";
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        // Xóa các dấu phụ và thay thế chữ đ/Đ
        return pattern.matcher(temp)
                      .replaceAll("")
                      .replace('đ', 'd')
                      .replace('Đ', 'D')
                      .toLowerCase();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String keyword = request.getParameter("keyword");
        List<Student> resultList = listStudent;

        if (keyword != null && !keyword.trim().isEmpty()) {
            // Chuyển từ khóa tìm kiếm về dạng KHÔNG DẤU + chữ thường
            String searchKey = removeAccent(keyword.trim());

            resultList = listStudent.stream()
                    .filter(s -> s.getName() != null && 
                                 removeAccent(s.getName()).contains(searchKey))
                    .collect(Collectors.toList());
        }

        request.setAttribute("students", resultList);
        request.setAttribute("keyword", keyword != null ? keyword.trim() : "");
        request.getRequestDispatcher("/students.jsp").forward(request, response);
    }
}