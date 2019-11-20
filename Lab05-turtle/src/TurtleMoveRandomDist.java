import se.lth.cs.pt.window.SimpleWindow;

import java.util.Random;

public class TurtleMoveRandomDist {
    public static void main(String[] args) {
        SimpleWindow w = new SimpleWindow(600, 400, "Turtle");
        Turtle t1 = new Turtle(w, 250, 250);
        Turtle t2 = new Turtle(w, 350, 350);
        Random rnd = new Random();
        t1.penDown();
        t2.penDown();

        while (getDist(t1, t2) >= 50) {
            moveTurtle(t1, rnd);
            moveTurtle(t2, rnd);
            SimpleWindow.delay(10);
        }
    }

    public static void moveTurtle(Turtle t, Random rnd) {
        t.left(rnd.nextInt(360) - 180); // Ett slumpmässigt tal mellan -180 och 180
        t.forward(rnd.nextInt(9) + 1); // 1-10
    }

    public static int getDist(Turtle t1, Turtle t2) {
        double dx = Math.abs(t1.getX() - t2.getX());
        double dy = Math.abs(t1.getY() - t2.getY());

        dx *= dx;
        dy *= dy;

        double dist = Math.sqrt(dx + dy);

        return (int)Math.round(dist);
    }
}
