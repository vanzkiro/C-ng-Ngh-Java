/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View_sach;

/**
 *
 * @author DELL
 */

import java.io.Serializable;

public class Sach implements Serializable {
    private String maSach;
    private String tenSach;
    private int maTg;
    private String tenTacGia;
    private int maTl;
    private String tenTheLoai;
    private String nhaXuatBan;
    private Integer namXb;
    private int soLuong;
    private int soLuongCon;
    private double donGia;
    private String moTa;
    private String hinhAnh;
    private int trangThai; // 1: Lưu hành, 0: Ngừng

    public Sach() {}

    public Sach(String maSach, String tenSach, String tenTacGia, String tenTheLoai, 
                String nhaXuatBan, Integer namXb, int soLuong, int soLuongCon, 
                double donGia, int trangThai, String hinhAnh) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tenTacGia = tenTacGia;
        this.tenTheLoai = tenTheLoai;
        this.nhaXuatBan = nhaXuatBan;
        this.namXb = namXb;
        this.soLuong = soLuong;
        this.soLuongCon = soLuongCon;
        this.donGia = donGia;
        this.trangThai = trangThai;
        this.hinhAnh = hinhAnh;
    }

    // Getters and Setters
    public String getMaSach() { return maSach; }
    public void setMaSach(String maSach) { this.maSach = maSach; }
    public String getTenSach() { return tenSach; }
    public void setTenSach(String tenSach) { this.tenSach = tenSach; }
    public int getMaTg() { return maTg; }
    public void setMaTg(int maTg) { this.maTg = maTg; }
    public String getTenTacGia() { return tenTacGia; }
    public void setTenTacGia(String tenTacGia) { this.tenTacGia = tenTacGia; }
    public int getMaTl() { return maTl; }
    public void setMaTl(int maTl) { this.maTl = maTl; }
    public String getTenTheLoai() { return tenTheLoai; }
    public void setTenTheLoai(String tenTheLoai) { this.tenTheLoai = tenTheLoai; }
    public String getNhaXuatBan() { return nhaXuatBan; }
    public void setNhaXuatBan(String nhaXuatBan) { this.nhaXuatBan = nhaXuatBan; }
    public Integer getNamXb() { return namXb; }
    public void setNamXb(Integer namXb) { this.namXb = namXb; }
    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }
    public int getSoLuongCon() { return soLuongCon; }
    public void setSoLuongCon(int soLuongCon) { this.soLuongCon = soLuongCon; }
    public double getDonGia() { return donGia; }
    public void setDonGia(double donGia) { this.donGia = donGia; }
    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }
    public String getHinhAnh() { return hinhAnh; }
    public void setHinhAnh(String hinhAnh) { this.hinhAnh = hinhAnh; }
    public int getTrangThai() { return trangThai; }
    public void setTrangThai(int trangThai) { this.trangThai = trangThai; }
}