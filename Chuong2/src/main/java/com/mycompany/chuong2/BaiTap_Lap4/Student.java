/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuong2.BaiTap_Lap4;

/**
 *
 * @author DELL
 */
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private List<Subject> subjects;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Subject> getSubjects() { return subjects; }
    public void setSubjects(List<Subject> subjects) { this.subjects = subjects; }

    public double getGpa() {
        if (subjects.isEmpty()) return 0.0;
        double total = 0;
        for (Subject s : subjects) total += s.getTb();
        return Math.round((total / subjects.size()) * 100.0) / 100.0;
    }
}