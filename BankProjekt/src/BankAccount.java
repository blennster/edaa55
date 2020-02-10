
public class BankAccount {

    private static int counter = 1;
    private Customer holder;
    private double balance;
    private int accountNr;

    /**
     * Skapar ett nytt bankkonto åt en innehavare med namn ’holderName’ och
     * id ’holderId’. Kontot tilldelas ett unikt kontonummer och innehåller
     * inledningsvis 0 kr.
     */
    public BankAccount(String holderName, long holderId) {
        this.holder = new Customer(holderName, holderId);
        this.accountNr = counter++;
    }

    /**
     * Skapar ett nytt bankkonto med innehavare ’holder’. Kontot tilldelas
     * ett unikt kontonummer och innehåller inledningsvis 0 kr.
     */
    public BankAccount(Customer holder) {
        this.holder = holder;
        this.accountNr = counter++;
    }

    /**
     * Tar reda på kontots innehavare.
     */
    public Customer getHolder() {
        return holder;
    }

    /**
     * Tar reda på det kontonummer som identifierar detta konto.
     */
    public int getAccountNumber() {
        return accountNr;
    }

    /**
     * Tar reda på hur mycket pengar som finns på kontot.
     */
    public double getAmount() {
        return balance;
    }

    /**
     * Sätter in beloppet ’amount’ på kontot.
     */
    public void deposit(double amount) {
        this.balance += amount;
    }

    /**
     * Tar ut beloppet ’amount’ från kontot. Om kontot saknar täckning
     * blir saldot negativt.
     */
    public void withdraw(double amount) {
        this.balance -= amount;
    }

    /**
     * Returnerar en strängrepresentation av bankkontot.
     */
    public String toString() {
        return String.format("konto %d (%s)", accountNr, holder);
    }
}
