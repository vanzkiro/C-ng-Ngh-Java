/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuong3;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DELL
 */
public class DBHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/minishop_db?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection getConnection() throws Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException ex){
            System.err.println("Chua them thu vien");
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static void testConnection(){
        try(Connection conn = getConnection()){
            if(conn != null){
                System.out.println("Ket noi thanh cong");
            }
        }catch(Exception ex){
            System.out.println("Ket noi that bai");
            ex.printStackTrace();
        }
    }
    
}
