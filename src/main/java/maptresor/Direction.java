package maptresor;

public enum Direction {
    WEST(new DirectionWest()),
    EAST(new DirectionEast()),
    SOUTH(new DirectionSouth()),
    NORTH(new DirectionNorth());

    public Direction turnRight() {
        return this.iDirection.turnRight();
    }

    public final IDirection iDirection;

    Direction(IDirection iDirection) {
        this.iDirection = iDirection;
    }


    public PointAdventurer getForwardMouvement() {
        return iDirection.move();
    }

    public Direction turnLeft() {
        return iDirection.turnLeft();
    }

}
