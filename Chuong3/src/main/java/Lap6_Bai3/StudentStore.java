/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lap6_Bai3;

/**
 *
 * @author DELL
 */

import java.util.ArrayList;
import java.util.List;

public class StudentStore {
    private static final List<Student> students = new ArrayList<>();

    static {
        students.add(new Student("SV001", "Nguyen Van An", "DCCNTT12", "an@example.com"));
        students.add(new Student("SV002", "Tran Thi Binh", "DCCNTT12", "binh@example.com"));
    }

    public static List<Student> findAll() {
        return students;
    }

    public static void add(Student student) {
        students.add(student);
    }

    // 1. Tìm sinh viên theo Mã SV (id)
    public static Student findById(String id) {
        if (id == null) return null;
        for (Student s : students) {
            if (id.equalsIgnoreCase(s.getId())) {
                return s;
            }
        }
        return null;
    }

    // 2. Cập nhật thông tin sinh viên
    public static void update(Student updatedStudent) {
        if (updatedStudent == null || updatedStudent.getId() == null) return;
        
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equalsIgnoreCase(updatedStudent.getId())) {
                students.set(i, updatedStudent); // Ghi đè đối tượng cũ bằng đối tượng mới
                break;
            }
        }
    }
}