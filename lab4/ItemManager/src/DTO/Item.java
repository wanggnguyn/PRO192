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
public class Item {
    private int value;
    private String creator;

    public Item() {
    }

    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    public void output(){
        System.out.println("Value : "+value + " - Creater : " + creator);
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter value : ");
            value = sc.nextInt();
        }while(value <= 0);
        sc.nextLine();
        do{
            System.out.println("Enter creator :");
            creator = sc.nextLine();
        }while(creator.isEmpty());
    }
}