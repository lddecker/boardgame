package lddecker.boardgame;

import lddecker.boardgame.gameplay.GameController;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController(new Scanner(System.in), new PrintWriter(System.out));
        gameController.playGame();

    }
}
