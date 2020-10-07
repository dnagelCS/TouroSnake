package touro.snake;

import org.junit.Test;

import javax.sound.sampled.Clip;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GardenTest {

    @Test
    public void moveSnake() {
        /*
        Tests that snake moves and that when snake's move does not result
        in death.
         */
        //given
        Snake snake = mock(Snake.class);
        FoodFactory foodFactory = mock(FoodFactory.class);
        PoisonFactory poisonFactory = mock(PoisonFactory.class);
        Clip clip = mock(Clip.class);
        Garden garden = new Garden(snake, foodFactory, poisonFactory, clip);

        doReturn(true).when(snake).inBounds();
        doReturn(false).when(snake).eatsSelf();

        Square square = mock(Square.class);
        doReturn(square).when(snake).getHead();

        List<Square> squares = snake.getSquares();
        for (int i = 0; i < 10; i++) {
            squares.add(square);
        }
        when(snake.getSquares()).thenReturn(squares);

        //when and then
        assertTrue(garden.moveSnake());
    }

    @Test
    public void moveFoodAndPoison() {

        //given
        Snake snake = mock(Snake.class);
        FoodFactory foodFactory = mock(FoodFactory.class);
        Clip clip = mock(Clip.class);
        PoisonFactory poisonFactory = mock(PoisonFactory.class);
        Garden garden = new Garden(snake, foodFactory, poisonFactory, clip);
        when(foodFactory.newInstance()).thenReturn(mock(Food.class));
        when(poisonFactory.newInstance()).thenReturn(mock(Poison.class));

        //when
        garden.moveFoodAndPoison();

        //then
        verify(foodFactory).newInstance();
        verify(poisonFactory).newInstance();
        assertNotNull(garden.getFood());
        assertNotNull(garden.getPoison());
    }

    @Test
    public void playSound() {
        //given
        Snake snake = mock(Snake.class);
        FoodFactory foodFactory = mock(FoodFactory.class);
        PoisonFactory poisonFactory = mock(PoisonFactory.class);
        Food food = new Food(50, 20);
        when(foodFactory.newInstance()).thenReturn(food);
        Clip clip = mock(Clip.class);
        Garden garden = new Garden(snake, foodFactory, poisonFactory, clip);
        List<Square> squares = List.of(new Square(50, 20));

        when(snake.inBounds()).thenReturn(true);
        when(snake.eatsSelf()).thenReturn(false);
        when(snake.getHead()).thenReturn(squares.get(0));

        //when
        garden.moveFoodAndPoison();
        garden.moveSnake();

        //then
        verify(clip).start();
    }
}