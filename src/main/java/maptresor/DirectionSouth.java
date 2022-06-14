package maptresor;

public class DirectionSouth implements IDirection {

    @Override
    public PointRover move() {
        return new PointRover(0, -1);
    }

    @Override
    public Direction turnRight() {
        return Direction.WEST;
    }

    @Override
    public Direction turnLeft() {
        return Direction.EAST;
    }
}
