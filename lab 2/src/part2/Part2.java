/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part2;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Part2 {
    public static void main(String[] args) {
        boolean cont = false;
        do{
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the string:");
                String s = sc.nextLine();       
                if(s.matches("SE\\d{3}")){
                    System.out.println("The string is "+s);
                }else{
                    throw  new Exception();
                }
                
                cont = false;
            } catch (Exception e) {
                System.out.println("The string is invalid");
                cont = true;
            }
        }while(cont);
    }
}