/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part2_2;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Part2_2 {
    public String input() throws Exception{
        String pattern = "SE\\d{3}";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter s :");
        String s = sc.nextLine();
        if(!s.matches(pattern)){
            throw new Exception();
        }
        return s;
    }
    public static void main(String[] args) {
        Part2_2 obj = new Part2_2();
        boolean cont = false;
        do {            
            try {
                String s = obj.input();
                System.out.println("The string is "+s);
                cont = false;
            } catch (Exception e) {
                System.out.println("The string is invalid");
                cont = true;
            }
        } while (cont);
    }
}
