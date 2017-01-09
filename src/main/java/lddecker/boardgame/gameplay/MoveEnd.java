package lddecker.boardgame.gameplay;

import lddecker.boardgame.board.WordGame;

public class MoveEnd extends Move {
    public MoveEnd() {
        super(CommandEnum.END);
    }

    @Override
    public void play(WordGame board) throws Exception {
        board.endGame();
    }

    @Override
    public boolean gameIsOver(WordGame board) {
        return true;
    }
}
