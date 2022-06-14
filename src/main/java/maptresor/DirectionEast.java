package maptresor;

public class DirectionEast implements IDirection {

    @Override
    public PointRover move() {
        return new PointRover(1, 0);
    }

    @Override
    public Direction turnRight() {
        return Direction.SOUTH;
    }

    @Override
    public Direction turnLeft() {
        return Direction.NORTH;
    }
}
