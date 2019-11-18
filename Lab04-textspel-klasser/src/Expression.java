/**
 * Den här klassen representerar ett mattematiskt uttryck. Stöder två termer och additon, subtraktion,
 * multiplikation och divison. VIKTIGT! Svaret är ett heltal!
 * */
public class Expression {
    private int term1;
    private int term2;
    private char operation;
    private boolean hasCalculated; // Cache valideringsvariabel
    private int cachedAnswer;

    public Expression(int t1, int t2, char opr) {
        term1 = t1;
        term2 = t2;
        setOperation(opr);
    }

    public void setTerm1(int t1) {
        term1 = t1;
        hasCalculated = false;
    }

    public int getTerm1() {
        return term1;
    }

    public void setTerm2(int t2) {
        term2 = t2;
        hasCalculated = false;
    }

    public int getTerm2() {
        return term2;
    }

    /**
     * Sätter vilken typ av operation som ska genomföras. Kommer returnera IllegalArgumentException ifall operationen
     * inte stöds.
     * @param operation char av operationen
     */
    public void setOperation(char operation) {
        if ("/*+-".contains("" + operation)) {
            this.operation = operation;
            hasCalculated = false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public char getOperation() {
        return operation;
    }

    /**
     * Beräknar uttrycket och sparar det så att det inte behöver beräknas i onödan. Gör ingen skillnad för såhär
     * enkel aritmetik. Bör användas så man ska någon extern resurs eftersom man ofta väntar på IO.
     * @return Heltalssvaret på uttrycket
     */
    public int calculate() {
        if (!hasCalculated) {
            switch (operation) {
                case '*': cachedAnswer = term1 * term2; break;
                case '/': cachedAnswer = term1 / term2; break;
                case '-': cachedAnswer = term1 - term2; break;
                case '+': cachedAnswer = term1 + term2; break;
            }
            hasCalculated = true;
        }
        return cachedAnswer;
    }

    @Override
    public String toString() {
        calculate();
        return String.format("%d %c %d = ", term1, operation, term2);
    }

    /**
     * Kollar om något tal är samma som uttryckets svar.
     * @param answer En gissning
     * @return Sant om det är rätt svar.
     */
    public boolean checkAnswer(int answer) {
        calculate();
        return answer == cachedAnswer;
    }
}
