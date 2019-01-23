package snakegame.gui;

import snakegame.components.Direction;
import snakegame.components.Snake;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeListener implements KeyListener {
    private Snake snake;

    public SnakeListener(Snake snake) {
        this.snake = snake;
    }

    private boolean checkSnakeDirection(KeyEvent move) {
        if (move.getKeyCode() == KeyEvent.VK_DOWN &&
                snake.getDirection() == Direction.UP) {
            return true;
        }
        if (move.getKeyCode() == KeyEvent.VK_UP &&
                snake.getDirection() == Direction.DOWN) {
            return true;
        }
        if (move.getKeyCode() == KeyEvent.VK_LEFT &&
                snake.getDirection() == Direction.RIGHT) {
            return true;
        }
        if (move.getKeyCode() == KeyEvent.VK_RIGHT &&
                snake.getDirection() == Direction.LEFT) {
            return true;
        } else {
            return false;
        }

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (checkSnakeDirection(e)) {

            } else {
                snake.setDirection(Direction.UP);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (checkSnakeDirection(e)){

            } else {
                snake.setDirection(Direction.DOWN);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (checkSnakeDirection(e)) {

            } else {
                snake.setDirection(Direction.LEFT);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (checkSnakeDirection(e)){

            }else {
                snake.setDirection(Direction.RIGHT);
            }
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
