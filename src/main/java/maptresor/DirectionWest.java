package maptresor;

public class DirectionWest implements IDirection {

    @Override
    public PointAdventurer move() {
        return new PointAdventurer(-1, 0);
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
