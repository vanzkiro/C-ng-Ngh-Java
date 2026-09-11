/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.demo.service;

/**
 *
 * @author DELL
 */

import org.springframework.stereotype.Service;
import com.example.demo.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();
    private long nextId = 1;

    // Khởi tạo một vài dữ liệu mẫu
    public StudentService() {
        save(new Student("SV001", "Nguyễn Văn A", "ana@gmail.com", "CNTT1"));
        save(new Student("SV002", "Trần Thị B", "nob@gmail.com", "CNTT2"));
    }

    public List<Student> findAll() {
        return students;
    }

    public Optional<Student> findById(Long id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }

    public void save(Student student) {
        if (student.getId() == null) {
            // Thêm mới
            student.setId(nextId++);
            students.add(student);
        } else {
            // Cập nhật sinh viên đã tồn tại
            findById(student.getId()).ifPresent(existing -> {
                existing.setStudentCode(student.getStudentCode());
                existing.setFullName(student.getFullName());
                existing.setEmail(student.getEmail());
                existing.setClassName(student.getClassName());
            });
        }
    }

    public void deleteById(Long id) {
        students.removeIf(s -> s.getId().equals(id));
    }
}
