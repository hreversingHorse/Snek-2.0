package snakegame.gui;

import snakegame.logic.SnakeGame;

import javax.swing.*;
import java.awt.*;

public class GameInterface implements Runnable{
    private JFrame frame;
    private SnakeGame snakeGame;
    private DrawingBoard drawingBoard;
    private int pieceLength;

    public GameInterface(SnakeGame snakeGame, int pieceLength){
        this.snakeGame = snakeGame;
        this.pieceLength = pieceLength;
    }

    public void run() {
        this.frame = new JFrame("Snake");
        int width = (snakeGame.getWidth()+1)*pieceLength+10;
        int height = (snakeGame.getHeight()+2)*pieceLength+10;

        frame.setPreferredSize(new Dimension(width,height));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container){
        DrawingBoard drawingBoard = new DrawingBoard(snakeGame,pieceLength);
        this.drawingBoard = drawingBoard;
        container.add(drawingBoard);
        SnakeListener snakeListener = new SnakeListener(snakeGame.getSnake());
        frame.addKeyListener(snakeListener);
    }

    public DrawingBoard getDrawingBoard (){
        return drawingBoard;
    }

    public JFrame getFrame() {
        return frame;
    }
}
