package lddecker.boardgame.gameplay;

import lddecker.boardgame.Parser.CommandParser;
import lddecker.boardgame.board.impl.FancyBoard;
import lddecker.boardgame.board.WordGame;

import javax.swing.*;
import java.awt.event.*;
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
        _board = new FancyBoard();
        _keepPlaying = true;
    }

    public void playGame() {
        CommandParser parser = new CommandParser();
        while (_keepPlaying) {
            try {
                _output.print("command: ");
                _output.flush();

                Move move = parser.parseLine(_input.nextLine());
                move.play( _board);
                _keepPlaying = !_board.isGameOver();

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

                JFrame frame = new JFrame();
                frame.add(((FancyBoard) _board).getGui());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationByPlatform(true);

                frame.pack();
                frame.setMinimumSize(frame.getSize());
                frame.setVisible(true);
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent windowEvent) {
                        _board.endGame();
                    }
                });
            }
        };
        SwingUtilities.invokeLater(runnable);
        playGame();
    }
}
