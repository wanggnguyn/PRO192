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
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CarList extends ArrayList <Car> {
    private List<Car> cars;
    private BrandList brandList;
    private Scanner scanner = new Scanner(System.in);

    public CarList(BrandList brandList) {
        this.brandList = brandList;
        this.cars = new ArrayList<>();
    }


    public boolean loadCarsFromFile(String filename) {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                return false;
            }

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] carInfo = line.split(", ");

                if (carInfo.length == 5) {
                    String carID = carInfo[0].trim();
                    String brandID = carInfo[1].trim();
                    String color = carInfo[2].trim();
                    String frameID = carInfo[3].trim();
                    String engineID = carInfo[4].trim();

                    Brand brand = findBrandByID(brandID);
                    if (brand != null) {
                        Car car = new Car(carID, brand, color, frameID, engineID);
                        cars.add(car);
                    } else {
                        System.out.println("Invalid brand ID: " + brandID);
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
        for (Car car : cars) {
            writer.write(car.toString().replace("<", "").replace(">", "") + "\n");
        }
        writer.close();
        return true;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}


    public int searchID(String carID) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getCarID().equals(carID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchFrame(String frameID) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getFrameID().equals(frameID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchEngine(String engineID) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getEngineID().equals(engineID)) {
                return i;
            }
        }
        return -1;
    }
    public void addCar() {
    boolean checkCarID = false;
    String carID = "";
    do {
        System.out.print("Input car ID: ");
        Scanner scanner = new Scanner(System.in);
        carID = scanner.nextLine();
        for (int i = 0; i < cars.size(); i++) {
            if (carID.equals(cars.get(i).getCarID())) {
                checkCarID = true;
                System.out.println("This car ID is already existed. Try another one!");
                break;
            } else {
                checkCarID = false;
            }
        }
    } while (checkCarID);

    // Create a menu for choosing a brand
    ArrayList<Brand> brandOptions = brandList.getBrands();
    System.out.println("Choose a brand:");
    for (int i = 0; i < brandOptions.size(); i++) {
        System.out.println((i + 1) + ". " + brandOptions.get(i));
    }
    System.out.print("Enter your choice (1.." + brandOptions.size() + "): ");
    Scanner scanner = new Scanner(System.in);
    int brandChoice = scanner.nextInt();
    scanner.nextLine(); // Consume newline character
    Brand brand = brandOptions.get(brandChoice - 1);

    String color = "";
    do {
        System.out.print("Enter color: ");
        color = scanner.nextLine();
        if (color.isEmpty()) {
            System.out.println("Color cannot be blank. Try again!");
        }
    } while (color.isEmpty());

    String frameID = "";
    do {
        System.out.print("Enter frame ID: ");
        frameID = scanner.nextLine();
        if (!frameID.matches("F[0-9]{5}")) {
            System.out.println("Frame ID must be in the format 'F0000'. Try again!");
        } else if (searchFrame(frameID) != -1) {
            System.out.println("Frame ID already exists. Try another one!");
        }
    } while (!frameID.matches("F[0-9]{5}") || searchFrame(frameID) != -1);

    String engineID = "";
    do {
        System.out.print("Enter engine ID: ");
        engineID = scanner.nextLine();
        if (!engineID.matches("E[0-9]{5}")) {
            System.out.println("Engine ID must be in the format 'E00000'. Try again!");
        } else if (searchEngine(engineID) != -1) {
            System.out.println("Engine ID already exists. Try another one!");
        }
    } while (!engineID.matches("E[0-9]{5}") || searchEngine(engineID) != -1);

    Car car = new Car(carID, brand, color, frameID, engineID);
    cars.add(car);
    System.out.println("Car added successfully!");
}


    public void printBasedBrandName(String aPartOfBrandName) {
        int count = 0;
        count = cars.stream().filter((car) -> (car.getBrand().getBrandName().contains(aPartOfBrandName))).map((car) -> {
            System.out.println(car.screenString());
            return car;
        }).map((_item) -> 1).reduce(count, Integer::sum);
        if (count == 0) {
            System.out.println("No car is detected!");
        }
    }

    public boolean removeCar() {
    System.out.print("Input car ID to remove: ");
    String removedID = scanner.nextLine();
    int pos = searchID(removedID);
    if (pos < 0) {
        System.out.println("Car not found.");
        return false;
    } else {
        cars.remove(pos);
        System.out.println("Car removed successfully!");

        // Save the updated car list to the file
        String filename = "car.txt";
        if (saveToFile(filename)) {
            System.out.println("Car list saved to file: " + filename);
        } else {
            System.out.println("Failed to save car list to file: " + filename);
        }

        return true;
    }
}

    public boolean updateCar() {
    System.out.print("Enter car ID to update: ");
    String updatedID = scanner.nextLine();
    int pos = searchID(updatedID);
    
    if (pos < 0) {
        System.out.println("Car not found.");
        return false;
    } else {
        ArrayList<Brand> brandOptions = brandList.getBrands();
        System.out.println("Choose a brand:");
        for (int i = 0; i < brandOptions.size(); i++) {
            System.out.println((i + 1) + ". " + brandOptions.get(i));
        }
        System.out.print("Enter your choice (1.." + brandOptions.size() + "): ");
        int brandChoice = Integer.parseInt(scanner.nextLine());
        Brand brand = brandOptions.get(brandChoice - 1);

        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        if (color.isEmpty()) {
            System.out.println("Color cannot be blank. Try again!");
            return false;
        }

        System.out.print("Enter frame ID: ");
        String frameID = scanner.nextLine();
        if (!frameID.matches("F\\d{5}")) {
            System.out.println("Frame ID must be in the format 'F00000'. Try again!");
            return false;
        } else if (searchFrame(frameID) != -1) {
            System.out.println("Frame ID already exists. Try another one!");
            return false;
        }

        System.out.print("Enter engine ID: ");
        String engineID = scanner.nextLine();
        if (!engineID.matches("E\\d{5}")) {
            System.out.println("Engine ID must be in the format 'E00000'. Try again!");
            return false;
        } else if (searchEngine(engineID) != -1) {
            System.out.println("Engine ID already exists. Try another one!");
            return false;
        }

        Car car = cars.get(pos);
        car.setBrand(brand);
        car.setColor(color);
        car.setFrameID(frameID);
        car.setEngineID(engineID);

        System.out.println("Car updated successfully!");
        return true;
    }
}

    public void listCars() {
        Collections.sort(cars);
        cars.forEach((car) -> {
            System.out.println(car.screenString());
        });
    }
     private Brand findBrandByID(String brandID) {
        for (Brand brand : brandList.getBrands()) {
            if (brand.getBrandID().equals(brandID)) {
                return brand;
            }
        }
        return null;
    }
}



