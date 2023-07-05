package Workshop.WS6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //displayName();
        anagramChecker();
    }

    public static void displayName() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine();

        String initials = computeInitials(fullName);
        System.out.println("Your initials are: " + initials);
    }

    public static String computeInitials(String fullName) {
        StringBuilder initials = new StringBuilder();

        String[] nameParts = fullName.split(" ");
        for (String part : nameParts) {
            initials.append(Character.toUpperCase(part.charAt(0)));
        }

        return initials.toString();
    }

    public static void anagramChecker() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();

        boolean isAnagram = checkAnagram(str1, str2);
        if (isAnagram) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }
    }

    public static boolean checkAnagram(String str1, String str2) {
        // Remove white space and punctuation
        String cleanStr1 = str1.replaceAll("[\\s\\p{Punct}]", "").toLowerCase();
        String cleanStr2 = str2.replaceAll("[\\s\\p{Punct}]", "").toLowerCase();

        // Check if the lengths are equal
        if (cleanStr1.length() != cleanStr2.length()) {
            return false;
        }

        String tmp = cleanStr1;

        for (int i = 0; i < cleanStr1.length(); i++) {
            cleanStr1 = cleanStr1.replaceAll(tmp.substring(i, i+1), " ");
            cleanStr2 = cleanStr2.replaceAll(tmp.substring(i, i+1), " ");
        }

        System.out.println(cleanStr1);
        System.out.println(cleanStr2);

        return cleanStr1.equals(cleanStr2);
    }
}
