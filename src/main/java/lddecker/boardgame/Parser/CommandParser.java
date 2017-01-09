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
            String s = split[3];
            int column = Character.toUpperCase(s.charAt(0)) - 'A';
            Integer row = Integer.valueOf(s.substring(1));
            move = new MoveWord(split[2], Direction.valueOf(split[1].toUpperCase()), column, row);
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
