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
public class Painting extends Item{
    public int height;
    public int width;
    public boolean isWatercolour;
    public boolean isFramed;

    public Painting() {
    }

    public Painting(int height, int width, boolean isWatercolour, boolean isFramed) {
        this.height = height;
        this.width = width;
        this.isWatercolour = isWatercolour;
        this.isFramed = isFramed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isIsWatercolour() {
        return isWatercolour;
    }

    public void setIsWatercolour(boolean isWatercolour) {
        this.isWatercolour = isWatercolour;
    }

    public boolean isIsFramed() {
        return isFramed;
    }

    public void setIsFramed(boolean isFramed) {
        this.isFramed = isFramed;
    }
    public void outputPaiting(){
        output();
        System.out.println("Height: "+height);
        System.out.println("Width: "+width);
        System.out.println("Is Watercolour: "+isWatercolour);
        System.out.println("Is Framed: "+isFramed);
    }
    public void inputPaiting(){
        input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter height : ");
        height = sc.nextInt();
        System.out.println("Enter Width : ");
        width = sc.nextInt();
        System.out.println("A watercolour(T/F): ");
        isWatercolour = sc.nextBoolean();
        sc.nextLine();
        System.out.println("Framed(T/F): ");
        isFramed = sc.nextBoolean();
        sc.nextLine();
    }
}
