package touro.snake;

import java.util.Random;

/**
 * Factory class for creating new Food objects within the Garden.
 */
public class FoodFactory {

    /**
     * @return a new Food with random coordinates in the Garden
     */

    private final Random rand = new Random();

    public Food newInstance() {
        int randX = rand.nextInt(Garden.WIDTH);
        int randY = rand.nextInt(Garden.HEIGHT);
        return new Food(randX,randY);
    }

}
