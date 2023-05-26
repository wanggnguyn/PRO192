/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1.java;

/**
 *
 * @author ADMIN
 */
public class Q1 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("From 2 to 10 use for :");
        for (int i = 2; i <= n; i+=2) {
            System.out.println(i);
        }
        System.out.println("From 2 to 10 use while:");
        n = 2;
        while (n <= 10) {
            if (n % 2 == 0) {
                System.out.println(n);
            }
            n++;
        }
    
       
        
    }
}