package Workshop.WS8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileEncryption {
    public static void main(String[] args) {
        String inputFile = "data/input.txt";
        String outputFile = "data/output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            int shift = 3; // Number of characters to shift

            int character;
            while ((character = reader.read()) != -1) {
                if (Character.isLetter(character)) {
                    char encryptedChar = (char) (character + shift);
                    if (!Character.isLetter(encryptedChar)) {
                        encryptedChar -= 26; // Wrap around to the beginning of the alphabet
                    }
                    writer.write(encryptedChar);
                } else {
                    writer.write(character);
                }
            }

            System.out.println("File encrypted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}