package lddecker.boardgame.board;

import java.util.Arrays;

public class Board {
    private static int WIDTH = 15;
    private static int HEIGHT = 15;

    private Cell[][] _board;

    public Board() {
        _board = new Cell[HEIGHT][WIDTH];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                _board[i][j] = new Cell();
            }
        }
    }

    private Cell[][] copyBoard() throws Exception {
        Cell[][] copy = new Cell[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                Cell cell = new Cell();
                Character displayChar = _board[i][j].getDisplayChar();
                if (Cell.isValidCharacter(displayChar)) {
                    cell.update(displayChar);
                }
                copy[i][j] = cell;
            }
        }
        return copy;
    }

    public String getBoardDisplay() {
        String displayString = "";
        for (Cell[] rows : _board) {
            for (Cell col : rows) {
                displayString += col.getDisplayChar();
            }
            displayString += "\n";
        }
        return displayString;
    }

    public void playWord(String word, int column, int row, Direction direction) throws Exception {
        word = word.toUpperCase();
        Cell[][] newBoard = copyBoard();
        for (char c : word.toCharArray()) {
            try {
                newBoard[row][column].update(c);
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
        _board = newBoard;

    }

    public void reset() {
        initializeBoard();
    }

    public int calculateScore() {
        int score = 0;
        for (Cell[] rows : _board) {
            for (Cell col : rows) {
                score += col.getScore();
            }
        }
        return score;
    }
}
