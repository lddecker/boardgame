package lddecker.boardgame.gameplay;

import lddecker.boardgame.board.impl.Board;

public class MoveEnd extends Move {
    public MoveEnd() {
        super(CommandEnum.END);
    }

    @Override
    public void play(Board board) throws Exception {
    }

    @Override
    public boolean gameIsOver() {
        return true;
    }
}
