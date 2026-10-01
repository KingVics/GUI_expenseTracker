package ui;

import java.util.List;
import java.util.Scanner;
import model.*;
import service.TransactionService;

public class TransactionComponent extends ConsoleComponent {
    public TransactionComponent(TransactionService transactionManager, Scanner scanner) {
        super(transactionManager, scanner);
    }

    public void addTransaction() {
        System.out.print("Type (1 for income, 2 for expense): ");
        String typeInput = scanner.nextLine().trim();
        TransactionType type;

        if ("1".equals(typeInput)) {
            type = TransactionType.INCOME;
        } else if ("2".equals(typeInput)) {
            type = TransactionType.EXPENSE;
        } else {
            System.out.println("Invalid transaction type.");
            return;
        }

        System.out.print("Amount: ");
        String amountInput = scanner.nextLine().trim();
        double amount;
        try {
            amount = Double.parseDouble(amountInput);
        } catch (NumberFormatException e) {
            System.out.println("Enter an amount greater than zero.");
            return;
        }

        if (!Double.isFinite(amount) || amount <= 0.0) {
            System.out.println("Enter an amount greater than zero.");
            return;
        }

        System.out.print("Category: ");
        String category = scanner.nextLine().trim();
        if (category.isEmpty()) {
            System.out.println("Category cannot be empty.");
            return;
        }

        System.out.print("Description (optional): ");
        String description = scanner.nextLine().trim();

        transactionManager.add(type, amount, category, description);
        System.out.println(type.getLabel() + " recorded.");
    }

    public void showTransactions() {
        List<Transaction> transactions = transactionManager.getAll();
        if (transactions.isEmpty()) {
            System.out.println("No transactions recorded yet.");
            return;
        }

        System.out.println();
        System.out.println("Transaction records");
        for (Transaction transaction : transactions) {
            displayTransaction(transaction);
        }
    }

    public void removeTransaction() {
        if (transactionManager.getAll().isEmpty()) {
            System.out.println("There are no transactions to remove.");
            return;
        }

        showTransactions();
        System.out.print("Enter the transaction ID to remove: ");
        String idInput = scanner.nextLine().trim();
        Integer id;
        try {
            id = Integer.parseInt(idInput);
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid transaction ID.");
            return;
        }

        if (transactionManager.remove(id)) {
            System.out.println("Transaction " + id + " removed.");
        } else {
            System.out.println("No transaction found with ID " + id + ".");
        }
    }

    private void displayTransaction(Transaction transaction) {
        String details = "";
        if (transaction.getDescription() != null && !transaction.getDescription().isBlank()) {
            details = " - " + transaction.getDescription();
        }

        System.out.println("#" + transaction.getId() + ". "
                + transaction.getType().getLabel() + ": "
                + formatAmount(transaction.getAmount()) + " | "
                + transaction.getCategory() + details);
    }
}
