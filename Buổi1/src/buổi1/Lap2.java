/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buổi1;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Lap2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã SV: ");
        String maSV = sc.nextLine();

        System.out.print("Nhập họ tên: ");
        String hoTen = sc.nextLine();

        double cc, gk, ck;

        do {
            System.out.print("Điểm chuyên cần: ");
            cc = sc.nextDouble();
        } while (cc < 0 || cc > 10);

        do {
            System.out.print("Điểm giữa kỳ: ");
            gk = sc.nextDouble();
        } while (gk < 0 || gk > 10);

        do {
            System.out.print("Điểm cuối kỳ: ");
            ck = sc.nextDouble();
        } while (ck < 0 || ck > 10);

        double tongKet = cc * 0.1 + gk * 0.3 + ck * 0.6;

        String xepLoai;

        if (tongKet >= 8.5)
            xepLoai = "A";
        else if (tongKet >= 7)
            xepLoai = "B";
        else if (tongKet >= 5.5)
            xepLoai = "C";
        else if (tongKet >= 4)
            xepLoai = "D";
        else
            xepLoai = "F";

        System.out.printf("%s - %s - %.2f - %s",
                maSV, hoTen, tongKet, xepLoai);
        
        
        sc.close();
    }
}
//public class SinhVien{
//    private String maSV;
//    private String hoTen;
//    private double diemCC;
//    private double diemGK;
//    private double diemCK;
//    
//    public SinhVien(String maSV, String hoTen, double diemCC, double diemGK, double diemCK){
//        this.maSV = maSV;
//        this.hoTen = hoTen;
//        this.diemCC = diemCC;
//        this.diemGK = diemGK;
//        this.diemCK = diemCK;
//    } 
//    public String getMaSV(){
//        return maSV;
//    }
//    public void setMaSV(String maSV){
//        this.maSV = maSV;
//    }
//    public String getHoTen(){
//        return hoTen;
//    }
//    public void setHoTen(String hoTen){
//        this.hoTen = hoTen;
//    }
//    public String getDiemCC(){
//        return hoTen;
//    }
//    public void setDiemCC(double diemCC){
//        this.diemCC = diemCC;
//    }
//    public String getDiemGK(){
//        return hoTen;
//    }
//    public void setDiemGK(double diemGK){
//        this.diemGK = diemGK;
//    }
//    public String getDiemCK(){
//        return hoTen;
//    }
//    public void setDiemCK(double diemCK){
//        this.diemCK = diemCK;
//    }
//}
