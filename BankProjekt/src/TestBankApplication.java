import java.util.ArrayList;

public class TestBankApplication {
    public static void main(String[] args) {
        String[] test = {"8"};
        InputTester it = new InputTester(test);

        BankApplication app = new BankApplication(it);
        String result = app.handleInput();
        assertThat(result.equals(""), "Test 1");

        test = new String[]{
                "6",
                "Anna B",
                "1234",
                "8"
        };
        it.setInputs(test);
        result = app.handleInput();
        assertThat(result.equals("konto skapat: 0"), "Test 2 skapa");
        result = app.handleInput();
        assertThat(result.equals("Konto 0 (Anna B, id 1234, kundnr 0)\n"), "Test 2.1 lista");
    }

    private static void assertThat(boolean condition, String test) {
        if (condition) {
            System.out.println(test + " passed!");
        } else {
            System.out.println(test + " failed!");
        }
    }
}
