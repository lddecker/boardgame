package lddecker.boardgame.board;

public interface WordGame {
    int WIDTH = 15;
    int HEIGHT = 15;

    void playWord(String word, int column, int row, Direction direction) throws Exception;

    void resetBoard();

    int calculateScore();
}
