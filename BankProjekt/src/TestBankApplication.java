public class TestBankApplication {
    public static void main(String[] args) {
        InputTester it = new InputTester();
        BankApplication app = new BankApplication(it);
        String[] test;
        String result;

        // Test 1
        test = new String[]{
                "8"
        };
        it.setInputs(test);
        result = app.readInput();
        assertThatEquals("", result, "Test 1");

        // Test 2
        test = new String[]{
                "6",
                "Anna B",
                "1234",
                "8"
        };
        it.setInputs(test);
        result = app.readInput();
        assertThatEquals("konto skapat: 1", result, "Test 2 skapa");
        result = app.readInput();
        assertThatEquals("konto 1 (Anna B, id 1234, kundnr 1)\n", result, "Test 2.1 lista");


        // Test 3
        test = new String[]{
                "6",
                "Anna B",
                "5678",
                "8"
        };
        it.setInputs(test);
        result = app.readInput();
        assertThatEquals("konto skapat: 2", result, "Test 3 skapa");
        result = app.readInput();
        assertThatEquals(
                "konto 1 (Anna B, id 1234, kundnr 1)\n" +
                "konto 2 (Anna B, id 5678, kundnr 2)\n",
                result,
                "Test 3.1 lista"
        );

        // Test 4
        test = new String[]{
                "6",
                "Anna B",
                "5678",
                "8"
        };
        it.setInputs(test);
        result = app.readInput();
        assertThatEquals("konto skapat: 3", result, "Test 4 skapa");
        result = app.readInput();
        assertThatEquals(
                "konto 1 (Anna B, id 1234, kundnr 1)\n" +
                "konto 2 (Anna B, id 5678, kundnr 2)\n" +
                "konto 3 (Anna B, id 5678, kundnr 2)\n",
                result,
                "Test 4.1 lista"
        );
    }

    private static void assertThat(boolean condition, String test) {
        if (condition) {
            System.out.println(test + " passed!");
        } else {
            System.out.println(test + " failed!");
        }
    }

    private static void assertThatEquals(String expected, String actual, String test) {
        if (actual.equals(expected)) {
            System.out.println(test + " passed!");
        } else {
            System.out.println(test + " failed!\n");
            System.out.println("Expected: " + expected);
            System.out.println("Got: " + actual);
        }
    }
}
