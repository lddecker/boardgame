package lddecker.boardgame.Parser;

import lddecker.boardgame.board.Direction;
import lddecker.boardgame.gameplay.*;

public class CommandParser {
    public CommandParser() {
    }

    public Move parseLine(String line) {
        String[] split = line.split(" ");
        Move move;
        CommandEnum commandEnum = CommandEnum.valueOf(split[0].toUpperCase());
        if (CommandEnum.PLAYWORD == commandEnum) {
            move = new MoveWord(split[2], Direction.valueOf(split[1].toUpperCase()), Integer.valueOf(split[3]), Integer.valueOf(split[4]));
        } else if (CommandEnum.END == commandEnum) {
            move = new MoveEnd();
        } else if (CommandEnum.HELP == commandEnum) {
            move = new MoveHelp();
        } else if (CommandEnum.RESETBOARD == commandEnum) {
            move = new MoveReset();
        } else if (CommandEnum.GETSCORE == commandEnum) {
            move = new MoveScore();
        } else {
            throw new RuntimeException("Move not yet implemented: " + commandEnum.name());
        }
        return move;
    }
}
