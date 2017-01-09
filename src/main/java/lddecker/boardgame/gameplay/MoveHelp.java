package lddecker.boardgame.gameplay;

import lddecker.boardgame.board.WordGame;
import lddecker.boardgame.board.impl.Board;

public class MoveHelp extends Move {
    public MoveHelp() {
        super(CommandEnum.HELP);
    }

    @Override
    public void play(WordGame board) throws Exception {
        String helpString = "";
        for (CommandEnum commandEnum : CommandEnum.values()) {
            helpString += commandEnum.getHelpCommand() + "\n";
        }
        _moveDisplay = helpString;
    }
}
