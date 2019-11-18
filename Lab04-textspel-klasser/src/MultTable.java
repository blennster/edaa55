import java.util.ArrayList;
import java.util.Random;

/**
 * Multiplikationstabell. Kommer konstruera en multiplikationstabell med alla möjliga heltalsmultiplikationer i
 * i det slutna intervallet [from, to]
 */
public class MultTable {
    private ArrayList<Expression> table;

    public MultTable(int from, int to) {
        table = new ArrayList<>();

        for (int i = from; i <= to; i++) {
            for (int j = from; j <= to; j++) {
                table.add(new Expression(i, j, '*'));
            }
        }
    }

    /**
     * Ta en slumpmässig multiplikation från tabellen. Multiplikationen kommer tas bort från tabellen och inte
     * parametern "preserve" är sann.
     * @return En slumpmässig multiplikation.
     */
    public Expression getRandom(boolean preserve) {
        Random rnd = new Random();
        int rndNbr = rnd.nextInt(table.size());

        if (preserve) {
            return table.get(rndNbr);
        }
        else {
            return table.remove(rndNbr);
        }
    }

    /**
     * Kollar om det finns fler multiplikationer kvar i tablellen.
     * @return Sant om det finns multiplikationer kvar.
     */
    public boolean hasNext() {
        return table.size() > 0;
    }
}
