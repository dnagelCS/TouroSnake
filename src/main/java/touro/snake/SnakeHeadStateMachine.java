package touro.snake;

import static touro.snake.Direction.*;
import static touro.snake.Direction.West;

/**
 * State machine that controls the turning the direction of the Snake head.
 * https://en.wikipedia.org/wiki/State_pattern
 */
public class SnakeHeadStateMachine {

    private Direction direction;

    public SnakeHeadStateMachine(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    /**
     * Turns the Snake in the newDirection if that is legal. If the Snake is currently facing
     * East or West then it can only turn North or South. If the Snake is currently facing North
     * or South then it can only turn East or West.
     * @param newDirection
     */
    public void turnTo(Direction newDirection) {
        // Agishtein
        throw new UnsupportedOperationException("Not Implemented Yet.");
    }

}
