import se.lth.cs.pt.window.SimpleWindow;

import java.util.Random;

public class TurtleMoveRandom {
    public static void main(String[] args) {
        SimpleWindow w = new SimpleWindow(500, 300, "Turtle");
        Turtle t = new Turtle(w, 250, 150);
        Random rnd = new Random();
        t.penDown();

        for (int i = 0; i < 1000; i++) {
            t.moveRandomly();
        }
    }
}
