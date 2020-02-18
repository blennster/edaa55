import java.util.ArrayList;

public class Bank {

    private ArrayList<BankAccount> accounts = new ArrayList<>();

    /**
     * Öppna ett nytt konto i banken. Om det redan finns en kontoinnehavare
     * med de givna uppgifterna ska inte en ny Customer skapas, utan istället
     * den befintliga användas. Det nya kontonumret returneras.
     */
    public int addAccount(String holderName, long idNr) {
        Customer holder = findHolder(idNr);
        if (holder == null) {
            holder = new Customer(holderName, idNr);
        }
        if (!holder.getName().equals(holderName)) return -1; // Får bara finnas en kund med id nr och namn
        BankAccount account = new BankAccount(holder);
        accounts.add(account);
        return account.getAccountNumber();
    }

    /**
     * Returnerar den kontoinnehavaren som har det givna id-numret,
     * eller null om ingen sådan finns.
     */
    public Customer findHolder(long idNr) {
        for (BankAccount acc: accounts) {
            if (acc.getHolder().getIdNr() == idNr) {
                return acc.getHolder();
            }
        }
        return null;
    }

    /**
     * Tar bort konto med nummer ’number’ från banken. Returnerar true om
     * kontot fanns (och kunde tas bort), annars false.
     */
    public boolean removeAccount(int number) {
        BankAccount accountToRemove = null;
        for (BankAccount acc: accounts) {
            if (acc.getAccountNumber() == number) {
                accountToRemove = acc;
            }
        }
        accounts.remove(accountToRemove);
        return accountToRemove != null;
    }

    /**
     * Returnerar en lista innehållande samtliga bankkonton i banken.
     * Listan är sorterad på kontoinnehavarnas namn.
     */
    public ArrayList<BankAccount> getAllAccounts() {
        return accounts;
    }

    /**
     * Söker upp och returnerar bankkontot med kontonummer ’accountNumber’.
     * Returnerar null om inget sådant konto finns.
     */
    public BankAccount findByNumber(int accountNumber) {
        for (BankAccount acc: accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                return acc;
            }
        }
        return null;
    }

    /**
     * Söker upp alla bankkonton som innehas av kunden med id-nummer ’idNr’.
     * Kontona returneras i en lista. Kunderna antas ha unika id-nummer.
     */
    public ArrayList<BankAccount> findAccountsForHolder(long idNr) {
        ArrayList<BankAccount> accs = new ArrayList<>();
        for (BankAccount acc: accounts) {
            if (acc.getHolder().getIdNr() == idNr) {
                accs.add(acc);
            }
        }
        return accs;
    }

    /**
     * Söker upp kunder utifrån en sökning på namn eller del av namn. Alla
     * personer vars namn innehåller strängen ’namePart’ inkluderas i
     * resultatet, som returneras som en lista. Samma person kan förekomma
     * flera gånger i resultatet. Sökningen är "case insensitive", det vill
     * säga gör ingen skillnad på stora och små bokstäver.
     */
    public ArrayList<Customer> findByPartofName(String namePart) {
        ArrayList<Customer> customers = new ArrayList<>();
        String name;
        long id;
        ArrayList<Long> ids = new ArrayList<Long>();
        for (BankAccount acc: accounts) {
            name = acc.getHolder().getName();
            id = acc.getHolder().getIdNr();

            // Uppercase på båda gör case insensitive
            if (name.toUpperCase().contains(namePart.toUpperCase()) && !ids.contains(id)) {
                ids.add(id);
                customers.add(acc.getHolder());
            }
        }
        return customers;
    }
}
