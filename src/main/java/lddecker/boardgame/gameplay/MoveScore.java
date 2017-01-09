package lddecker.boardgame.gameplay;

import lddecker.boardgame.board.WordGame;
import lddecker.boardgame.board.impl.Board;

public class MoveScore extends Move {
    public MoveScore() {
        super(CommandEnum.GETSCORE);
    }

    @Override
    public void play(WordGame board) throws Exception {
        _moveDisplay = Integer.valueOf(board.calculateScore()).toString();
    }
}
