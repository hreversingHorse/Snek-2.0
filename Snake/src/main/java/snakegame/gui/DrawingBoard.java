package snakegame.gui;

import snakegame.components.Apple;
import snakegame.components.Piece;
import snakegame.logic.SnakeGame;
import snakegame.logic.Updatable;

import javax.swing.*;
import java.awt.*;

public class DrawingBoard extends JPanel implements Updatable {
    private SnakeGame snakeGame;
    private int pieceLength;

    public DrawingBoard(SnakeGame snakeGame, int pieceLength){
        this.snakeGame = snakeGame;
        this.pieceLength = pieceLength;
    }

    public void update() {
        super.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        for (Piece snakePiece : snakeGame.getSnake().getSnakePieces()){
            g.fill3DRect(snakePiece.getX()*pieceLength,
                    snakePiece.getY()*pieceLength, pieceLength,
                    pieceLength,true);
        }
        g.setColor(Color.red);
        Apple apple = snakeGame.getApple();
        g.fillOval(apple.getX()*pieceLength,apple.getY()*pieceLength,
                pieceLength,pieceLength);
    }
}
