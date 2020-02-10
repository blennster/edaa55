import java.util.Scanner;

public class InputHelper {
    private Scanner scan;

    public InputHelper(Scanner scan) {
        this.scan = scan;
    }

    public String readLine(String prompt) {
        System.out.print(prompt);
        return scan.nextLine();
    }

    public int readInt(String prompt) {
        return readInt(prompt, "Skriv ett heltal");
    }

    public int readInt(String prompt, String errorMsg) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = scan.nextInt();
                scan.nextLine();
                return input;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
}
