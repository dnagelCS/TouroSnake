package touro.snake;

import java.util.Random;

/**
 * Factory class for creating new Poison objects within the Garden.
 */
public class PoisonFactory {

    /**
     * @return a new Poison with random coordinates in the Garden
     */

    private final Random rand = new Random();

    public Poison newInstance() {
        int randX = rand.nextInt(Garden.WIDTH);
        int randY = rand.nextInt(Garden.HEIGHT);
        return new Poison(randX,randY);
    }

}
