package touro.snake;

import javax.swing.*;
import java.awt.*;

public class GardenView extends JComponent {

    private final Garden garden;

    public GardenView(Garden garden) {
        this.garden = garden;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintGrass(g);
        paintFood(g);
        paintSnake(g);
    }

    void paintGrass(Graphics g) {
        // Berger
        throw new UnsupportedOperationException("Not Implemented Yet.");
    }

    void paintSnake(Graphics g) {
        // Orlian
        throw new UnsupportedOperationException("Not Implemented Yet.");
    }

    void paintFood(Graphics g) {
        // Berger
        throw new UnsupportedOperationException("Not Implemented Yet.");
    }
}
