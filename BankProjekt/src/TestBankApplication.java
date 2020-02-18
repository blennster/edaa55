import java.util.Scanner;

public class TestBankApplication {
    static int tests, passedTests;

    public static void main(String[] args) {
        InputTester it = new InputTester((Scanner)null); // Visa att vi vill använda konstruktorn med scanner som arg.
        BankApplication app = new BankApplication(it);

        String[] test;
        String result;

        // Test 1
        test = new String[]{
                "8"
        };
        it.setInputs(test);
        result = app.readInput();
        assertThatEquals("", result, "Test 1 lista med inget");

        // Test 2
        test = new String[]{
                "6",
                "Anna B",
                "1234",
                "8"
        };
        it.setInputs(test);
        result = app.readInput();
        assertThatEquals("konto skapat: 1", result, "Test 2 skapa konto");
        result = app.readInput();
        assertThatEquals("konto 1 (Anna B, id 1234, kundnr 1): 0,00\n",
                result,
               "Test 2.1 lista med ett konto"
        );


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
                "konto 1 (Anna B, id 1234, kundnr 1): 0,00\n" +
                        "konto 2 (Anna B, id 5678, kundnr 2): 0,00\n",
                result,
                "Test 3.1 lista fler konton"
        );

        // Test 4
        test = new String[]{
                "6",
                "Anna B",
                "5678",
                "8",
                "6",
                "Anna",
                "5678"
        };
        it.setInputs(test);
        result = app.readInput();
        assertThatEquals("konto skapat: 3", result, "Test 4 skapa konto med samma id");
        result = app.readInput();
        assertThatEquals(
                "konto 1 (Anna B, id 1234, kundnr 1): 0,00\n" +
                "konto 2 (Anna B, id 5678, kundnr 2): 0,00\n" +
                "konto 3 (Anna B, id 5678, kundnr 2): 0,00\n",
                result,
                "Test 4.1 lista fler konton med samma ägare"
        );
        result = app.readInput();
        assertThatEquals("kunde inte skapa konto, id och namn stämde ej överrens",
                result,
                "Test 4.2 skapa konto med fel namn och id"
        );


        // Test 5
        test = new String[]{
                "6",
                "Jesper Z",
                "1313",
                "6",
                "Anders A",
                "1212",
                "8"
        };
        it.setInputs(test);
        app.readInput(); // Lägg till Jesper
        app.readInput(); // Lägg till Anders
        result = app.readInput();
        assertThatEquals(
                "konto 5 (Anders A, id 1212, kundnr 4): 0,00\n" +
                        "konto 1 (Anna B, id 1234, kundnr 1): 0,00\n" +
                        "konto 2 (Anna B, id 5678, kundnr 2): 0,00\n" +
                        "konto 3 (Anna B, id 5678, kundnr 2): 0,00\n" +
                        "konto 4 (Jesper Z, id 1313, kundnr 3): 0,00\n",
                result,
                "Test 5 sorterad lista"
        );

        // Test 6
        test = new String[]{
                "2",
                "jesper",
        };
        it.setInputs(test);
        result = app.readInput();
        assertThatEquals(
                "konto 4 (Jesper Z, id 1313, kundnr 3): 0,00\n",
                result,
                "Test 6 sökning"
        );

        // Test 7
        test = new String[]{
                "2",
                "An",
        };
        it.setInputs(test);
        result = app.readInput();
        assertThatEquals(
                "konto 5 (Anders A, id 1212, kundnr 4): 0,00\n" +
                        "konto 1 (Anna B, id 1234, kundnr 1): 0,00\n" +
                        "konto 2 (Anna B, id 5678, kundnr 2): 0,00\n" +
                        "konto 3 (Anna B, id 5678, kundnr 2): 0,00\n",
                        result,
                "Test 7 sökning"
        );

        // Test 8
        test = new String[]{
                "2",
                "ders",
        };
        it.setInputs(test);
        result = app.readInput();
        assertThatEquals(
                "konto 5 (Anders A, id 1212, kundnr 4): 0,00\n",
                result,
                "Test 8 sökning"
        );

