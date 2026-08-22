/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuong2.BaiTap_Lap4;

/**
 *
 * @author DELL
 */
public class Subject {
    private String name;
    private double cc, gk, ck;

    public Subject(String name, double cc, double gk, double ck) {
        this.name = name;
        this.cc = cc;
        this.gk = gk;
        this.ck = ck;
    }

    public String getName() { return name; }
    public double getCc() { return cc; }
    public double getGk() { return gk; }
    public double getCk() { return ck; }

    public double getTb() {
        return Math.round((cc * 0.1 + gk * 0.3 + ck * 0.6) * 100.0) / 100.0;
    }
}