/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lap7_Bai9;

/**
 *
 * @author DELL
 */

import java.util.ArrayList;
import java.util.List;

public class GradeStore {
    private static final List<Grade> gradeList = new ArrayList<>();

    static {
        gradeList.add(new Grade("SV001", "Nguyễn Văn A", 9.0, 8.5, 8.0));
        gradeList.add(new Grade("SV002", "Trần Thị B", 7.0, 6.5, 5.0));
        gradeList.add(new Grade("SV003", "Lê Hoàng C", 10.0, 9.0, 9.5));
    }

    public static List<Grade> findAll() {
        return gradeList;
    }

    public static Grade findById(String studentId) {
        if (studentId == null) return null;
        for (Grade g : gradeList) {
            if (g.getStudentId().equalsIgnoreCase(studentId)) return g;
        }
        return null;
    }

    public static void save(Grade grade) {
        Grade existing = findById(grade.getStudentId());
        if (existing != null) {
            existing.setStudentName(grade.getStudentName());
            existing.setAttendanceScore(grade.getAttendanceScore());
            existing.setMidtermScore(grade.getMidtermScore());
            existing.setFinalScore(grade.getFinalScore());
        } else {
            gradeList.add(grade);
        }
    }

    public static void delete(String studentId) {
        gradeList.removeIf(g -> g.getStudentId().equalsIgnoreCase(studentId));
    }
}
