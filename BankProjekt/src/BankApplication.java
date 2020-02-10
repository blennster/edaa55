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
            readInput();
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

    public String readInput() {
        int input = ih.readInt("val: ");
        String result;
        switch (input) {
            case 1: result = handleFind(); break;
            case 6: result = handleCreate(); break;
            case 8: result = handlePrint(); break;
            default: result = "Vänligen välj ett giltligt alternativ.";
        }
        if (!isTesting) System.out.println(result);
        return result;
    }

    private String handleFind() {
        String query = ih.readLine("namn: ");
        return "";
    }

    public void handleFind(String query) {

    }

    private String handleCreate() {
        String name = ih.readLine("namn: ");
        int idNr = ih.readInt("id: ");
        return "konto skapat: " + createAccount(name, idNr);
    }

    private int createAccount(String name, int idNr) {
        return bank.addAccount(name, idNr);
    }

    private String handlePrint() {
        StringBuilder result = new StringBuilder();
        for (BankAccount acc: bank.getAllAccounts()) {
            result.append(acc).append("\n");
        }
        return result.toString();
    }

    public Bank getBank() { return bank; }
}
