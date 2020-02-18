import java.util.Scanner;
import java.util.Stack;

public class InputTester extends InputHelper {

    /**
     * En förlänging av inputhelper klassen som kan användas i testningsyfte.
     * @param inputs
     */
    public InputTester(String[] inputs) {
        super(null);
        setInputs(inputs);
    }

    public InputTester(Scanner mockupScan) {
        super(mockupScan);
    }

    protected void displayPrompt(String prompt) {
        // Gör inget
    }

    /**
     * Tar emot en lista och applicerar den på input stack i omvänd ordning.
     * @param inputs
     */
    public void setInputs(String[] inputs) {
        StringBuilder strB = new StringBuilder();
        for (String str : inputs) {
            strB.append(str).append("\n");
        }
        setScan(new Scanner(strB.toString()));
    }
}
