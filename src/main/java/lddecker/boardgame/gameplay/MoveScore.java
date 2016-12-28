package lddecker.boardgame.gameplay;

import lddecker.boardgame.board.Board;

public class MoveScore extends Move {
    public MoveScore() {
        super(CommandEnum.GETSCORE);
    }

    @Override
    public void play(Board board) throws Exception {
        _moveDisplay = Integer.valueOf(board.calculateScore()).toString();
    }
}
