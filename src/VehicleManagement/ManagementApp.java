package VehicleManagement;

import java.io.*;
import java.util.*;

public class ManagementApp {
    private List<Vehicle> vehicles = new ArrayList<>();

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("\n=========== Menu ===========");
            System.out.println("1. Load data from file");
            System.out.println("2. Add new vehicle");
            System.out.println("3. Update vehicle by ID");
            System.out.println("4. Delete vehicle by ID");
            System.out.println("5. Search vehicle");
            System.out.println("6. Show vehicle list");
            System.out.println("7. Store data to file");
            System.out.println("8. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    loadFromFile();
                    break;
                case 2:
                    int nextChoice = 0;
                    do {
                        addVehicle();
                        System.out.println("\n========================");
                        System.out.println("1. Continue Adding");
                        System.out.println("2. Back to main menu");
                        System.out.print("Enter your choice: ");
                        nextChoice = scanner.nextInt();
                        if (nextChoice == 1) {
                        } else if (nextChoice == 2) {
                            break;
                        } else {
                            System.out.println("Invalid choice. Please try again.");
                        }
                    } while (nextChoice != 2);
                    break;
                case 3:
                    updateVehicle();
                    break;
                case 4:
                    deleteVehicle();
                    break;
                case 5:
                    searchVehicle();
                    break;
                case 6:
                    showVehicleList();
                    break;
                case 7:
                    storeToFile();
                    break;
                case 8:
                    System.out.println("Exiting. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);
    }

    public void loadFromFile() {
        vehicles.clear();
        try {
            File file = new File("data/vehicles.txt");
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data[0].equals("Car")) {
                        Car car = new Car(data[1], data[2], data[3], Double.parseDouble(data[4]), data[5],
                                data[6], Integer.parseInt(data[7]));
                        vehicles.add(car);
                    } else if (data[0].equals("Motorbike")) {
                        Motorbike motorbike = new Motorbike(data[1], data[2], data[3], Double.parseDouble(data[4]),
                                data[5], Double.parseDouble(data[6]), Boolean.parseBoolean(data[7]));
                        vehicles.add(motorbike);
                    }
                }
                br.close();
                System.out.println("Data loaded successfully from file.");
            } else {
                System.out.println("File not found. Please create the 'vehicles.txt' file.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading data from file.");
        }
    }

    public void addVehicle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter vehicle type (Car/Motorbike): ");
        String vehicleType = scanner.nextLine();
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();

        if (vehicleType.equals("Car")) {
            System.out.print("Enter car type: ");
            String carType = scanner.nextLine();
            System.out.print("Enter year of manufacture: ");
            int yearOfManufacture = scanner.nextInt();
            scanner.nextLine();

            Car car = new Car(id, name, color, price, brand, carType, yearOfManufacture);
            vehicles.add(car);
            System.out.println("Car added successfully.");


        } else if (vehicleType.equals("Motorbike")) {
            System.out.print("Enter speed: ");
            double speed = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Require license? (true/false): ");
            boolean requireLicense = scanner.nextBoolean();
            scanner.nextLine();

            Motorbike motorbike = new Motorbike(id, name, color, price, brand, speed, requireLicense);
            vehicles.add(motorbike);
            System.out.println("Motorbike added successfully.");

        } else {
            System.out.println("Invalid vehicle type.");
        }
    }

    public void updateVehicle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter vehicle ID: ");
        String id = scanner.nextLine();

        Vehicle vehicle = findVehicleById(id);
        if (vehicle != null) {
            vehicle.display();
            System.out.println("Enter new details:");

            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new color: ");
            String color = scanner.nextLine();
            System.out.print("Enter new price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Enter new brand: ");
            String brand = scanner.nextLine();

            vehicle.setName(name);
            vehicle.setColor(color);
            vehicle.setPrice(price);
            vehicle.setBrand(brand);

            System.out.println();
            vehicle.display();
            System.out.println();

            System.out.println("Vehicle updated successfully.");
        } else {
            System.out.println("Vehicle does not exist.");
        }
    }

    public void deleteVehicle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter vehicle ID: ");
        String id = scanner.nextLine();

        Vehicle vehicle = findVehicleById(id);
        if (vehicle != null) {
            vehicle.display();
            String confirm;
            do {
                System.out.println("Do you really want to delete this vehicle? (yes/no)");
                confirm = scanner.nextLine();
                if (confirm.equals("yes")) {
                    vehicles.remove(vehicle);
                    System.out.println("Vehicle deleted successfully.");
                }
                break;
            } while (confirm != "no");
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    public void searchVehicle() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== Search Vehicle =====");
            System.out.println("1. Search by name (descending)");
            System.out.println("2. Search by ID");
            System.out.println("3. Back to main menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle name: ");
                    String name = scanner.nextLine();
                    searchByNameDescending(name);
                    break;
                case 2:
                    System.out.print("Enter vehicle ID: ");
                    String id = scanner.nextLine();
                    Vehicle vehicle = findVehicleById(id);
                    if (vehicle != null) {
                        vehicle.display();
                    } else {
                        System.out.println("Vehicle not found.");
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    public void searchByNameDescending(String text) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            List<Vehicle> sortedVehicles = new ArrayList<>();
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getName().contains(text)) {
                    sortedVehicles.add(vehicle);
                }
            }
            Collections.sort(sortedVehicles, Comparator.comparing(Vehicle::getName).reversed());

            System.out.println("Vehicles sorted by name (descending):");
            for (Vehicle vehicle : sortedVehicles) {
                vehicle.display();
                System.out.println();
            }
        }
    }

    public void showVehicleList() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== Show Vehicle List =====");
            System.out.println("1. Show all vehicles");
            System.out.println("2. Show all vehicles (descending by price)");
            System.out.println("3. Back to main menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (vehicles.isEmpty()) {
                        System.out.println("No vehicles found.");
                    } else {
                        System.out.println("All vehicles:");
                        for (Vehicle vehicle : vehicles) {
                            vehicle.display();
                            System.out.println();
                        }
                    }
                    break;
                case 2:
                    if (vehicles.isEmpty()) {
                        System.out.println("No vehicles found.");
                    } else {
                        List<Vehicle> sortedVehicles = new ArrayList<>(vehicles);
                        sortedVehicles.sort(Comparator.comparing(Vehicle::getPrice).reversed());

                        System.out.println("Vehicles sorted by price (descending):");
                        for (Vehicle vehicle : sortedVehicles) {
                            if (vehicle instanceof Motorbike) {
                                ((Motorbike) vehicle).makeSound();
                            }
                            vehicle.display();
                            System.out.println();
                        }
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    public void storeToFile() {
        try {
            FileWriter fileWriter = new FileWriter("data/vehicles.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (Vehicle vehicle : vehicles) {
                if (vehicle instanceof Car) {
                    Car car = (Car) vehicle;
                    printWriter.println("Car," + car.getId() + "," + car.getName() + "," + car.getColor() + "," +
                            car.getPrice() + "," + car.getBrand() + "," + car.getType() + "," + car.getYear());
                } else if (vehicle instanceof Motorbike) {
                    Motorbike motorbike = (Motorbike) vehicle;
                    printWriter.println("Motorbike," + motorbike.getId() + "," + motorbike.getName() + "," + motorbike.getColor() +
                            "," + motorbike.getPrice() + "," + motorbike.getBrand() + "," + motorbike.getSpeed() + "," +
                            motorbike.isLicense());
                }
            }

            printWriter.close();
            System.out.println("Data stored successfully to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while storing data to file.");
        }
    }

    public Vehicle findVehicleById(String id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId().equals(id)) {
                return vehicle;
            }
        }
        return null;
    }


}
