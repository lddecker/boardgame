package lddecker.boardgame.gameplay;

import lddecker.boardgame.board.WordGame;

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

    public boolean gameIsOver(WordGame board) {
        return false;
    }

    abstract public void play(WordGame board) throws Exception;
}
