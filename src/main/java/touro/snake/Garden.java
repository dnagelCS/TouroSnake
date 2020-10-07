package touro.snake;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.InputStream;

import static javax.swing.plaf.basic.BasicLookAndFeel.playSound;


/**
 * A model that contains the Snake and Food and is responsible for logic of moving the Snake,
 * seeing that food has been eaten and generating new food.
 */
public class Garden {

    public static final int WIDTH = 100;
    public static final int HEIGHT = 40;

    private final Snake snake;
    private final FoodFactory foodFactory;
    private final PoisonFactory poisonFactory;
    private Food food;
    private Poison poison;
    private Clip clip;
    private static final int MIN_SIZE = 2;

    public Garden(Snake snake, FoodFactory foodFactory, PoisonFactory poisonFactory, Clip clip) {
        this.snake = snake;
        this.foodFactory = foodFactory;
        this.poisonFactory = poisonFactory;
        this.clip = clip;
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }

    public Poison getPoison() {return poison; }

    /**
     * Moves the snake, checks to see if food has been eaten and creates food if necessary
     *
     * @return true if the snake is still alive, otherwise false.
     */
    public boolean advance() {
        if (moveSnake()) {
            moveFoodAndPoison();
            return true;
        }
        return false;
    }

    /**
     * Moves the Snake, eats the Food or collides with the wall (edges of the Garden), or eats self.
     *
     * @return true if the Snake is still alive, otherwise false.
     */
    boolean moveSnake() {
        snake.move();

        //if collides with wall, self, or poison at length 2
        if (!snake.inBounds() || snake.eatsSelf() || snake.getSquares().size() < MIN_SIZE) {
            return false;
        }

        //if collides with poison, shrink the snake
        if (snake.drinksPoison(poison) && snake.getSquares().size() >= MIN_SIZE) {
            snake.shrink();
            snake.getSquares().remove(snake.getSquares().size() - 2);
            poison = null;
        } else {
            snake.setShrink(false);
        }

        //if snake eats the food
        if (snake.getHead().equals(food)) {
            //add square to snake
            snake.grow();
            //make noise
            playSound();
            //remove food
            food = null;
            //remove previous poison
            poison = null;
        }
        return true;
    }

    /**
     * Creates or moves the Food and Poison respectively if Snake ate either one,
     * making sure neither are on a Square occupied by the Snake.
     */
    void moveFoodAndPoison() {
        //if snake ate food or poison, move them
        if (food == null || poison == null) {
            food = foodFactory.newInstance();
            poison = poisonFactory.newInstance();

            //if new food or poison on snake, put it somewhere else
            while (snake.contains(food, poison)) {
                food = foodFactory.newInstance();
                poison = poisonFactory.newInstance();
            }
        }
    }

    /**
     * Plays sound from .wav file found in resources folder
     */
    private void playSound() {
        try {
            clip.setMicrosecondPosition(0); //restart clip
            clip.start();

        } catch (Exception e) {
            System.out.println("Error found when trying to play EatNoise");
            e.printStackTrace();
        }
    }
}
