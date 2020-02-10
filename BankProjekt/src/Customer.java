
public class Customer {
    private static int counter = 0;

    private String name;
    private long idNr;
    private int customerNr;

    /**
     * Skapar en kund (kontoinnehavare) med namnet ’name’ och id-nummer ’idNr’.
     * Kunden tilldelas också ett unikt kundnummer.
     */
    public Customer(String name, long idNr) {
        this.name = name;
        this.idNr = idNr;
        this.customerNr = counter++;
    }

    /**
     * Tar reda på kundens namn.
     */
    public String getName() {
        return name;
    }

    /**
     * Tar reda på kundens personnummer.
     */
    public long getIdNr() {
        return idNr;
    }

    /**
     * Tar reda på kundens kundnummer.
     */
    public int getCustomerNr() {
        return customerNr;
    }

    /**
     * Returnerar en strängbeskrivning av kunden.
     */
    public String toString() {
        return String.format("%s, id %d, kundnr %d", name, idNr, customerNr);
    }
}
