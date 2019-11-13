import se.lth.cs.pt.window.SimpleWindow;

public class LineDrawing {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(500, 500, "LineDrawing");
		while (true) {
		    w.waitForMouseClick();
			w.moveTo(w.getMouseX(), w.getMouseY());
		    w.waitForMouseClick();
		    w.lineTo(w.getMouseX(), w.getMouseY());
		}
	}
}
