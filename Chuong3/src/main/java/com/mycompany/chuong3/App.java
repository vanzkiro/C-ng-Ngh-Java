/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuong3;

/**
 *
 * @author DELL
 */
public class App {
    public static void main(String[] args) throws Exception{
        DBHelper.testConnection(); 
        
        SanPhamDAL sp = new SanPhamDAL();
        sp.HienThiDSSP();
    }
}
