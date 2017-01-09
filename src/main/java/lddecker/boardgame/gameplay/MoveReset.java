package lddecker.boardgame.gameplay;

import lddecker.boardgame.board.WordGame;
import lddecker.boardgame.board.impl.Board;

public class MoveReset extends Move {
    public MoveReset() {
        super(CommandEnum.RESETBOARD);
    }

    @Override
    public void play(WordGame board) throws Exception {
        board.resetBoard();
        if (board instanceof Board) {
            _moveDisplay = ((Board) board).getBoardDisplay();
        }
    }
}
