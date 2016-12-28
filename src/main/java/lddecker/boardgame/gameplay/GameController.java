package lddecker.boardgame.gameplay;

import lddecker.boardgame.Parser.CommandParser;
import lddecker.boardgame.board.Board;

import java.io.PrintWriter;
import java.util.Scanner;

public class GameController {
    private Scanner _input;
    private PrintWriter _output;
    private Board _board;
    private boolean _keepPlaying;

    public GameController(Scanner input, PrintWriter output) {
        _input = input;
        _output = output;
        _board = new Board();
        _keepPlaying = true;
    }

    public void playGame() {
        CommandParser parser = new CommandParser();
        while (_keepPlaying) {
            try {
                _output.print("command: ");
                _output.flush();

                Move move = parser.parseLine(_input.nextLine());
                move.play(_board);
                _keepPlaying = !move.gameIsOver();

                _output.println(move.getMoveDisplay());
                _output.flush();
            } catch (Exception e) {
                _output.println("Invalid: " + e.getMessage());
                _output.flush();
            }
        }

    }
}
