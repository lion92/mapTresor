package maptresor;

public class DirectionNorth implements IDirection {

    @Override
    public PointRover move() {
        return new PointRover(0, 1);
    }

    @Override
    public Direction turnRight() {
        return Direction.EAST;
    }

    @Override
    public Direction turnLeft() {
        return Direction.WEST;
    }
}
