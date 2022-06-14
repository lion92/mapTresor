package rover;

public enum Direction {
    WEST(new DirectionWest()),
    EAST(new DirectionEast()),
    SOUTH(new DirectionSouth()),
    NORTH(new DirectionNorth());

    public final IDirection iDirection;

    Direction(IDirection iDirection) {
        this.iDirection = iDirection;
    }

    public PointRover moveForward(){
        return iDirection.move();
    }
}
