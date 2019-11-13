import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class ClickSquareAnimated {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "PrintSquaresAnimated");
		Square sq = new Square(250, 250 ,100);
		int x, y;
		int deltaX, deltaY;
		sq.draw(w);
		while (true) {
			w.waitForMouseClick();
			//sq = new Square(w.getMouseX() - 50, w.getMouseY() - 50, 100);
			x = w.getMouseX() - sq.getX();
			y = w.getMouseY() - sq.getY();
			deltaX = x / 10;
			deltaY = y / 10;
			for (int i = 0; i < 10; i++) {
			    SimpleWindow.delay(10);
				//sq.erase(w);
				sq.move(deltaX, deltaY);
				sq.draw(w);
			}
		}
	}
}
