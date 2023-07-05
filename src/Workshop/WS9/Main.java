package Workshop.WS9;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static List<DictionaryWord> dictionaryWords = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("\n====== Menu ========");
            System.out.println("1. Add word");
            System.out.println("2. Show dictionary");
            System.out.println("3. Exit");
            System.out.print("\nYour choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("Add word: ");
                    String word = scanner.nextLine();
                    System.out.print("Add meaning: ");
                    String meaning = scanner.nextLine();
                    DictionaryWord newWord = new DictionaryWord(word, meaning);
                    if (checkExist(newWord)) {
                        System.out.println("Word already exist!");
                    } else {
                        dictionaryWords.add(newWord);
                    }
                }
                case 2 -> {
                    System.out.println("\n====== Dictionary ========");
                    dictionaryWords.sort(Comparator.comparing(DictionaryWord::getWord));
                    int i = 1;
                    for (DictionaryWord dictionaryWord : dictionaryWords) {
                        System.out.println(i + ". " + dictionaryWord.toString());
                        i++;
                    }
                }
                case 3 -> System.out.println("\n======== Goodbye ============");
                default -> System.out.println("Invalid choice! Choose again.");
            }

        } while (choice != 3);

    }

    private static boolean checkExist(DictionaryWord newWord) {
        for (DictionaryWord dictionaryWord : dictionaryWords) {
            if (dictionaryWord.getWord().equals(newWord.getWord())) {
                return true;
            }
        }
        return false;
    }
}