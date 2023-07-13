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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BrandList {
    private ArrayList<Brand> brands;

    public BrandList() {
        this.brands = new ArrayList<>();
    }

    public ArrayList<Brand> getBrands() {
        return brands;
    }
    public boolean loadFromFile(String filename) {
    try {
        File file = new File(filename);
        if (!file.exists()) {
            return false;
        }

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] brandInfo = line.split(", ");

            if (brandInfo.length >= 3) {
                String brandID = brandInfo[0].trim();
                String brandName = brandInfo[1].trim();
                String soundBrandPrice = brandInfo[2].trim();

                // Split sound brand and price using last colon
                int lastColonIndex = soundBrandPrice.lastIndexOf(":");
                if (lastColonIndex != -1) {
                    String soundBrand = soundBrandPrice.substring(0, lastColonIndex).trim();
                    String priceStr = soundBrandPrice.substring(lastColonIndex + 1).trim().replace(",", ".");
                    double price = Double.parseDouble(priceStr);

                    Brand brand = new Brand(brandID, brandName, soundBrand, price);
                    brands.add(brand);
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            } else {
                System.out.println("Invalid line format: " + line);
            }
        }

        scanner.close();
        return true;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}

    public boolean saveToFile(String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (Brand brand : brands) {
                writer.write(brand.getBrandID() + ", " + brand.getBrandName() + ", " + brand.getSoundBrand()
                        + ", " + brand.getPrice() + "\n");
            }
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int searchID(String brandID) {
        int N = brands.size();
        for (int i = 0; i < N; i++) {
            if (brands.get(i).getBrandID().equals(brandID)) {
                return i;
            }
        }
        return -1;
    }

    public Brand getUserChoice() {
        Menu menu = new Menu();
        int response = menu.int_getChoice(brands);
        return brands.get(response - 1);
    }

    public void addBrand() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Brand ID: ");
        String brandID = scanner.nextLine();
        if (searchID(brandID) >= 0) {
            System.out.println("Brand ID already exists.");
            return;
        }

        System.out.print("Enter Brand Name: ");
        String brandName = scanner.nextLine();
        if (brandName.isEmpty()) {
            System.out.println("Brand name cannot be blank.");
            return;
        }

        System.out.print("Enter Sound Brand: ");
        String soundBrand = scanner.nextLine();
        if (soundBrand.isEmpty()) {
            System.out.println("Sound brand cannot be blank.");
            return;
        }

        System.out.print("Enter Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        if (price <= 0) {
            System.out.println("Price must be greater than 0.");
            return;
        }

        Brand brand = new Brand(brandID, brandName, soundBrand, price);
        brands.add(brand);
        System.out.println("Brand added successfully.");
    }
    public void updateBrand() {
         Scanner scanner = new Scanner(System.in);
    System.out.print("Enter brand ID to update: ");
    String brandID = scanner.nextLine();
    int pos = searchID(brandID);

    if (pos < 0) {
        System.out.println("Brand not found.");
        return;
    }

    Brand brand = brands.get(pos);

    System.out.print("Enter new brand name: ");
    String brandName = scanner.nextLine().trim();
    if (brandName.isEmpty()) {
        System.out.println("Brand name cannot be blank.");
        return;
    }

    System.out.print("Enter new sound brand: ");
    String soundBrand = scanner.nextLine().trim();
    if (soundBrand.isEmpty()) {
        System.out.println("Sound brand cannot be blank.");
        return;
    }

    double price = 0;
    while (true) {
        try {
            System.out.print("Enter new price: ");
            price = Double.parseDouble(scanner.nextLine());
            if (price <= 0) {
                System.out.println("Price must be greater than 0.");
            } else {
                break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid price format. Try again.");
        }
    }

    brand.setBrandName(brandName);
    brand.setSoundBrand(soundBrand);
    brand.setPrice(price);

    System.out.println("Brand updated successfully.");
}

    public void listBrands() {
        int N = brands.size();
        for (int i = 0; i < N; i++) {
            System.out.println(brands.get(i));
        }
    }
}

    