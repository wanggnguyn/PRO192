/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Vase extends Item{
    private int height;
    private String material;

    public Vase() {
    }

    public Vase(int height, String material) {
        this.height = height;
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
     public void InputVase(){
        input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter height : ");
        height = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter materials : ");
        material = sc.nextLine();
    }
    public void OutputVase(){
        output();
        System.out.println("Height: "+height);
        System.out.println("Material: "+material);
    }
   
}
