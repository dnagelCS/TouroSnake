package touro.snake;

import org.junit.Test;

import static org.junit.Assert.*;

public class SnakeHeadStateMachineTest {

    @Test
    public void turnTo_eastToSouth() {
        //given
        Direction direction = Direction.East;
        Direction newDirection = Direction.South;
        SnakeHeadStateMachine machine = new SnakeHeadStateMachine(direction);

        //when
        machine.turnTo(newDirection);

        //then
        Direction result = machine.getDirection();
        assertEquals(Direction.South, result);
    }

    @Test
    public void turnTo_eastToNorth() {
        //given
        Direction direction = Direction.East;
        Direction newDirection = Direction.North;
        SnakeHeadStateMachine machine = new SnakeHeadStateMachine(direction);

        //when
        machine.turnTo(newDirection);

        //then
        Direction result = machine.getDirection();
        assertEquals(Direction.North, result);
    }

    @Test
    public void turnTo_westToSouth() {
        //given
        Direction direction = Direction.West;
        Direction newDirection = Direction.South;
        SnakeHeadStateMachine machine = new SnakeHeadStateMachine(direction);

        //when
        machine.turnTo(newDirection);

        //then
        Direction result = machine.getDirection();
        assertEquals(Direction.South, result);
    }

    @Test
    public void turnTo_westToNorth() {
        //given
        Direction direction = Direction.West;
        Direction newDirection = Direction.North;
        SnakeHeadStateMachine machine = new SnakeHeadStateMachine(direction);

        //when
        machine.turnTo(newDirection);

        //then
        Direction result = machine.getDirection();
        assertEquals(Direction.North, result);
    }

    @Test
    public void turnTo_southToEast() {
        //given
        Direction direction = Direction.South;
        Direction newDirection = Direction.East;
        SnakeHeadStateMachine machine = new SnakeHeadStateMachine(direction);

        //when
        machine.turnTo(newDirection);

        //then
        Direction result = machine.getDirection();
        assertEquals(Direction.East, result);
    }

    @Test
    public void turnTo_southToWest() {
        //given
        Direction direction = Direction.South;
        Direction newDirection = Direction.West;
        SnakeHeadStateMachine machine = new SnakeHeadStateMachine(direction);

        //when
        machine.turnTo(newDirection);

        //then
        Direction result = machine.getDirection();
        assertEquals(Direction.West, result);
    }

    @Test
    public void turnTo_northToEast() {
        //given
        Direction direction = Direction.North;
        Direction newDirection = Direction.East;
        SnakeHeadStateMachine machine = new SnakeHeadStateMachine(direction);

        //when
        machine.turnTo(newDirection);

        //then
        Direction result = machine.getDirection();
        assertEquals(Direction.East, result);
    }

    @Test
    public void turnTo_northToWest() {
        //given
        Direction direction = Direction.North;
        Direction newDirection = Direction.West;
        SnakeHeadStateMachine machine = new SnakeHeadStateMachine(direction);

        //when
        machine.turnTo(newDirection);

        //then
        Direction result = machine.getDirection();
        assertEquals(Direction.West, result);
    }

    @Test
    public void turnTo_southToNorth() {
        //given
        Direction direction = Direction.South;
        Direction newDirection = Direction.North;
        SnakeHeadStateMachine machine = new SnakeHeadStateMachine(direction);

        //when
        machine.turnTo(newDirection);

        //then
        Direction result = machine.getDirection();
        assertEquals(Direction.South, result);
    }

    @Test
    public void turnTo_northToSouth() {
        //given
        Direction direction = Direction.North;
        Direction newDirection = Direction.South;
        SnakeHeadStateMachine machine = new SnakeHeadStateMachine(direction);

        //when
        machine.turnTo(newDirection);

        //then
        Direction result = machine.getDirection();
        assertEquals(Direction.North, result);
    }

    @Test
    public void turnTo_eastToWest() {
        //given
        Direction direction = Direction.East;
        Direction newDirection = Direction.West;
        SnakeHeadStateMachine machine = new SnakeHeadStateMachine(direction);

        //when
        machine.turnTo(newDirection);

        //then
        Direction result = machine.getDirection();
        assertEquals(Direction.East, result);
    }

    @Test
    public void turnTo_westToEast() {
        //given
        Direction direction = Direction.West;
        Direction newDirection = Direction.East;
        SnakeHeadStateMachine machine = new SnakeHeadStateMachine(direction);

        //when
        machine.turnTo(newDirection);

        //then
        Direction result = machine.getDirection();
        assertEquals(Direction.West, result);
    }

    @Test
    public void checkOrientation_vertical(){
        //given
        Direction direction = Direction.North;
        Direction newDirection = Direction.South;

        //when
        SnakeHeadStateMachine machine = new SnakeHeadStateMachine(direction);

        //then
        boolean isVertical = machine.checkOrientation(newDirection);
        assertEquals(true,isVertical);
    }
    @Test
    public void checkOrientation_horizontal(){
        //given
        Direction direction = Direction.East;
        Direction newDirection = Direction.West;

        //when
        SnakeHeadStateMachine machine = new SnakeHeadStateMachine(direction);

        //then
        boolean isVertical = machine.checkOrientation(newDirection);
        assertEquals(false,isVertical);
    }
    @Test
    public void checkOrientation_same_vertical(){
        //given
        Direction direction = Direction.South;
        Direction newDirection = Direction.South;

        //when
        SnakeHeadStateMachine machine = new SnakeHeadStateMachine(direction);

        //then
        boolean isVertical = machine.checkOrientation(newDirection);
        assertEquals(true,isVertical);
    }
    @Test
    public void checkOrientation_same_horizontal(){
        //given
        Direction direction = Direction.East;
        Direction newDirection = Direction.East;

        //when
        SnakeHeadStateMachine machine = new SnakeHeadStateMachine(direction);

        //then
        boolean isVertical = machine.checkOrientation(newDirection);
        assertEquals(false,isVertical);
    }
}