        // Test 9
        test = new String[]{
                // "8", Behövs inte eftersom den är redan testad
                "3",
                "4", // Jespers kontonr
                "500"
        };
        it.setInputs(test);
        result = app.readInput();
        assertThatEquals(
                "konto 4 (Jesper Z, id 1313, kundnr 3): 500,00\n",
                result,
                "Test 9 insättning"
        );

        // Test 10, svårtestad...
        test = new String[]{
                "3",
                "4", // Jespers kontonr
                "-1000",
                "2",
                "Jesper Z"
        };
        it.setInputs(test);
        result = app.readInput();
        assertThatEquals(
                "du kan bara använda positiva belopp.",
                result,
                "Test 10 insättning negativt belopp"
        );
        result = app.readInput();
        assertThatEquals(
                "konto 4 (Jesper Z, id 1313, kundnr 3): 500,00\n",
                result,
                "Test 10.1 saldo kontroll"
        );

        // Test 11
        test = new String[]{
                // "8", Behövs inte eftersom den är redan testad
                "3",
                "1", // Annas kontonr
                "5000",
                "2",
                "Anna B"
        };
        it.setInputs(test);
        result = app.readInput();
        assertThatEquals(
                "konto 1 (Anna B, id 1234, kundnr 1): 5000,00\n",
                result,
                "Test 11 insättning"
        );
        result = app.readInput();
        assertThatEquals(
                "konto 1 (Anna B, id 1234, kundnr 1): 5000,00\n" +
                        "konto 2 (Anna B, id 5678, kundnr 2): 0,00\n" +
                        "konto 3 (Anna B, id 5678, kundnr 2): 0,00\n",
                result,
                "Test 11.1 insättning lista"
        );

        // Test 12
        test = new String[]{
                // "8", Behövs inte eftersom den är redan testad
                "3",
                "69", // Konto som inte finns
                "500", // Programmet kommer inte be om detta
        };
        it.setInputs(test);
        result = app.readInput();
        assertThatEquals(
                "inget konto hittades.",
                result,
                "Test 12 insättning på konto som inte finns"
        );

        // Test 13
        test = new String[]{
                // "8", Behövs inte eftersom den är redan testad
                "4",
                "4", // Konto som inte finns
                "100", // Programmet kommer inte be om detta
        };
        it.setInputs(test);
        result = app.readInput();
        assertThatEquals(
                "konto 4 (Jesper Z, id 1313, kundnr 3): 400,00\n",
                result,
                "Test 13 uttag"
        );

        // Test 14
        test = new String[]{
                // "8", Behövs inte eftersom den är redan testad
                "4",
                "69", // Konto som inte finns
                "500", // Programmet kommer inte be om detta
        };
        it.setInputs(test);
        result = app.readInput();
        assertThatEquals(
                "inget konto hittades.",
                result,
                "Test 14 uttag på konto som inte finns"
        );

        // Test 15
        test = new String[]{
                // "8", Behövs inte eftersom den är redan testad
                "4",
                "5", // Anders konto
                "100", // Programmet kommer inte be om detta,
                "2",
                "Anders A"
        };
        it.setInputs(test);
        result = app.readInput();
        assertThatEquals(
                "uttaget misslyckades, endast 0,00 på kontot!",
                result,
                "Test 15 uttag utan täckning"
        );
        result = app.readInput();
        assertThatEquals(
                "konto 5 (Anders A, id 1212, kundnr 4): 0,00\n",
                result,
                "Test 15.1 kontroll saldo"
        );


        // Test 16
        test = new String[]{
                // "8", Behövs inte eftersom den är redan testad
                "5",
                "4", // Jespers konto
                "5", // Anders konto
                "200",
                "8"
        };
        it.setInputs(test);
        result = app.readInput();
        assertThatEquals(
                        "konto 4 (Jesper Z, id 1313, kundnr 3): 200,00\n" +
                                "konto 5 (Anders A, id 1212, kundnr 4): 200,00\n",
                result,
                "Test 16 överföring"
        );
        result = app.readInput();
        assertThatEquals(
                "konto 5 (Anders A, id 1212, kundnr 4): 200,00\n" +
                        "konto 1 (Anna B, id 1234, kundnr 1): 5000,00\n" +
                        "konto 2 (Anna B, id 5678, kundnr 2): 0,00\n" +
                        "konto 3 (Anna B, id 5678, kundnr 2): 0,00\n" +
                        "konto 4 (Jesper Z, id 1313, kundnr 3): 200,00\n",
                result,
                "Test 16.1 överföring"
        );

