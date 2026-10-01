package service;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class TransactionManager implements TransactionService {
    private final List<Transaction> transactions = new ArrayList<>();
    private int nextId = 1;

    public Transaction add(TransactionType type, double amount, String category, String description) {
        if (!Double.isFinite(amount) || amount <= 0.0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be empty.");
        }

        String trimmedCategory = category.trim();
        String trimmedDescription = description == null ? "" : description.trim();
        Transaction transaction = new Transaction(nextId++, type, amount, trimmedCategory, trimmedDescription);
        transactions.add(transaction);
        return transaction;
    }

    public List<Transaction> getAll() {
        return new ArrayList<>(transactions);
    }

    public boolean remove(int id) {
        return transactions.removeIf(transaction -> transaction.getId() == id);
    }

    public FinancialSummary getSummary() {
        double income = 0.0;
        double expenses = 0.0;

        for (Transaction transaction : transactions) {
            if (transaction.getType() == TransactionType.INCOME) {
                income += transaction.getAmount();
            } else if (transaction.getType() == TransactionType.EXPENSE) {
                expenses += transaction.getAmount();
            }
        }

        return new FinancialSummary(income, expenses);
    }
}
