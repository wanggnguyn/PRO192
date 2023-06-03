/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Part_1;

/**
 *
 * @author My Admin
 */
public class Tester {
    public static void main(String[] args) {
        Car c = new Car();
        c.pressStartButton();
        c.pressAcceleratorButton();
        c.output();
        System.out.println("=======================");
        Car c2 = new Car("Blue", 10, true, true);
        c2.pressStartButton();
        c2.pressAcceleratorButton();
        c2.output();
    }
}
