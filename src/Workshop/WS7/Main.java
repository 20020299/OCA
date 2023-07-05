package Workshop.WS7;

import java.util.Scanner;

class IllegalTriangleException extends Exception {
    public IllegalTriangleException() {
        super("The given sides do not form a valid triangle.");
    }
}

class IllegalRightTriangleException extends Exception {
    public IllegalRightTriangleException() {
        super("The given sides do not form a valid right triangle.");
    }
}

class RightTriangle {
    private int sideA;
    private int sideB;
    private int sideC;

    public RightTriangle(int a, int b, int c) throws IllegalTriangleException, IllegalRightTriangleException {
        if (!isTriangle(a, b, c)) {
            throw new IllegalTriangleException();
        }

        if (!isRightTriangle(a, b, c)) {
            throw new IllegalRightTriangleException();
        }

        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
    }

    private boolean isTriangle(int a, int b, int c) {
        return (a + b > c) && (b + c > a) && (c + a > b);
    }

    private boolean isRightTriangle(int a, int b, int c) {
        return (a * a + b * b == c * c) ||
                (b * b + c * c == a * a) ||
                (c * c + a * a == b * b);
    }

    public int getSideA() {
        return sideA;
    }

    public int getSideB() {
        return sideB;
    }

    public int getSideC() {
        return sideC;
    }
}

public class Main {
    public static void main(String[] args) {
        int a, b, c;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter side a: ");
            a = scanner.nextInt();
            System.out.print("Enter side b: ");
            b = scanner.nextInt();
            System.out.print("Enter side c: ");
            c = scanner.nextInt();
            try {
                RightTriangle rt = new RightTriangle(a, b, c);
                System.out.println("This is a right triangle!");
            } catch (IllegalTriangleException e1) {
                System.out.println("This is not a triangle!");
            } catch (IllegalRightTriangleException e2) {
                System.out.println("This is not a right triangle!");
            }
            System.out.print("Continue?(Y/N)");
            char choice = scanner.next().charAt(0);
            if (choice != 'Y') {
                break;
            }
        }
    }
}

