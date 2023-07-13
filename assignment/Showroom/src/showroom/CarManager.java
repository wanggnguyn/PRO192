/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showroom;

/**
 *
 * @author PC
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarManager {
    public static void main(String[] args) {
        String brandsFilePath = "data/brands.txt";
        String carsFilePath = "data/cars.txt";
        boolean checkSuccessful;
        BrandList brandList = new BrandList();
        brandList.loadFromFile(brandsFilePath);

        CarList carList = new CarList(brandList);
        carList.loadCarsFromFile(carsFilePath);

        List<String> ops = new ArrayList<>();
        ops.add("List all brands");
        ops.add("Add a new brand");
        ops.add("Search a brand based on its ID");
        ops.add("Update a brand");
        ops.add("Save brands to file");
        ops.add("List all cars in ascending order of brand names");
        ops.add("List cars based on a part of an input brand name");
        ops.add("Add a car");
        ops.add("Remove a car based on its ID");
        ops.add("Update a car based on its ID");
        ops.add("Save cars to file");

        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please choose an option (1-11):");
            for (int i = 0; i < ops.size(); i++) {
                System.out.println((i + 1) + ". " + ops.get(i));
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    brandList.listBrands();
                    break;
                case 2:
                    brandList.addBrand();
                    break;
                case 3:
                    System.out.print("Enter Brand ID to search: ");
                    String brandID = scanner.nextLine();
                     int pos = brandList.searchID(brandID);
                     if (pos < 0) {
                        System.out.println("Brand not found.");
                    } else {
                        System.out.println(brandList.getBrands().get(pos));
                    }
                    break;

                case 4:
                    brandList.updateBrand();
                    break;
                case 5:
                    brandList.saveToFile(brandsFilePath);
                    System.out.println("Brands saved to file.");
                    break;
                case 6:
                    carList.listCars();
                    break;
                case 7:
                    System.out.print("Enter a part of the brand name: ");
                    String aPartOfBrandName = scanner.nextLine();
                    carList.printBasedBrandName(aPartOfBrandName);
                    break;
                case 8:
                    carList.addCar();
                    break;
                case 9:
                    checkSuccessful = carList.removeCar();
                    if (checkSuccessful) {
                        System.out.println("Car removed successfully !");
                    } else {
                        System.out.println("Car removed unsuccessfully !");
                    }
                    break;
                case 10:
                    checkSuccessful = carList.updateCar();
                    if (!checkSuccessful) {
                        System.out.println("Car not found or update failed!");
                    } else {
                        System.out.println("Car updated successfully!");
                    }
                    break;
                case 11:
                    carList.saveToFile(carsFilePath);
                    System.out.println("Cars saved to file.");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        } while (choice >= 1 && choice <= ops.size());
    }
}
