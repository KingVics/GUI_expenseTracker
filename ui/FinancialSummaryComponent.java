package ui;

import model.FinancialSummary;
import service.TransactionService;

public class FinancialSummaryComponent extends Component {
    public FinancialSummaryComponent(TransactionService transactionManager) {
        super(transactionManager);
    }

    public void showSummary() {
        FinancialSummary summary = transactionManager.getSummary();
        System.out.println();
        System.out.println("Financial summary");
        System.out.println("Total income:   " + formatAmount(summary.getTotalIncome()));
        System.out.println("Total expenses: " + formatAmount(summary.getTotalExpenses()));
        System.out.println("Remaining balance: " + formatAmount(summary.getBalance()));
    }
}
