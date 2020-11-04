package touro.snake.strategy.astar.nagel;

import touro.snake.*;
import touro.snake.strategy.SnakeStrategy;
import touro.snake.strategy.astar.Node;

import java.util.ArrayList;
import java.util.List;

public class AStarStrategy implements SnakeStrategy {

    List<Node> open = new ArrayList<>();       //the set of nodes to be evaluated
    List<Node> closed = new ArrayList<>();     //the set of nodes already evaluated
    List<Square> path = new ArrayList<>();
    List<Square> searchSpace = new ArrayList<>();

    @Override
    public void turnSnake(Snake snake, Garden garden) {
        reset();

        Square head = snake.getHead();    //start
        Food food = garden.getFood();     //target
        if (food == null) {
            return;
        }

        open.add(new Node(head));

        aStar(snake, head, food);

    }

    private void reset() {
        open.clear();
        closed.clear();
        path.clear();
        searchSpace.clear();
    }

    private void aStar(Snake snake, Square head, Food food) {
        Node currNode;
        while (!open.isEmpty()) {
            currNode = getLowestCost();
            currNode = getDirection(snake, head, food, currNode);

            if(currNode == null || currNode.equals(food)) {
                break;
            }
            search(snake, food, currNode);
        }
    }

    private Node getLowestCost() {
        Node currNode = open.get(0);
        for (Node node : open) {
            if (node.getCost() < currNode.getCost()) {
                currNode = node;
            }
        }
        open.remove(currNode);
        closed.add(currNode);
        return currNode;
    }

    private Node getDirection(Snake snake, Square head, Food food, Node currNode) {
        if (currNode.equals(food)) {
            while (!currNode.getParent().equals(head)) {
                currNode = currNode.getParent();
                path.add(new Square(currNode.getX(), currNode.getY()));
            }
            Direction direction = head.directionTo(currNode);
            snake.turnTo(direction);
            return null;
        }
        return currNode;
    }

    private void search(Snake snake, Food food, Node currNode) {
        Direction[] directions = Direction.values();
        for (Direction dir : directions) {
            Node neighbor = new Node(currNode.moveTo(dir));
            //ensure direction chosen is not in snake, closed, or out of bounds
            if (snake.contains(neighbor) || closed.contains(neighbor) || !neighbor.inBounds()) {
                continue;
            }
            if (open.contains(neighbor)) {
                int ixNeighbor = open.indexOf(neighbor);
                Node oldPath = open.get(ixNeighbor);
                Node newPath = new Node(neighbor, currNode, food);
                if (newPath.getCost() < oldPath.getCost() || !open.contains(neighbor)) {
                    open.set(ixNeighbor, newPath);
                    currNode = neighbor.getParent();
                }
            }
            if (!open.contains(neighbor)) {
                open.add(new Node(neighbor, currNode, food));
                searchSpace.add(neighbor);
            }
        }
    }

    @Override
    public List<Square> getPath() {
        return path;
    }

    @Override
    public List<Square> getSearchSpace() {
        return searchSpace;
    }
}

