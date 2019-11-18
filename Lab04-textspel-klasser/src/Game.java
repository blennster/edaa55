import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Skriv in vilka multiplikationer du vill öva på.");
        System.out.print("Från: ");
        int from = scanner.nextInt();

        System.out.print("Till: ");
        int to = scanner.nextInt();

        MultTable table = new MultTable(from, to);

        System.out.println("Tryck enter när du är redo att starta tiden.");
        scanner.nextLine();
        scanner.nextLine(); // Eftersom nextInt inte tar in newline så behövs två stycken.
        Long startTime = System.currentTimeMillis();

        // Töm skärmen (finns nog andra sätt att göra det på)
        for (int i = 0; i < 32; i++) {
            System.out.println();
        }

        // Variabler inför spelloopen
        int input;
        boolean isCorrect = false;
        Expression currentExpression;

        while (table.hasNext()) {
            currentExpression = table.getRandom(false);
            System.out.print(currentExpression);

            do {
                if (scanner.hasNextInt()) {
                    input = scanner.nextInt();
                    isCorrect = currentExpression.checkAnswer(input);

                    if (!isCorrect) {
                        System.out.println("Försök igen!");
                        System.out.print(currentExpression);
                    }
                }
                else {
                    System.out.println("Svara bara med heltal!");
                    scanner.next(); // Säg till scanner att ny input kommer. Fastnar i loop annars.
                }
            } while (!isCorrect);
        }

        double duration = (System.currentTimeMillis() - startTime) / 1000d;
        System.out.printf("Bra jobbat! Det tog %.2f sekunder. Tryck enter för att avsluta", duration);
        scanner.nextLine();
        scanner.nextLine(); // Ännu en gång, nextInt fångar inte newlines som man tänker sig.
    }
}
