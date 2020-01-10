import se.lth.cs.pt.window.SimpleWindow;

public class DizzyTurtle extends RaceTurtle {
    private int dizzines;

    public DizzyTurtle(SimpleWindow w, int nbr, int dizzines) {
        super(w, nbr);
        this.dizzines = dizzines;
    }

    @Override
    public void raceStep() {
        left(rnd.nextBoolean() ? dizzines : -dizzines);
        super.raceStep();
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" - DizzyTurtle (Yrsel: %d)", dizzines);
    }
}
