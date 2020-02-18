import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BankApplication app = new BankApplication(new InputHelper(scan));
        app.runApplication();
    }

    private Bank bank;
    private InputHelper ih;
    private boolean isTesting = false;

    public BankApplication(InputHelper ih) {
        this.bank = new Bank();
        this.ih = ih;
        this.isTesting = ih instanceof InputTester;
    }

    public void runApplication() {
        while (true) {
            displayMenu();
            System.out.println(readInput());
        }
    }

    public void displayMenu() {
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("1. Hitta konto utifrån innehavare");
        System.out.println("2. Sök kontoinnehavare utifrån (del av) namn");
        System.out.println("3. Sätt in");
        System.out.println("4. Ta ut");
        System.out.println("5. Överföring");
        System.out.println("6. Skapa konto");
        System.out.println("7. Ta bort konto");
        System.out.println("8. Skriv ut konton");
        System.out.println("9. Avsluta");
    }

    /**
     * Alla cases kommer returnera den sträng som ska visas för användaren för att göra mer testbar kod.
     */
    public String readInput() {
        String result;
        int input;

        try {
            input = ih.readInt("val: ");
            switch (input) {
                case 1: result = handleFindById(); break;
                case 2: result = handleFindByPart(); break;
                case 3: result = handleDeposit(); break;
                case 4: result = handleWithdraw(); break;
                case 5: result = handleTransfer(); break;
                case 6: result = handleCreate(); break;
                case 7: result = handleDelete(); break;
                case 8: result = handlePrint(); break;
                case 9: System.exit(0);
                default: result = "Vänligen välj ett giltligt alternativ.";
            }
        } catch (InputMismatchException e) {
            result = e.getMessage();
        }
        return result;
    }

    private String handleFindById() {
        int query = ih.readInt("id: ");
        return listAccounts(bank.findAccountsForHolder(query));
    }

    private String handleFindByPart() {
        String query = ih.readLine("namn: ");
        ArrayList<Customer> customers = bank.findByPartofName(query);
        return listFromCustomers(customers);
    }

    private String handleDeposit() {
        BankAccount account = getAccount("från konto: ");
        double amount = getPositiveAmount();

        account.deposit(amount);
        return listAccount(account);
    }

    private String handleWithdraw() {
        BankAccount account = getAccount("från konto: ");
        double amount = getPositiveAmount();
        double balance = account.getAmount();

        if (balance < amount) {
            return String.format("uttaget misslyckades, endast %.2f på kontot!", balance);
        }
        else {
            account.withdraw(amount);
            return listAccount(account);
        }
    }

    private String handleTransfer() {
        BankAccount fromAccount = getAccount("från konto: ");
        BankAccount toAccount = getAccount("till konto: ");
        double amount = getPositiveAmount();

        if (amount > fromAccount.getAmount()) {
            return String.format("överföringen misslyckades, endast %.2f på kontot!", fromAccount.getAmount());
        } else {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            return listAccount(fromAccount) + listAccount(toAccount);
        }
    }

    private String handleCreate() {
        String name = ih.readLine("namn: ");
        int idNr = ih.readInt("id: ");
        int accountNr = createAccount(name, idNr);
        if (accountNr == -1) return "kunde inte skapa konto, id och namn stämde ej överrens";
        return "konto skapat: " + accountNr;
    }

    private String handleDelete() {
        BankAccount account = getAccount("konto: ");
        bank.removeAccount(account.getAccountNumber());
        return "konto borttaget.";
    }

    private int createAccount(String name, int idNr) {
        return bank.addAccount(name, idNr);
    }

    private String handlePrint() {
        ArrayList<BankAccount> accounts = bank.getAllAccounts();
        ArrayList<BankAccount> sortedAccounts = new ArrayList<>();

        return listAccounts(bank.getAllAccounts());
    }

    private String listAccounts(ArrayList<BankAccount> accounts) {
        Collections.sort(accounts);
        StringBuilder result = new StringBuilder(); // String builder ger bättre prestanda än concat.
        String str = "";
        for (BankAccount acc: accounts) {
            str = listAccount(acc);
            result.append(str);
        }
        return result.toString();
    }

    private String listAccount(BankAccount account) {
        return String.format("%s: %.2f\n", account, account.getAmount());
    }

    private String listFromCustomers(ArrayList<Customer> customers) {
        StringBuilder result = new StringBuilder();
        ArrayList<BankAccount> accounts;

        if (customers.size() == 0 ) {
            result.append("inga konton hittades.");
        } else {
            for (Customer cust: customers) {
                accounts = bank.findAccountsForHolder(cust.getIdNr());
                result.append(listAccounts(accounts));
            }
        }
        return result.toString();
    }

    private BankAccount getAccount(String prompt) {
        BankAccount account = null;
        int accountNr = ih.readInt(prompt);
        account = bank.findByNumber(accountNr);

        if (account == null) {
            throw new InputMismatchException("inget konto hittades.");
        }

        return account;
    }

    private double getPositiveAmount() {
        double amount;
        amount = ih.readDouble("belopp: ");

        if (amount < 0) {
            throw new InputMismatchException("du kan bara använda positiva belopp.");
        }

        return amount;
    }

    public Bank getBank() { return bank; }
}
