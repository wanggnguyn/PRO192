/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager;

/**
 *
 * @author PC
 */
import java.util.Scanner;
public class Inputter {
    public static Scanner sc = new Scanner(System.in);

    public static int inputInt(int min, int max) {
        return inputInt(null, min, max);
    }

    public static int inputInt(String msg, int min, int max) {
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }

        int data = Integer.MIN_VALUE;

        while (true) {
            try {
                if (msg != null) {
                    System.out.println(msg);
                }

                data = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
            }

            if (data >= min && data <= max) {
                break;
            }
        }

        return data;
    }

    public static String inputStr() {
        return inputStr(null);
    }

    public static String inputStr(String msg) {
        if (msg != null) {
            System.out.println(msg);
        }

        return sc.nextLine().trim();
    }

    public static String inputNonBlankStr(String msg) {
        String str = null;

        do {
            str = inputStr(msg);
        } while (str.isEmpty());

        return str;
    }

    public static String inputPattern(String msg, String pattern) {
        String str = null;

        do {
            str = inputStr(msg);
        } while (!str.matches(pattern));

        return str;
    }
    
}