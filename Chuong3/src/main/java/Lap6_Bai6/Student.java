/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lap6_Bai6;

/**
 *
 * @author DELL
 */
public class Student {
    private int stt;
    private String maSV;
    private String name;
    private String queQuan;

    public Student(int stt, String maSV, String name, String queQuan) {
        this.stt = stt;
        this.maSV = maSV;
        this.name = name;
        this.queQuan = queQuan;
    }

    public int getStt() { return stt; }
    public String getMaSV() { return maSV; }
    public String getName() { return name; }
    public String getQueQuan() { return queQuan; }
}