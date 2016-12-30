package lddecker.boardgame.board;

public abstract class WordGame {
    protected int WIDTH = 15;
    protected int HEIGHT = 15;
    protected AbstractCell[][] _board;

    public abstract void playWord(String word, int column, int row, Direction direction) throws Exception;

    protected void updateBoardForNewWord(String word, int column, int row, Direction direction) throws Exception {
        word = word.toUpperCase();
        for (char c : word.toCharArray()) {
            AbstractCell abstractCell = _board[row][column];
            try {
                abstractCell.update(c);
            } catch (Exception e) {
                throw e;
            }
            if (Direction.DOWN == direction) {
                row++;
            } else if (Direction.ACROSS == direction) {
                column++;
            } else {
                throw new Exception("Unknown direction: " + direction.name());
            }
        }
    }

    public abstract void resetBoard();

    public abstract int calculateScore();
}
