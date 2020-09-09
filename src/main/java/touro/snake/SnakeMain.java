package touro.snake;

import java.awt.*;

public class SnakeMain {

    public static void main(String[] args) {

        // Set up all class dependencies here.
        // Gottlieb

        GardenView gardenView = null;
        Garden garden = null;
        SnakeKeyListener snakeKeyListener = null;

        GardenThread thread = new GardenThread(garden, gardenView);
        thread.start();

        new SnakeFrame(gardenView, snakeKeyListener).setVisible(true);
    }

}
