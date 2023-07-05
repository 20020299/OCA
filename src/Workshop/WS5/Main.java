package Workshop.WS5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        System.out.println("Enter list of phone numbers");
        System.out.println("------------------------------------------");
        int choice;
        do {
            System.out.println();
            System.out.print("Type of phone number ? (1 - local phone, 2 - Inter phone number, 0 - exit): ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter area code: ");
                    int area = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter number: ");
                    String number = scanner.nextLine();
                    PhoneNumber phoneNumber = new PhoneNumber(area, number);
                    phoneNumbers.add(phoneNumber);
                    break;
                case 2:
                    System.out.print("Enter country code: ");
                    String countryCode = scanner.nextLine();
                    System.out.print("Enter area code: ");
                    int areaInt = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter number: ");
                    String numberInt = scanner.nextLine();
                    IntPhoneNumber intPhoneNumber = new IntPhoneNumber(countryCode, areaInt, numberInt);
                    phoneNumbers.add(intPhoneNumber);
                    break;
                case 0:
                    System.out.println();
                    System.out.println("List of phone number: ");
                    System.out.println("------------------------------------------");
                    for (PhoneNumber p : phoneNumbers) {
                        p.display();
                    }
                    break;
                default:
                    System.out.println("Invalid type of phone number. Please try again.");
            }
        } while (choice != 0);


        /*
        ==================================================================================================
         */
        Person[] p = new Person[10];
        int n = 0, c = 0;
        do{
            System.out.println("Worker (1); Officer(2): ");
            Scanner in = new Scanner(System.in);
            c = in.nextInt();
            if(c == 1){
                //accept information of worker
                System.out.print("Enter worker name: ");
                String name = in.next();
                System.out.print("Enter worker working hours: ");
                int hrs = in.nextInt();
                p[n] = new Worker(name, hrs);
                n++;
            }else if(c == 2){
                //accept information of Officer
                System.out.print("Enter Officer name: ");
                String name = in.next();
                System.out.print("Enter officer salary: ");
                double salary = in.nextDouble();
                p[n] = new Officer(name, salary);
                n++;
            }
        }while(c != 0);
        //print all objects of e
        for(int i = 0; i < n; i++){
            //print the instance of Worker only
            if(p[i] instanceof Worker)
                p[i].display();
        }

    }
}
