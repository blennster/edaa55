import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class ClickSquare {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "PrintClicks");
		Square sq = new Square(250, 250 ,100);
		int x;
		int y;
		sq.draw(w);

		while (true) {
			w.waitForMouseClick();
			x = w.getMouseX() - sq.getX();
			y = w.getMouseY() - sq.getY();
			sq.erase(w);
			sq.move(x, y);
			sq.draw(w);
		}
	}
}
