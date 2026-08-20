/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuong3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class SanPhamDAL {
    public void HienThiDSSP() throws Exception{
        String sql = "SELECT * FROM san_pham";

        try (Connection conn = DBHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int maSp = rs.getInt("ma_sp");
                String tenSp = rs.getString("ten_sp");
                double donGia = rs.getDouble("don_gia");
                int soLuong = rs.getInt("so_luong");

                System.out.printf("Mã: %d | Tên: %s | Giá: %.2f | Số lượng: %d\n", 
                                  maSp, tenSp, donGia, soLuong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
