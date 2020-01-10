import se.lth.cs.pt.window.SimpleWindow;

import java.util.Random;

public class RaceTurtle extends Turtle {
    private int number;
    private int lastX, latestStep;
    protected Random rnd;

    /**
     * Gör en ny sköldpadda med ett startnummer och vriden åt höger.
     */
    public RaceTurtle(SimpleWindow w, int nbr) {
        super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
        left(270);
        number = nbr;
        rnd = new Random();
        penDown();
    }

    /**
     * Tar ett slumpmässigt steg mellan 1 och 6 framåt.
     */
    public void raceStep() {
        int randNbr = rnd.nextInt(6) + 1;
        lastX = getX();
        latestStep = randNbr;
        forward(randNbr);
    }

    /**
     * Ger en sträng på formen "Nummer X"
     */
    public String toString() {
        return "Nummer " + number;
    }

    public int getLastX() {
        return lastX;
    }

    public int getLatestStep() {
        return latestStep;
    }
}
