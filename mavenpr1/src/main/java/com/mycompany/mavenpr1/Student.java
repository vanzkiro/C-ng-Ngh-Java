/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenpr1;

/**
 *
 * @author DELL
 */
public class Student {
    private String maSV;
    private String hoTen;
    private Double diemCC;
    private Double diemGK;
    private Double diemCK;
    public Student(String maSV, String hoTen, Double diemCC, Double diemGK, Double diemCK){
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diemCC = diemCC;
        this.diemGK = diemGK;
        this.diemCK = diemCK;
    }
    public String getMaSV(){
        return maSV;
    }
    public String getHoTen(){
        return hoTen;
    }
    public Double getDiemCC(){
        return diemCC;
    }
    public Double getDiemGK(){
        return diemGK;
    }
    public Double getDiemCK(){
        return diemCK;
    }
}
