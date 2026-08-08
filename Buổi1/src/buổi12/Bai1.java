/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buổi12;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Bai1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n");
        int n = sc.nextInt();
        
        int sum = 0;
        
        for(int i = 2; i <= n; i++){
            if(i % 2 == 0){
                sum += i;
            }
        }
        System.out.print("tong = " + sum);
    }
}
