package lddecker.boardgame.gameplay;

import lddecker.boardgame.board.WordGame;
import lddecker.boardgame.board.impl.Board;
import lddecker.boardgame.board.Direction;

public class MoveWord extends Move {
    private String _word;
    private int _column;
    private int _row;
    private Direction _direction;

    public MoveWord(String word, Direction direction, int column, int row) {
        super(CommandEnum.PLAYWORD);
        _word = word;
        _direction = direction;
        _column = column;
        _row = row;
    }

    @Override
    public void play(WordGame board) {
        try {
            board.playWord(_word, _column, _row, _direction);
            if (board instanceof Board) {
                _moveDisplay = ((Board) board).getBoardDisplay();
            }
        } catch (Exception e) {
            if (board instanceof Board) {
                _moveDisplay = e.getMessage() + "\n" + ((Board) board).getBoardDisplay();
            }
        }
    }
}
