package lddecker.boardgame.gameplay;

import lddecker.boardgame.board.Board;

public class MoveReset extends Move {
    public MoveReset() {
        super(CommandEnum.RESETBOARD);
    }

    @Override
    public void play(Board board) throws Exception {
        board.resetBoard();
        _moveDisplay = board.getBoardDisplay();
    }
}
