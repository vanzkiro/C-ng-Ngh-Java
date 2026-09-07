package Phieu_muon;

import java.time.LocalDate;

public class ChiTietPhieuMuon {
    private int maCt;
    private int maPm;
    private int maSach;
    private String tenSach;
    private int soLuong;
    private int daTra; // 0: Chưa trả, 1: Đã trả
    private LocalDate ngayTraThucTe;
    private double tienPhat;

    public ChiTietPhieuMuon() {}

    public int getMaCt() { return maCt; }
    public void setMaCt(int maCt) { this.maCt = maCt; }

    public int getMaPm() { return maPm; }
    public void setMaPm(int maPm) { this.maPm = maPm; }

    public int getMaSach() { return maSach; }
    public void setMaSach(int maSach) { this.maSach = maSach; }

    public String getTenSach() { return tenSach; }
    public void setTenSach(String tenSach) { this.tenSach = tenSach; }

    public int getSoLuong() { return soLuong; }
    public void setSoLuong(int soLuong) { this.soLuong = soLuong; }

    public int getDaTra() { return daTra; }
    public void setDaTra(int daTra) { this.daTra = daTra; }

    public LocalDate getNgayTraThucTe() { return ngayTraThucTe; }
    public void setNgayTraThucTe(LocalDate ngayTraThucTe) { this.ngayTraThucTe = ngayTraThucTe; }

    public double getTienPhat() { return tienPhat; }
    public void setTienPhat(double tienPhat) { this.tienPhat = tienPhat; }
}