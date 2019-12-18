import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;


public class MazeWalker {
    private Turtle turtle;

    public MazeWalker (Turtle turtle) {
        this.turtle = turtle;
    }

    public void walk(Maze maze) {
        turtle.jumpTo(maze.getXEntry(), maze.getYEntry());
        turtle.penDown();
        boolean isWallInFront = false;
        boolean isWallLeft = false;
        while (!maze.atExit(turtle.getX(), turtle.getY())) {
            isWallInFront = maze.wallInFront(turtle.getDirection(), turtle.getX(), turtle.getY());
            if (isWallInFront) {
                turtle.left(90 * 3);
                isWallInFront = maze.wallInFront(turtle.getDirection(), turtle.getX(), turtle.getY());
                if (isWallInFront) {
                    turtle.left(90 * 3);
                }
            }

            isWallLeft = maze.wallAtLeft(turtle.getDirection(), turtle.getX(), turtle.getY());
            if (!isWallLeft) {
                turtle.left(90);
            }
            SimpleWindow.delay(1);
            turtle.forward(1);
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            SimpleWindow w = new SimpleWindow(400, 400, "Maze number: " + i);
            Turtle t = new Turtle(w, 0, 0);
            MazeWalker mw = new MazeWalker(t);
            Maze m = new Maze(i);
            m.draw(w);
            mw.walk(m);
        }
    }
}

