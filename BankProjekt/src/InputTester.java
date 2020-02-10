import java.util.Stack;

public class InputTester extends InputHelper {
    Stack<String> inputStack = new Stack<>();

    /**
     * En förlänging av inputhelper klassen som kan användas i testningsyfte.
     * @param inputs
     */
    public InputTester(String[] inputs) {
        super(null); // Kan ge null error vilket är bra för scanner ska inte användas
        setInputs(inputs);
    }

    public InputTester() {
        super(null); // Kan ge null error vilket är bra för scanner ska inte användas
    }

    /**
     * Ger tillbacka en int från den raden som förväntas i input
     */
    @Override
    public int readInt(String prompt) {
        return Integer.parseInt(inputStack.pop());
    }

    @Override
    public String readLine(String prompt) {
        return inputStack.pop();
    }

    public void setInputs(String[] inputs) {
        this.inputStack.clear();
        for (int i = inputs.length; i > 0; i--) {
            this.inputStack.push(inputs[i - 1]);
        }
    }
}
