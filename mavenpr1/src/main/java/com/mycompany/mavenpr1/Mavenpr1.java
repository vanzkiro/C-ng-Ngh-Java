/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenpr1;

/**
 *
 * @author DELL
 */

import java.util.Scanner;

public class Mavenpr1 {

    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
       System.out.print("Nhập mã SV: ");
       String maSV = sc.nextLine();
       System.out.print("Nhập họ tên: ");
       String hoTen = sc.nextLine();
       System.out.print("Nhập điểm CC: ");
       double diemCC = sc.nextDouble();
       System.out.print("Nhập điểm GK: ");
       double diemGK = sc.nextDouble();
       System.out.print("Nhập điểm CK: ");
       double diemCK = sc.nextDouble();
       
       Student sv = new Student(maSV, hoTen, diemCC, diemGK, diemCK);
       
       double tongdiem = GradeCalculator.GradeCalulatorScore(sv);
       
       String xep = GradeCalculator.xeploai(tongdiem);
       System.out.println("-------------- Thông tin sinh viên --------------");
       System.out.printf("| %-15s | %-25s | %-10s | %-15s |%n",
                "Mã SV", "Họ tên", "Tổng điểm", "Xếp loại");
       System.out.println("---------------------------------------------------------------");
       System.out.printf("| %-15s | %-25s | %-10.2f | %-15s |%n",
                sv.getMaSV(), sv.getHoTen(), tongdiem, xep);

       sc.close();
    }
}