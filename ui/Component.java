package ui;

import java.util.Locale;
import service.TransactionService;

public abstract class Component {
    protected final TransactionService transactionManager;

    public Component(TransactionService transactionManager) {
        this.transactionManager = transactionManager;
    }

    protected String formatAmount(double amount) {
        return String.format(Locale.US, "%.2f", amount);
    }
}
