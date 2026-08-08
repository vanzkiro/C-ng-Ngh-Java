/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenpr1;

/**
 *
 * @author DELL
 */
public class GradeCalculator {
    public static double GradeCalulatorScore(Student st){
        return st.getDiemCC() * 0.1 + st.getDiemGK() * 0.3 + st.getDiemCK() * 0.6;
    }
    public static String xeploai(double xl){
        if(xl >= 8.5){
            return "A";
        }else if(xl >= 7){
            return "B";
        }else if(xl >= 5.5){
            return "C";
        }else if(xl >= 4.0){
            return "D";
        }else{
            return "F";
        }
    }
    public static void validate(double xl, String filedName){
        if(xl < 0 || xl > 10){
            throw new IllegalArgumentException(filedName + "Phải nằm từ 0 đến ");
        }
        
    }
}