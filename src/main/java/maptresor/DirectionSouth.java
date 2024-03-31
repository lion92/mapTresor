package maptresor;

public class DirectionSouth implements IDirection {

    @Override
    public PointAdventurer move() {
        return new PointAdventurer(0, +1);
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
