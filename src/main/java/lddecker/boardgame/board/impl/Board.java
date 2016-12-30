package lddecker.boardgame.board.impl;

import lddecker.boardgame.board.AbstractCell;
import lddecker.boardgame.board.Direction;
import lddecker.boardgame.board.WordGame;

public class Board extends WordGame {

    public Board() {
        _board = new AbstractCell[HEIGHT][WIDTH];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                _board[i][j] = new TextCell();
            }
        }
    }

    public String getBoardDisplay() {
        String displayString = "";
        for (AbstractCell[] rows : _board) {
            for (AbstractCell col : rows) {
                displayString += col.getDisplayChar();
            }
            displayString += "\n";
        }
        return displayString;
    }

    @Override
    public void playWord(String word, int column, int row, Direction direction) throws Exception {
        updateBoardForNewWord(word, column, row, direction);
    }

    @Override
    public void resetBoard() {
        initializeBoard();
    }

    @Override
    public int calculateScore() {
        int score = 0;
        for (AbstractCell[] rows : _board) {
            for (AbstractCell col : rows) {
                score += col.getScore();
            }
        }
        return score;
    }
}
