/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lap7_Bai9;

/**
 *
 * @author DELL
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GradeServlet")
public class GradeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "delete":
                String deleteId = request.getParameter("id");
                GradeStore.delete(deleteId);
                response.sendRedirect("GradeServlet?action=list");
                break;

            case "edit":
                String editId = request.getParameter("id");
                Grade grade = GradeStore.findById(editId);
                request.setAttribute("grade", grade);
                request.getRequestDispatcher("/Lap7_Bai9_grade-form.jsp").forward(request, response);
                break;

            case "add":
                request.getRequestDispatcher("/Lap7_Bai9_grade-form.jsp").forward(request, response);
                break;

            case "list":
            default:
                request.setAttribute("gradeList", GradeStore.findAll());
                request.getRequestDispatcher("/Lap7_Bai9_grade-list.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");

        String studentId = request.getParameter("studentId");
        String studentName = request.getParameter("studentName");
        String attStr = request.getParameter("attendanceScore");
        String midStr = request.getParameter("midtermScore");
        String finStr = request.getParameter("finalScore");

        String errorMsg = null;
        double att = 0, mid = 0, fin = 0;

        try {
            att = Double.parseDouble(attStr);
            mid = Double.parseDouble(midStr);
            fin = Double.parseDouble(finStr);

            if (att < 0 || att > 10 || mid < 0 || mid > 10 || fin < 0 || fin > 10) {
                errorMsg = "Tất cả các cột điểm phải nằm trong thang điểm từ 0.0 đến 10.0!";
            }
        } catch (NumberFormatException e) {
            errorMsg = "Giá trị điểm phải là định dạng số!";
        }

        if (errorMsg != null) {
            Grade current = new Grade(studentId, studentName, att, mid, fin);
            request.setAttribute("grade", current);
            request.setAttribute("errorMsg", errorMsg);
            request.getRequestDispatcher("/Lap7_Bai9_grade-form.jsp").forward(request, response);
            return;
        }

        Grade grade = new Grade(studentId, studentName, att, mid, fin);
        GradeStore.save(grade);
        response.sendRedirect("GradeServlet?action=list");
    }
}
