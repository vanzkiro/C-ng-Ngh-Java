/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lap7_Bai8;

/**
 *
 * @author DELL
 */

import java.util.ArrayList;
import java.util.List;

public class ClassroomStore {
    private static final List<Classroom> classList = new ArrayList<>();

    static {
        classList.add(new Classroom("CNTTK19A", "Công nghệ thông tin K19A", "Nguyễn Văn A", 40));
        classList.add(new Classroom("KTPMK19B", "Kỹ thuật phần mềm K19B", "Trần Thị B", 35));
        classList.add(new Classroom("KHMTK19A", "Khoa học máy tính K19A", "Lê Hoàng C", 38));
    }

    public static List<Classroom> findAll() {
        return classList;
    }

    public static Classroom findById(String classId) {
        if (classId == null) return null;
        for (Classroom c : classList) {
            if (c.getClassId().equalsIgnoreCase(classId)) return c;
        }
        return null;
    }

    public static List<Classroom> search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return findAll();
        }
        List<Classroom> result = new ArrayList<>();
        String key = keyword.toLowerCase().trim();
        for (Classroom c : classList) {
            if (c.getClassId().toLowerCase().contains(key) || c.getClassName().toLowerCase().contains(key)) {
                result.add(c);
            }
        }
        return result;
    }

    public static void save(Classroom classroom) {
        Classroom existing = findById(classroom.getClassId());
        if (existing != null) {
            existing.setClassName(classroom.getClassName());
            existing.setAdvisor(classroom.getAdvisor());
            existing.setStudentCount(classroom.getStudentCount());
        } else {
            classList.add(classroom);
        }
    }

    public static void delete(String classId) {
        classList.removeIf(c -> c.getClassId().equalsIgnoreCase(classId));
    }
}
