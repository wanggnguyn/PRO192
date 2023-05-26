/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part1.java;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Part1 {
    public static void main(String[] args) {
       boolean cont = false;
        do{
            try {
                 Scanner sc = new Scanner(System.in);
                 System.out.print("Enter n :");
                 int n = sc.nextInt();
                 if(n < 1)
                     throw new Exception();
                 
                 System.out.println("The number is "+n);
                 cont = false;
                 
            } catch (Exception e) {
                System.out.println("The number is valid");
                cont = true;
            }
        }while(cont);
        
    }
}