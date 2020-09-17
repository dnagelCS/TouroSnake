package touro.snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * KeyListener that is responsible for turning the Snake.
 */
public class SnakeKeyListener extends KeyAdapter {

    private final Snake snake;

    public SnakeKeyListener(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                snake.turnTo(Direction.West);
                break;
            case KeyEvent.VK_RIGHT:
                snake.turnTo(Direction.East);
                break;
            case KeyEvent.VK_DOWN:
                snake.turnTo(Direction.South);
                break;
            case KeyEvent.VK_UP:
                snake.turnTo(Direction.North);
                break;
        }
    }
}
