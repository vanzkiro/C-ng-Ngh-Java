/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package buổi12;

import java.util.Scanner;


public class Bai3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n: ");
        int n = sc.nextInt();
        
        boolean laSNT = true;
        
        if(n < 2){
            laSNT = false;
        }else{
            for (int i = 2; i <= Math.sqrt(n); i++){
                if (n % i == 0){
                    laSNT = false;
                    break;
                }
            }
        }
        if (laSNT){
            System.out.print(n + "la so nguyen to");
        }else{
            System.out.print(n + "khong phai la so nguyen to");
        }   
    }
}
