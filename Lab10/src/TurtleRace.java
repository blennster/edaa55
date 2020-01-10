import java.util.ArrayList;
import java.util.Random;

public class TurtleRace {
    public static void main(String[] args) {
        ArrayList<RaceTurtle> turtles = new ArrayList<RaceTurtle>();
        RaceWindow w = new RaceWindow();
        Random rnd = new Random();

        for (int i = 1; i <= 8; i++) {
            RaceTurtle t = null; // För att inte få IDE fel
            switch (rnd.nextInt(3)) {
                case 0: t = new MoleTurtle(w, i); break;
                case 1: t = new DizzyTurtle(w, i, rnd.nextInt(5) + 1); break;
                case 2: t = new AbsentMindedTurtle(w, i, rnd.nextInt(100) + 1); break;
            }
            turtles.add(t);
        }

        int place = 1;
        ArrayList<RaceTurtle> finishedTurtles = new ArrayList<RaceTurtle>();
        while (turtles.size() > 0) {
            for (RaceTurtle turtle: turtles) {
                turtle.raceStep();
                if (turtle.getX() > RaceWindow.X_END_POS) {
                    finishedTurtles.add(turtle);
                    System.out.printf("På plats %d: %s \n", place++, turtle);
                }
            }
            turtles.removeAll(finishedTurtles);
            RaceWindow.delay(10);
        }
    }
}
