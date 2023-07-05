package ManagementProgram;

import java.io.*;
import java.util.*;

public class Program {
    private static String userID;
    private static Scanner scanner = new Scanner(System.in);
    private static List<Asset> assets = new ArrayList<>();
    private static List<Employee> employees = new ArrayList<>();
    private static List<Info> borrowedList = new ArrayList<>();
    private static List<Info> requestList = new ArrayList<>();
    private static boolean isLoggedIn = false;

    public static void managerProgram() {
        loadAssetFromFile();
        loadEmployeeFromFile();
        loadRequestFromFile();
        loadBorrowFromFile();
        displayLogin();

        while (isLoggedIn) {
            displayMenu();
            String choice = getUserChoice();

            switch (choice) {
                case "1":
                    searchAsset();
                    break;
                case "2":
                    createAsset();
                    break;
                case "3":
                    updateAsset();
                    break;
                case "4":
                    approveRequest();
                    break;
                case "5":
                    showBorrowedList();
                    break;
                case "6":
                    logout();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayLogin() {
        scanner.nextLine();
        System.out.println("\n=== Management Program ===");
        System.out.print("Enter your employID: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Perform login validation
        if (validateLogin(username, password)) {
            System.out.println("Successfully!");
            isLoggedIn = true;
        } else {
            System.out.println("Incorrect id or password.");
        }
    }

    private static boolean validateLogin(String username, String password) {
        for (Employee employee : employees) {
            if (employee.getEmployeeID().equals(username) && employee.getPasswaord().equals(password) && employee.getRole().equals("MA")){
                return true;
            }
        }
        return false;
    }

    private static void displayMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Search asset by name");
        System.out.println("2. Create new asset");
        System.out.println("3. Update asset's information");
        System.out.println("4. Approve employee's request");
        System.out.println("5. Show list of borrowed assets");
        System.out.println("6. Logout");
    }

    private static String getUserChoice() {
        System.out.print("Enter your choice (1-6): ");
        return scanner.nextLine();
    }

    private static void searchAsset() {
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the asset name to search: ");
        String assetName = scanner.nextLine();
        List<Asset> foundAssets = new ArrayList<>();

        for (Asset asset : assets) {
            if (asset.getName().toLowerCase().contains(assetName.toLowerCase())) {
                System.out.println("found!");
                foundAssets.add(asset);
            }
        }

        Collections.sort(foundAssets, Comparator.comparing(Asset::getName).reversed());

        System.out.println("Searched assets:");
        for (Asset asset : foundAssets) {
            asset.display();
        }
    }

    private static void createAsset() {
        scanner.nextLine(); // Consume the newline character
        int choice = 0;
        do {
            System.out.print("Enter the asset ID: ");
            String assetID = scanner.nextLine();
            System.out.print("Enter the asset name: ");
            String assetName = scanner.nextLine();
            System.out.print("Enter the asset color: ");
            String assetColor = scanner.nextLine();
            System.out.print("Enter the asset price: ");
            double assetPrice = scanner.nextDouble();
            System.out.print("Enter the asset weight: ");
            double assetWeight = scanner.nextDouble();
            System.out.print("Enter the asset quantity: ");
            int assetQuantity = scanner.nextInt();

            Asset newAsset = new Asset(assetID, assetName, assetColor, assetPrice, assetWeight, assetQuantity);
            assets.add(newAsset);
            System.out.println("Asset created successfully.");
            writeAssetToFile();

            System.out.println("\n========================");
            System.out.println("1. Continue Adding");
            System.out.println("2. Back to main menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
            } else if (choice == 2) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 2);
    }

    private static void updateAsset() {
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter the asset ID to update: ");
        String assetID = scanner.nextLine();

        for (Asset asset : assets) {
            if (asset.getAssetId().equals(assetID)) {
                asset.display();
                System.out.print("Enter the asset name: ");
                String newName = scanner.nextLine();
                if (newName != null) {
                    asset.setName(newName);
                }
                System.out.print("Enter the asset color: ");
                String newColor = scanner.nextLine();
                if (newColor != null) {
                    asset.setColor(newColor);
                }
                System.out.print("Enter the asset price: ");
                double newPrice = scanner.nextDouble();
                System.out.print("Enter the asset weight: ");
                double newWeight = scanner.nextDouble();
                asset.setWeight(newWeight);
                System.out.print("Enter the asset quantity: ");
                int newQuantity = scanner.nextInt();
                asset.setQuantity(newQuantity);
                System.out.println("New asset: ");
                asset.display();
                break;
            }
        }
    }

    private static void approveRequest() {
        scanner.nextLine(); // Consume the newline character

        System.out.println("\n=== Borrow Requests ===");
        for (Info info : requestList) {
            info.display();
        }

        System.out.print("Enter the ID of the employee's request to approve: ");
        String approveID = scanner.nextLine();

        Info approveRequest = new Info();

        for (Info info : requestList) {
            if (info.getID().equals(approveID)) {
                approveRequest = info;
            }
        }
        if (checkInStock(approveRequest)) {
            insertToBorrow(approveRequest);
            requestList.remove(approveRequest);
            writeRequestToFile();
            updateQuantity(approveRequest);
        } else {
            System.out.println("ERROR!");
        }
    }

    private static boolean checkInStock(Info request) {
        for (Asset asset : assets) {
            if (asset.getAssetId().equals(request.getAssetID())) {
                if (request.getQuantity() <= asset.getQuantity()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void updateQuantity(Info info) {
        for (Asset asset : assets) {
            if (asset.getAssetId().equals(info.getAssetID())) {
                int tmp = asset.getQuantity() - info.getQuantity();
                asset.setQuantity(tmp);
            }
        }
        writeAssetToFile();
    }

    private static void insertToBorrow(Info info) {
        info.setID(info.getID().replace('R', 'B'));
        borrowedList.add(info);
        writeBorrowToFile();
    }

    private static void showBorrowedList() {
        System.out.println("\n=== List of Borrowed Assets ===");
        if (borrowedList.isEmpty()) {
            System.out.println("No assets are currently borrowed.");
        } else {
            for (Info info : borrowedList) {
                info.display();
            }
        }
    }

    public static void employeeProgram() {
        loadAssetFromFile();
        loadEmployeeFromFile();
        loadRequestFromFile();
        loadBorrowFromFile();
        userID = displayLogin2();

        while (isLoggedIn) {
            displayMenu2();
            String choice = getUserChoice2();

            switch (choice) {
                case "1":
                    searchAsset();
                    break;
                case "2":
                    createRequest();
                    break;
                case "3":
                    cancelRequest();
                    break;
                case "4":
                    returnRequest();
                    break;
                case "5":
                    logout();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static String displayLogin2() {
        scanner.nextLine();
        System.out.println("\n=== Employee Program ===");
        System.out.print("Enter your employID: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Perform login validation
        if (validateLogin2(username, password)) {
            System.out.println("Successfully!");
            isLoggedIn = true;
            return username;
        } else {
            System.out.println("Incorrect id or password.");
            return "";
        }
    }

    private static boolean validateLogin2(String username, String password) {
        for (Employee employee : employees) {
            if (employee.getEmployeeID().equals(username) && employee.getPasswaord().equals(password) && employee.getRole().equals("EM")){
                return true;
            }
        }
        return false;
    }

    private static void displayMenu2() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Search asset by name");
        System.out.println("2. Borrow the assets");
        System.out.println("3. Cancel request");
        System.out.println("4. Return asset");
        System.out.println("5. Logout");
    }

    private static String getUserChoice2() {
        System.out.print("Enter your choice (1-5): ");
        return scanner.nextLine();
    }

    private static void createRequest() {
        System.out.println("______________________________");
        System.out.println("Assets list");
        for (Asset asset : assets) {
            asset.display();
        }

        char choice;
        do {
            System.out.println();
            scanner.nextLine();
            System.out.print("Enter requestID: ");
            String requestID = scanner.nextLine();
            System.out.print("Enter assetID: ");
            String assetID = scanner.nextLine();
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            Info newRequest = new Info(requestID, assetID, userID, quantity, "NA");
            requestList.add(newRequest);
            System.out.println("Add request success!");
            System.out.print("Continues?(Y/N): ");
            choice = scanner.next().charAt(0);
        } while (choice != 'N');

        writeRequestToFile();

    }

    private static void cancelRequest() {
        System.out.println("______________________________");
        System.out.println("Your request list");
        for (Info i : requestList) {
            if (i.getEmployeeID().equals(userID)) {
                i.display();
            }
        }


        char choice;
        do {
            System.out.println();
            scanner.nextLine();
            System.out.print("Enter deleted requestID: ");
            String requestID = scanner.nextLine();
            System.out.print("Do you sure you want to delete this requet?(Y/N): ");
            char confirm = scanner.next().charAt(0);
            if (confirm == 'Y') {
                for (Info i : requestList) {
                    if (i.getID().equals(requestID)) {
                        requestList.remove(i);
                        System.out.println("Delete success!");
                        break;
                    }
                }
                System.out.print("Continues?(Y/N): ");
                choice = scanner.next().charAt(0);
            } else {
                break;
            }
        } while (choice != 'N');

        writeRequestToFile();
    }

    private static void returnRequest() {
        System.out.println("______________________________");
        System.out.println("Your borrow list");
        for (Info i : borrowedList) {
            if (i.getEmployeeID().equals(userID)) {
                i.display();
            }
        }

        char choice;
        do {
            System.out.println();
            scanner.nextLine();
            System.out.print("Enter borrowID you want to return: ");
            String returnID = scanner.nextLine();
            System.out.print("Do you sure you want to return this asset?(Y/N): ");
            char confirm = scanner.next().charAt(0);
            if (confirm == 'Y') {
                for (Info i : borrowedList) {
                    if (i.getID().equals(returnID)) {
                        borrowedList.remove(i);
                        updateReturnQuantity(i);
                        System.out.println("Return success!");
                        break;
                    }
                }
                System.out.print("Continues?(Y/N): ");
                choice = scanner.next().charAt(0);
            } else {
                break;
            }
        } while (choice != 'N');

        writeBorrowToFile();

    }

    private static void updateReturnQuantity(Info info) {
        for (Asset asset : assets) {
            if (asset.getAssetId().equals(info.getAssetID())) {
                int tmp = asset.getQuantity() + info.getQuantity();
                System.out.println(tmp);
                asset.setQuantity(tmp);
            }
        }
        writeAssetToFile();
    }

    private static void logout() {
        isLoggedIn = false;
    }

    public static void loadAssetFromFile() {
        assets.clear();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/asset.dat"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                Asset asset = new Asset(data[0], data[1], data[2],
                        Double.parseDouble(data[3]), Double.parseDouble(data[4]), Integer.parseInt(data[5]));
                assets.add(asset);
            }
            reader.close();
            //System.out.println("Data loaded successfully from file.");
        } catch(IOException e){
            System.out.println("An error occurred while loading data from file.");
        }
    }

    public static void writeAssetToFile() {
        try {
            FileWriter fileWriter = new FileWriter("data/asset.dat");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (Asset asset : assets) {
                printWriter.println(asset.getAssetId() + "\t" + asset.getName() + "\t" + asset.getColor() + "\t" +
                        asset.getPrice() + "\t" + asset.getWeight() + "\t" + asset.getQuantity());
            }

            printWriter.close();
            //System.out.println("Data stored successfully to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while storing data to file.");
        }
    }

    public static void loadEmployeeFromFile() {
        employees.clear();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/employee.dat"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                Employee employee = new Employee(data[0], data[1], data[2], data[3], data[4], data[5]);
                employees.add(employee);
            }
            reader.close();
            //System.out.println("Data loaded successfully from file.");
        } catch(IOException e){
            System.out.println("An error occurred while loading data from file.");
        }
    }

    public static void loadRequestFromFile() {
        requestList.clear();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/request.dat"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                Info info = new Info(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4]);
                requestList.add(info);
            }
            reader.close();
            //System.out.println("Data loaded successfully from file.");
        } catch(IOException e){
            System.out.println("An error occurred while loading data from file.");
        }
    }

    public static void writeRequestToFile() {
        try {
            FileWriter fileWriter = new FileWriter("data/request.dat");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (Info info : requestList) {
                printWriter.println(info.getID() + "\t" + info.getAssetID() + "\t" + info.getEmployeeID() + "\t" +
                        info.getQuantity() + "\t" + info.getDateTime());
            }

            printWriter.close();
            //System.out.println("Data stored successfully to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while storing data to file.");
        }
    }

    public static void loadBorrowFromFile() {
        borrowedList.clear();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/borrow.dat"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                Info info = new Info(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4]);
                borrowedList.add(info);
            }
            reader.close();
            //System.out.println("Data loaded successfully from file.");
        } catch(IOException e){
            System.out.println("An error occurred while loading data from file.");
        }
    }

    public static void writeBorrowToFile() {
        try {
            FileWriter fileWriter = new FileWriter("data/borrow.dat");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (Info info : borrowedList) {
                printWriter.println(info.getID() + "\t" + info.getAssetID() + "\t" + info.getEmployeeID() + "\t" +
                        info.getQuantity() + "\t" + info.getDateTime());
            }

            printWriter.close();
            //System.out.println("Data stored successfully to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while storing data to file.");
        }
    }

    public static void main(String[] args) {
        String choice;
        do {
            System.out.println();
            System.out.println("============= Asset Management App ===============");
            System.out.println("1. Manager");
            System.out.println("2. Employee");
            System.out.println("3. Exit");
            System.out.print("Choose your character: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    managerProgram();
                    break;
                case "2":
                    employeeProgram();
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (!choice.equals("3"));
    }
}
