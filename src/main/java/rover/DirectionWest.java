package rover;

public class DirectionWest implements IDirection{

    @Override
    public PointRover move() {
        return new PointRover(- 1, 0);
    }

    @Override
    public Direction turnRight() {
        return Direction.NORTH;
    }

    @Override
    public Direction turnLeft() {
        return Direction.SOUTH;
    }
}
