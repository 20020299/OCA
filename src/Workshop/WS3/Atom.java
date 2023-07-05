package Workshop.WS3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Atom {
    int number;
    private String symbol;
    private String fullname;
    private double weight;

    public List<Atom> atoms = new ArrayList<>();

    public Atom() {
    }

    public Atom(int number, String symbol, String fullname, double weight) {
        this.number = number;
        this.symbol = symbol;
        this.fullname = fullname;
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void display() {
        System.out.println(this.number + "\t" + this.symbol + "\t" + this.fullname + "\t" + this.weight);
    }

    public boolean accept() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of atoms: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        System.out.println("Atomic Information");
        System.out.println("==================");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter atomic number: ");
            int a = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter symbol: ");
            String s = scanner.nextLine();
            System.out.print("Enter full name: ");
            String f = scanner.nextLine();
            System.out.print("Enter atomic weight: ");
            double w = scanner.nextDouble();
            scanner.nextLine();
            System.out.println();
            Atom atom = new Atom(a, s, f, w);
            atoms.add(atom);
        }
        return true;
    }
}
