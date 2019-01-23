package snakegame.logic;

import snakegame.components.Apple;
import snakegame.components.Direction;
import snakegame.components.Piece;
import snakegame.components.Snake;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SnakeGame extends Timer implements ActionListener {
    private int width;
    private int height;
    private boolean continues;

    private Snake snake;
    private Apple apple;
    private Random randomizer;
    private Updatable updatable;

    public SnakeGame(int width, int height) {
        super(1000,null);
        addActionListener(this);

        this.width = width;
        this.height = height;
        this.continues = true;

        this.randomizer = new Random();
        this.snake = new Snake(width/2, height/2, Direction.DOWN);
        this.apple = new Apple(randomizer.nextInt(width), randomizer.nextInt(height));

    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setUpdatable (Updatable updatable){
        this.updatable = updatable;
    }

    private void appleSpawn (){
        int x = randomizer.nextInt(width);
        int y = randomizer.nextInt(height);
        boolean pieceDetector = false;

        for (Piece piece : snake.getSnakePieces()){
            if (piece.getX() == x && piece.getY() == y){
                pieceDetector = true;
            }
        }

        if (!pieceDetector){
            apple = new Apple(x,y);
        } else {
            appleSpawn();
        }
    }

    public void actionPerformed(ActionEvent e) {
        snake.move();
        if (snake.runsInto(apple)){
            apple = null;
            snake.grow();
            appleSpawn();
        }
        if (snake.runsIntoItself()){
            continues = false;
        }
        updatable.update();
        super.setDelay(500/snake.getSnakeLength());
    }
}
