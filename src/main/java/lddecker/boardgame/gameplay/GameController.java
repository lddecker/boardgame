package lddecker.boardgame.gameplay;

import lddecker.boardgame.Parser.CommandParser;
import lddecker.boardgame.board.Board;
import lddecker.boardgame.board.FancyBoard;
import lddecker.boardgame.board.WordGame;

import javax.swing.*;
import java.io.PrintWriter;
import java.util.Scanner;

public class GameController {
    private Scanner _input;
    private PrintWriter _output;
    private WordGame _board;
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
                move.play((Board) _board);
                _keepPlaying = !move.gameIsOver();

                _output.println(move.getMoveDisplay());
                _output.flush();
            } catch (Exception e) {
                _output.println("Invalid: " + e.getMessage());
                _output.flush();
            }
        }
    }

    public void playFancyGame() {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                _board = new FancyBoard();

                JFrame frame = new JFrame();
                frame.add(((FancyBoard) _board).getGui());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationByPlatform(true);

                frame.pack();
                frame.setMinimumSize(frame.getSize());
                frame.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(runnable);
    }
}
