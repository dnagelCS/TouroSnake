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
        // Liebman
        throw new UnsupportedOperationException("Not Implemented Yet.");
    }
}
