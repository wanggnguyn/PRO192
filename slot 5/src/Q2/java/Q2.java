/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2.java;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Q2 {
    public static void sort(int []arr)
    {   
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) 
                { 
                    // swap temp and arr[i] 
                    int temp = arr[j]; 
                    arr[j] = arr[j + 1]; 
                    arr[j + 1] = temp; 
                } 
            }
        }
            System.out.println("After sort : ");
            for (int i = 0; i < n; i++) {
                System.out.println(arr[i]);
            }
        
    }
    public static void max(int []a){
        int n = a.length;
        int max = a[0];
        for (int i = 0; i < n; i++) {
            if(a[i] > max){
                max = a[i];
            }
        }
        System.out.println("Max is: "+max);
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of array:");
        n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
        }
        sort(arr);
        max(arr);
        
        
    }
}