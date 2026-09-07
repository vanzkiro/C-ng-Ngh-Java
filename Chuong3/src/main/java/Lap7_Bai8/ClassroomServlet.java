/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lap7_Bai8;

/**
 *
 * @author DELL
 */

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ClassroomServlet")
public class ClassroomServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "delete":
                String deleteId = request.getParameter("id");
                ClassroomStore.delete(deleteId);
                response.sendRedirect("ClassroomServlet?action=list");
                break;

            case "edit":
                String editId = request.getParameter("id");
                Classroom classroom = ClassroomStore.findById(editId);
                request.setAttribute("classroom", classroom);
                request.getRequestDispatcher("/Lap7_Bai8_class-form.jsp").forward(request, response);
                break;

            case "add":
                request.getRequestDispatcher("/Lap7_Bai8_class-form.jsp").forward(request, response);
                break;

            case "search":
                String keyword = request.getParameter("keyword");
                List<Classroom> searchResult = ClassroomStore.search(keyword);
                request.setAttribute("classList", searchResult);
                request.setAttribute("keyword", keyword);
                request.getRequestDispatcher("/Lap7_Bai8_class-list.jsp").forward(request, response);
                break;

            case "list":
            default:
                request.setAttribute("classList", ClassroomStore.findAll());
                request.getRequestDispatcher("/Lap7_Bai8_class-list.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");

        String classId = request.getParameter("classId");
        String className = request.getParameter("className");
        String advisor = request.getParameter("advisor");
        String countStr = request.getParameter("studentCount");

        String errorMsg = null;
        int studentCount = 0;

        try {
            studentCount = Integer.parseInt(countStr);
            if (studentCount < 0) {
                errorMsg = "Số lượng sinh viên phải lớn hơn hoặc bằng 0!";
            }
        } catch (NumberFormatException e) {
            errorMsg = "Số lượng sinh viên phải là định dạng số!";
        }

        if (errorMsg != null) {
            Classroom current = new Classroom(classId, className, advisor, studentCount);
            request.setAttribute("classroom", current);
            request.setAttribute("errorMsg", errorMsg);
            request.getRequestDispatcher("/Lap7_Bai8_class-form.jsp").forward(request, response);
            return;
        }

        Classroom classroom = new Classroom(classId, className, advisor, studentCount);
        ClassroomStore.save(classroom);
        response.sendRedirect("ClassroomServlet?action=list");
    }
}