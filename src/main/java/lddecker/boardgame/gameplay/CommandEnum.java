package lddecker.boardgame.gameplay;

public enum CommandEnum {
    PLAYWORD("PLAYWORD [Direction] [word] [column|row]: Plays a word and displays the board"),
    GETSCORE("GETSCORE: Displays the score"),
    RESETBOARD("RESETBOARD: Clears all played words from the board"),
    HELP("HELP: Displays this help"),
    END("END: Ends the game");

    private String _helpCommand;

    CommandEnum(String helpCommand) {
        _helpCommand = helpCommand;
    }

    public String getHelpCommand() {
        return _helpCommand;
    }
}
