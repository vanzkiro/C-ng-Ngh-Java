/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuong2.BaiTap_Lap3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class StudentManager {
    private final List<Student> list = new ArrayList<>();

    public List<Student> getAll() {
        return list;
    }

    public boolean add(Student st) {
        // Kiểm tra trùng Mã SV
        for (Student s : list) {
            if (s.getId().equalsIgnoreCase(st.getId())) {
                return false;
            }
        }
        list.add(st);
        return true;
    }

    public boolean update(int index, Student st) {
        if (index >= 0 && index < list.size()) {
            list.set(index, st);
            return true;
        }
        return false;
    }

    public boolean delete(int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
            return true;
        }
        return false;
    }
}
