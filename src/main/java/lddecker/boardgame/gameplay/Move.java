package lddecker.boardgame.gameplay;

import lddecker.boardgame.board.Board;

public abstract class Move {
    private CommandEnum _commandEnum;

    public String getMoveDisplay() {
        return _moveDisplay;
    }

    String _moveDisplay;

    Move(CommandEnum commandEnum) {
        _commandEnum = commandEnum;
        _moveDisplay = "";
    }

    public CommandEnum getCommand() {
        return _commandEnum;
    }

    public boolean gameIsOver() {
        return false;
    }

    abstract public void play(Board board) throws Exception;
}
