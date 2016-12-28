package lddecker.boardgame.gameplay;

import lddecker.boardgame.board.Board;

public class MoveHelp extends Move {
    public MoveHelp() {
        super(CommandEnum.HELP);
    }

    @Override
    public void play(Board board) throws Exception {
        String helpString = "";
        for (CommandEnum commandEnum : CommandEnum.values()) {
            helpString += commandEnum.getHelpCommand() + "\n";
        }
        _moveDisplay = helpString;
    }
}
