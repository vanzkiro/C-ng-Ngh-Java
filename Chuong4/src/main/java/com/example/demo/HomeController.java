package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", "Ứng dụng Spring Boot đã chạy thành công!");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("course", "Công nghệ Java");
        model.addAttribute("chapter", "Chương 4 - Spring Framework");
        return "about";
    }
    
    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("department", "Khoa Công nghệ Thông tin");
        model.addAttribute("email", "cntt@truong.edu.vn");
        model.addAttribute("phone", "024.3869.xxxx");
        model.addAttribute("address", "Tầng 2, Tòa Polico");
        return "contact";
    }
}