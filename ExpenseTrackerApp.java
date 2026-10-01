import java.util.Scanner;
import ui.*;
import model.*;
import service.*;

public class ExpenseTrackerApp {
    public final TransactionService transactionManager;
    private final ConsoleMenu menu;
    private final TransactionComponent transactionComponent;
    private final FinancialSummaryComponent summaryComponent;

    public ExpenseTrackerApp() {
        this(new TransactionManager(), new Scanner(System.in));
    }

    public ExpenseTrackerApp(Scanner scanner) {
        this(new TransactionManager(), scanner);
    }

    public ExpenseTrackerApp(TransactionService transactionManager, Scanner scanner) {
        this.transactionManager = transactionManager;
        this.menu = new ConsoleMenu(scanner);
        this.transactionComponent = new TransactionComponent(transactionManager, scanner);
        this.summaryComponent = new FinancialSummaryComponent(transactionManager);
    }

    public void run() {
        while (true) {
            menu.display();
            String choice = menu.readChoice();

            if (choice == null) {
                System.out.println("Goodbye!");
                return;
            }

            switch (choice) {
                case "1":
                    transactionComponent.addTransaction();
                    break;
                case "2":
                    transactionComponent.showTransactions();
                    break;
                case "3":
                    transactionComponent.removeTransaction();
                    break;
                case "4":
                    summaryComponent.showSummary();
                    break;
                case "5":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Please choose a number from 1 to 5.");
                    break;
            }
        }
    }
}
