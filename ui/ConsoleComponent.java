package ui;

import java.util.Scanner;
import service.TransactionService;

public abstract class ConsoleComponent extends Component {
    protected final Scanner scanner;

    public ConsoleComponent(TransactionService transactionManager, Scanner scanner) {
        super(transactionManager);
        this.scanner = scanner;
    }
}
