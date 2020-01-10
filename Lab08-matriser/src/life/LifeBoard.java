package life;

public class LifeBoard {

    private int rows, cols;
	private boolean[][] board;
	private int generation;

	/** Skapar en spelplan med rows rader och cols kolonner.
	    Spelplanen är från början tom, dvs alla rutorna är
	    tomma och generationsräknaren är 1. */	
	public LifeBoard(int rows, int cols) {
		this.board = new boolean[rows][cols];
		this.rows = rows;
		this.cols = cols;
		generation = 1;
	}

	/** Undersöker om det finns en individ i rutan med index row,col, 
	    Om index row,col hamnar utanför spelplanen returneras false. */
	public boolean get(int row, int col) {
		return row < rows && row >= 0 &&
				col < cols && col >= 0 ? board[row][col] : false;
	}

	/** Lagrar värdet val i rutan med index row,col. */
	public void put(int row, int col, boolean val) {
		board[row][col] = val;
	}

	/** Tar reda på antalet rader. */
	public int getRows() {
		return rows;
	}

 	/** Tar reda på antalet kolonner. */
	public int getCols() {
		return cols;
	}

	/** Tar reda på aktuellt generationsnummer. */
	public int getGeneration() {
		return generation;
	}

	/** Ökar generationsnumret med ett. */
	public void increaseGeneration() {
		generation += 1;
	}
}
