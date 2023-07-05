package Workshop.WS8;

import VehicleManagement.Car;
import VehicleManagement.Motorbike;
import VehicleManagement.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("\nMenu");
            System.out.println("_________________________________________");
            System.out.println("1. Add a list of Student and save to File");
            System.out.println("2. Loading list of  Students from a File");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addList();
                    break;
                case 2:
                    loadList();
                    break;
                case 3:
                    System.out.println("\nGoodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);
    }

    private static void addList() {
        Scanner scanner = new Scanner(System.in);
        char choice;
        do {
            scanner.nextLine();
            System.out.println("========================================");
            System.out.print("Enter student's name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student's age: ");
            int age = scanner.nextInt();
            System.out.print("Enter student's mark: ");
            double mark = scanner.nextDouble();
            scanner.nextLine();
            Student newStudent = new Student(name, age, mark);
            students.add(newStudent);
            System.out.println("Add success!");
            System.out.print("Continue adding?(Y/N): ");
            choice = scanner.next().charAt(0);
        } while (choice != 'N');

        writeToFile();
    }

    private static void writeToFile() {
        try {
            FileWriter fileWriter = new FileWriter("data/student.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (Student student : students) {
                printWriter.println(student.getName() + "\t" + student.getAge() + "\t" + student.getMark());
            }

            printWriter.close();
            System.out.println("Data stored successfully to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while storing data to file.");
        }
    }

    private static void loadList() {
        System.out.println();
        readFromFile();
        System.out.println();
        System.out.println("Students list");
        System.out.println("_________________________________________________");
        for (Student student : students) {
            student.display();
        }
    }

    private static void readFromFile() {
        students.clear();
        try {
            File file = new File("student.txt");
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split("\t");
                    Student newStudent = new Student(data[0], Integer.parseInt(data[1]), Double.parseDouble(data[2]));
                    students.add(newStudent);
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
}
