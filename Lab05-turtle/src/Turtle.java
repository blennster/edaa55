import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {

	private SimpleWindow w;
	private int x, y;
	private float pX, pY; // Precisions variabler
	int beta = 90;
	boolean penIsDown = false;
	private float RESOLUTION = 2;

	/** Skapar en sköldpadda som ritar i ritfönstret w. Från början 
	    befinner sig sköldpaddan i punkten x, y med pennan lyft och 
	    huvudet pekande rakt uppåt i fönstret (i negativ y-riktning). */
	public Turtle(SimpleWindow w, int x, int y) {
		this.w = w;
		this.x = x;
		this.y = y;
		this.pX = x;
		this.pY = y;
	}

	/** Sänker pennan. */
	public void penDown() {
		penIsDown = true;
	}
	
	/** Lyfter pennan. */
	public void penUp() {
		penIsDown = false;
	}
	
	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {
		int newX = x, newY = y;

		for (int i = 0; i < n; i++) {
			pX += Math.cos(Math.toRadians(beta));
			pY -= Math.sin(Math.toRadians(beta));

			newX = Math.round(pX);
			newY = Math.round(pY);

			if (penIsDown) {
				w.moveTo(x, y);
				w.lineTo(newX, newY);
			}
			x = newX;
			y = newY;
		}

		x = newX;
		y = newY;
	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {
		this.beta += beta;
	}

	/** Går till punkten newX, newY utan att rita. Pennans läge (sänkt
	    eller lyft) och huvudets riktning påverkas inte. */
	public void jumpTo(int newX, int newY) {
		x = newX;
		y = newY;
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		beta = 90;
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return x;
	}

 	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return y;
	}
  
	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
 	public int getDirection() {
 		return beta;
	}
}
