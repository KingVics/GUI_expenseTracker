package service;

import java.util.List;
import model.*;

public interface TransactionService {
    Transaction add(TransactionType type, double amount, String category, String description);
    List<Transaction> getAll();
    boolean remove(int id);
    FinancialSummary getSummary();
}