        // Test 17
        test = new String[]{
                // "8", Behövs inte eftersom den är redan testad
                "5",
                "4", // Jespers konto
                "5", // Anders konto
                "6000",
                "8"
        };
        it.setInputs(test);
        result = app.readInput();
        assertThatEquals(
                "överföringen misslyckades, endast 200,00 på kontot!",
                result,
                "Test 17 överföring utan teckning"
        );
        result = app.readInput();
        assertThatEquals(
                "konto 5 (Anders A, id 1212, kundnr 4): 200,00\n" +
                        "konto 1 (Anna B, id 1234, kundnr 1): 5000,00\n" +
                        "konto 2 (Anna B, id 5678, kundnr 2): 0,00\n" +
                        "konto 3 (Anna B, id 5678, kundnr 2): 0,00\n" +
                        "konto 4 (Jesper Z, id 1313, kundnr 3): 200,00\n",
                result,
                "Test 17.1 kontroll saldo"
        );

        // Test 18
        test = new String[]{
                // "8", Behövs inte eftersom den är redan testad
                "7",
                "4", // Jespers konto
                "8",
                "2",
                "jesper"
        };
        it.setInputs(test);
        result = app.readInput();
        assertThatEquals(
                "konto borttaget.",
                result,
                "Test 18 ta bort konto"
        );
        result = app.readInput();
        assertThatEquals(
                "konto 5 (Anders A, id 1212, kundnr 4): 200,00\n" +
                        "konto 1 (Anna B, id 1234, kundnr 1): 5000,00\n" +
                        "konto 2 (Anna B, id 5678, kundnr 2): 0,00\n" +
                        "konto 3 (Anna B, id 5678, kundnr 2): 0,00\n",
                result,
                "Test 18.1 kontroll konto borta"
        );
        result = app.readInput();
        assertThatEquals(
                        "inga konton hittades.",
                result,
                "Test 18.2 kontroll konto borta"
        );


        // Test 19
        test = new String[]{
                // "8", Behövs inte eftersom den är redan testad
                "7",
                "3", // Annas konto
                "8",
                "1",
                "5678"
        };
        it.setInputs(test);
        result = app.readInput();
        assertThatEquals(
                "konto borttaget.",
                result,
                "Test 19 ta bort konto"
        );
        result = app.readInput();
        assertThatEquals(
                "konto 5 (Anders A, id 1212, kundnr 4): 200,00\n" +
                        "konto 1 (Anna B, id 1234, kundnr 1): 5000,00\n" +
                        "konto 2 (Anna B, id 5678, kundnr 2): 0,00\n",
                result,
                "Test 19.1 kontroll konto borta"
        );
        result = app.readInput();
        assertThatEquals(
                "konto 2 (Anna B, id 5678, kundnr 2): 0,00\n",
                result,
                "Test 19.2 kontroll konto borta"
        );

        System.out.printf("\n%d av %d test klarades och programmet krashade ej.\n", passedTests, tests);

        // Test 20
        System.out.println("Test 20:");
        System.out.println("Testar att starta och stänga programmet...");
        test = new String[]{
                "9"
        };
        it.setInputs(test);
        app.runApplication();
    }

    private static void assertThat(boolean condition, String test) {
        if (condition) {
            System.out.println(test + " passed!");
        } else {
            System.out.println(test + " failed!");
        }
    }

    private static void assertThatEquals(String expected, String actual, String test) {
        tests++;
        if (actual.equals(expected)) {
            System.out.println(test + " godkänd!");
            passedTests++;
        } else {
            System.out.println(test + " misslyckad!\n");
            System.out.println("Förväntade: " + expected);
            System.out.println("Fick: " + actual);
        }
    }
}
