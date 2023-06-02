/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
import java.util.Scanner;
public class SpecCar extends Car {
    private int type;

    public SpecCar() {
        
    }

    public SpecCar(String maker, int price, int type) {
        super(maker, price);
        this.type = type;
    }

    public String toString() {
        return super.toString() + ", " + type;
    }

    public void setData() {
    super.setMaker("XZ" + super.getMaker());
   
}

    public int getValue() {
        int inc = (type < 7) ? 10 : 15;
        return getPrice() + inc;
    }

    public void setPrice(int price) {
        throw new UnsupportedOperationException("Cannot set price for SpecCar."); 
    }

    public static SpecCar createSpecCarFromUserInput() {
        String maker;
        int price;
        int type;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter maker: ");
            maker = scanner.nextLine();
            System.out.print("Enter price: ");
            price = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter type: ");
            type = scanner.nextInt();
            scanner.nextLine(); 
        }

        return new SpecCar(maker, price, type);
    }

}
