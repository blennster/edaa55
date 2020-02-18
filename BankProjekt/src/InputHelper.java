import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    private Scanner scan;

    public InputHelper(Scanner scan) {
        this.scan = scan;
    }

    public void setScan(Scanner newScan) {
        if (newScan != null) {
            scan = newScan;
        }
    }

    public String readLine(String prompt) {
        displayPrompt(prompt);
        return scan.nextLine();
    }

    public double readDouble(String prompt) {
        return readDouble(prompt, "Skriv ett tal");
    }

    public double readDouble(String prompt, String errorMsg) {
        displayPrompt(prompt);
        try {
            double input = scan.nextDouble();
            scan.nextLine();
            return input;
        } catch (Exception e) {
            scan.nextLine(); // Fastnar i loop annars
            throw new InputMismatchException(errorMsg);
        }
    }

    public int readInt(String prompt) {
        return readInt(prompt, "Skriv ett heltal");
    }

    public int readInt(String prompt, String errorMsg) {
        displayPrompt(prompt);
        try {
            int input = scan.nextInt();
            scan.nextLine();
            return input;
        } catch (Exception e) {
            scan.nextLine(); // Fastnar i loop annars
            throw new InputMismatchException(errorMsg);
        }
    }

    protected void displayPrompt(String prompt) {
        System.out.print(prompt);
    }
}
