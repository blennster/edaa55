package life;

public class LifeController {
    public static void main(String[] args) {
        LifeBoard board = new LifeBoard(13,13);
        LifeView view = new LifeView(board);
        Life life = new Life(board);

        view.drawBoard();

        int row, col;
        while (true) {
            switch (view.getCommand()) {
                case 1: {
                    row = view.getRow();
                    col = view.getCol();
                    life.flip(row, col);
                    break;
                }
                case 2: life.newGeneration(); break;
                case 3: System.exit(0); break;
            }
            view.update();
        }
    }
}
