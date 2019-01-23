package snakegame;

import snakegame.gui.GameInterface;
import snakegame.logic.SnakeGame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SnakeGame game = new SnakeGame(20, 20);
        GameInterface ui = new GameInterface(game, 20);
        SwingUtilities.invokeLater(ui);
        while (ui.getDrawingBoard() == null) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException exception){
                System.out.println("Drawing board not found");
            }
        }
        game.setUpdatable(ui.getDrawingBoard());
        game.start();
    }


}
