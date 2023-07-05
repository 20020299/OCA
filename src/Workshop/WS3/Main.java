package Workshop.WS3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Molecule> molecules = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of molecules: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            scanner.nextLine();
            System.out.print("Structure: ");
            String structure = scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Weight: ");
            double weight = scanner.nextDouble();
            scanner.nextLine();
            Molecule molecule = new Molecule(structure, name, weight);
            molecules.add(molecule);
        }
        System.out.println("\nMolecules add successfully.");
        System.out.println();
        System.out.println("Molecule Information");
        System.out.println("====================");
        for (Molecule m : molecules) {
            m.display();
        }

        System.out.println();
        System.out.println("*********************");
        Atom a = new Atom();
        if (a.accept()) {
            for (Atom atom : a.atoms) {
                atom.display();
            }
        }

    }
}
