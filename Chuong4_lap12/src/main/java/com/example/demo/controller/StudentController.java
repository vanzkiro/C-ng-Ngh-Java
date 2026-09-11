package com.example.demo.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 1. Hiển thị danh sách sinh viên
    @GetMapping
    public String list(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students/list";
    }

    // 2. Hiển thị form thêm sinh viên
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/form";
    }

    // 3. Xử lý Lưu dữ liệu (Thêm mới / Cập nhật)
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "students/form";
        }
        studentService.save(student);
        return "redirect:/students";
    }

    // 4. Bài 6: Xem chi tiết sinh viên theo ID
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        Optional<Student> studentOpt = studentService.findById(id);
        if (studentOpt.isPresent()) {
            model.addAttribute("student", studentOpt.get());
            return "students/detail";
        }
        return "redirect:/students";
    }

    // 5. Bài 7: Mở form chỉnh sửa sinh viên
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        Optional<Student> studentOpt = studentService.findById(id);
        if (studentOpt.isPresent()) {
            model.addAttribute("student", studentOpt.get());
            return "students/form";
        }
        return "redirect:/students";
    }

    // 6. Bài 8: Xóa sinh viên theo ID
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        studentService.deleteById(id);
        return "redirect:/students";
    }
}