package ui;

import java.util.Scanner;

public class ConsoleMenu {
    private final Scanner scanner;

    public ConsoleMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void display() {
        System.out.println();
        System.out.println("Expense Tracker");
        System.out.println("1. Add transaction");
        System.out.println("2. View transactions");
        System.out.println("3. Remove transaction");
        System.out.println("4. View financial summary");
        System.out.println("5. Exit");
    }

    public String readChoice() {
        if (!scanner.hasNextLine()) {
            return null;
        }
        System.out.print("Choose an option: ");
        return scanner.nextLine().trim();
    }
}
