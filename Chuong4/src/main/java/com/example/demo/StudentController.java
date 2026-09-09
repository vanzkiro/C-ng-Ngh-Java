/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

/**
 *
 * @author DELL
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class StudentController {

    @GetMapping("/students")
    public String listStudents(Model model) {
        List<Student> students = List.of(
            new Student("SV001", "Nguyễn Văn An", "an@eaut.edu.vn", "DCCNTT13.10.1"),
            new Student("SV002", "Trần Thị Bình", "binh@eaut.edu.vn", "DCCNTT13.10.2"),
            new Student("SV003", "Lê Văn Cường", "cuong@eaut.edu.vn", "DCCNTT13.10.3")
        );

        model.addAttribute("students", students);
        return "students";
    }
}
