import java.util.ArrayList;

public class TurtleRace {
    public static void main(String[] args) {
        ArrayList<RaceTurtle> turtles = new ArrayList<RaceTurtle>();
        RaceWindow w = new RaceWindow();

        for (int i = 0; i < 8; i++) {
            turtles.add(new RaceTurtle(w, i+1));
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
