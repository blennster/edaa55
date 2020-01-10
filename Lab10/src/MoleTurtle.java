import se.lth.cs.pt.window.SimpleWindow;

public class MoleTurtle extends RaceTurtle {
    /**
     * Gör en ny sköldpadda med ett startnummer och vriden åt höger.
     */
    public MoleTurtle(SimpleWindow w, int nbr) {
        super(w, nbr);
    }

    @Override
    public void raceStep() {
        super.raceStep();

        if (rnd.nextBoolean()) {
            penUp();
        } else {
            penDown();
        }
    }

    @Override
    public String toString() {
        return super.toString() + " - MoleTurtle";
    }
}
