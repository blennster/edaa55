import se.lth.cs.pt.window.SimpleWindow;

public class AbsentMindedTurtle extends RaceTurtle {
    private int absence;

    public AbsentMindedTurtle(SimpleWindow w, int nbr, int absence) {
        super(w, nbr);
        this.absence = absence;
    }

    @Override
    public void raceStep() {
        if (rnd.nextInt(100) + 1 > absence) {
            super.raceStep();
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(" - AbsentMindedTurtle (%d%% frånvarande)", absence);
    }
}
