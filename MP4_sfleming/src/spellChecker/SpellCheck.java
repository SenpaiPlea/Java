package spellChecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SpellCheck {

    private HashSet<String> dictionary = new HashSet<>();
    private TreeSet<String> miss_spelled_words = new TreeSet<>();

    // Constructor — loads dictionary.txt into HashSet
    public SpellCheck() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("dictionary.txt"));
        while (scan.hasNextLine()) {
            dictionary.add(scan.nextLine().toLowerCase());
        }
        scan.close();
    }

    public void checkSpelling(String fileName) throws FileNotFoundException {
        System.out.println("======== Spell checking " + fileName + " =========");

        miss_spelled_words.clear(); // clear previous file's misspelled words

        Scanner fileScan = new Scanner(new File(fileName));
        Scanner inputScan = new Scanner(System.in); // single input scanner

        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            String[] words = line.split(" +|\\p{Punct}");

            boolean linePrinted = false;

            for (String word : words) {
                word = word.toLowerCase();

                if (word.length() == 0) continue; // skip empty
                if (!Character.isLetter(word.charAt(0))) continue; // skip numbers/symbols
                if (dictionary.contains(word) || miss_spelled_words.contains(word)) continue;

                if (word.endsWith("s")) {
                    String singular = word.substring(0, word.length() - 1);
                    if (dictionary.contains(singular) || miss_spelled_words.contains(singular)) continue;
                }

                if (!linePrinted) {
                    System.out.println("Line: " + line);
                    linePrinted = true;
                }

                System.out.println("Unknown word found: " + word);
                System.out.print("Add to dictionary (d) or mark as misspelled (m)? ");
                String response = inputScan.nextLine();

                if (response.equalsIgnoreCase("d")) {
                    dictionary.add(word);
                } else {
                    miss_spelled_words.add(word);
                }
            }
        }

        fileScan.close();
        // Do not close inputScan here if used in main()
    }

    public void dump_miss_spelled_words() {
        for (String word : miss_spelled_words) {
            System.out.println(word);
        }
    }

    public static void main(String[] args) {
        try {
            SpellCheck spellCheck = new SpellCheck();

            for (String fileName : args) {
                spellCheck.checkSpelling(fileName);
                spellCheck.dump_miss_spelled_words();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
