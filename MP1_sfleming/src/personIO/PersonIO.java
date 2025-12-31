package personIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonIO {
    private static final String FILE_NAME = "persons.dat";
    private Scanner scanner = new Scanner(System.in);

    // Add a person to the binary file
    public void addPerson() {
        System.out.println("Please enter the person's name:");
        String name = scanner.nextLine();

        System.out.println("Please enter the person's age:");
        int age = -1;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid age entered. Person not added.");
            return;
        }

        Person person = new Person(name, age);

        // Read existing persons into a list
        List<Person> persons = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            persons = (List<Person>) ois.readObject();
        } catch (FileNotFoundException e) {
            // File does not exist yet, that's fine
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading existing persons. Starting fresh.");
        }

        persons.add(person);

        // Write the updated list back to the file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(persons);
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    // Display all persons in the binary file
    public void displayPersons() {
        List<Person> persons = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            persons = (List<Person>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No persons found.");
            return;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading persons from file.");
            return;
        }

        System.out.println("***********************");
        for (Person p : persons) {
            System.out.println(p);
        }
        System.out.println("***********************");
    }

    // Main menu loop
    public void menu() {
        int choice = -1;

        while (choice != 0) {
            System.out.println("Please choose an option:");
            System.out.println("0: quit");
            System.out.println("1: add");
            System.out.println("2: display");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter 0, 1, or 2.");
                continue;
            }

            switch (choice) {
                case 0:
                    System.out.println("Bye");
                    break;
                case 1:
                    addPerson();
                    break;
                case 2:
                    displayPersons();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 0, 1, or 2.");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        PersonIO personIO = new PersonIO();
        personIO.menu();
    }
}
