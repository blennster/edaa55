import se.lth.cs.pt.window.SimpleWindow;

import java.util.Random;

public class TurtleMoveRandomDistClassExt {
    public static void main(String[] args) {
        SimpleWindow w = new SimpleWindow(600, 400, "Turtle");
        Turtle t1 = new Turtle(w, 250, 250);
        Turtle t2 = new Turtle(w, 350, 350);
        Random rnd = new Random();
        t1.penDown();
        t2.penDown();

        while (t1.distTo(t2) >= 50) {
            t1.moveRandomly();
            t2.moveRandomly();
            SimpleWindow.delay(10);
        }
    }
}
