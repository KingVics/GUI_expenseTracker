package model;

public class FinancialSummary {
    private final double totalIncome;
    private final double totalExpenses;

    public FinancialSummary(double totalIncome, double totalExpenses) {
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public double getBalance() {
        return totalIncome - totalExpenses;
    }
}
