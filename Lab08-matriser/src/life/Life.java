package life;

public class Life {
    private LifeBoard board;
    private boolean[][] helperBoard;

    public Life (LifeBoard board) {
        this.board = board;
    }

    public void flip(int row, int col) {
        board.put(row, col, !board.get(row, col));
    }

    public void newGeneration() {
        int neighbours;
        helperBoard = new boolean[board.getRows()][board.getRows()];

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCols(); j++) {
                neighbours = getNeighbours(i, j);
                if (neighbours == 3) {
                    helperBoard[i][j] = true;
                }
                else if (neighbours == 2 && board.get(i, j)) {
                    helperBoard[i][j] = true;
                }
                else {
                    helperBoard[i][j] = false;
                }
            }
        }

        applyBoard();
        board.increaseGeneration();
    }

    /**
     * Kopiera hjälpbrädan till den riktiga
     */
    private void applyBoard() {
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCols(); j++) {
                board.put(i, j, helperBoard[i][j]);
            }
        }
    }

    /**
     * Kontrollerar hur många individer det finns runtom en cell
     */
    private int getNeighbours(int row, int col) {
        int n = 0;
        if (row - 1 >= 0) {
            if (col - 1 >= 0) {
                n += board.get(row - 1, col - 1) ? 1 : 0;
            }
            n += board.get(row - 1, col - 0) ? 1 : 0;
            if (col + 1 < board.getCols()) {
                n += board.get(row - 1, col + 1) ? 1 : 0;
            }
        }

        if (col - 1 >= 0) {
            n += board.get(row, col - 1) ? 1 : 0;
        }
        if (col + 1 < board.getCols()) {
            n += board.get(row, col + 1) ? 1 : 0;
        }

        if (row + 1 < board.getRows()) {
            if (col - 1 >= 0) {
                n += board.get(row + 1, col - 1) ? 1 : 0;
            }
            n += board.get(row + 1, col - 0) ? 1 : 0;
            if (col + 1 < board.getCols()) {
                n += board.get(row + 1, col + 1) ? 1 : 0;
            }
        }
        return n;
    }
}
