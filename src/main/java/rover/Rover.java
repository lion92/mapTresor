package rover;

import java.util.Objects;

public class Rover {
    private final Direction direction;
    private final PointRover pointRover;

    public Rover(int x, int y, Direction direction) {
        this.pointRover = new PointRover(x, y);
        this.direction = direction;
    }

    public Rover(PointRover pointRover, Direction direction) {
        this.pointRover = pointRover;
        this.direction = direction;
    }

    public Rover receiveCommand(String command) {
        PointRover pointRover = todo();
        return new Rover(pointRover, direction);
    }

    private PointRover todo() {
        if (direction.equals(Direction.WEST)) {
             return new DirectionWest(this.pointRover).move();
        }
        if (direction.equals(Direction.EAST)) {
             return new DirectionEast(this.pointRover).move();

        }
        if (direction.equals(Direction.SOUTH)) {
             return new DirectionSouth(this.pointRover).move();
        }
        if(direction.equals(Direction.NORTH)){
             return new DirectionNorth(this.pointRover).move();
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return direction == rover.direction && Objects.equals(pointRover, rover.pointRover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, pointRover);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "direction=" + direction +
                ", pointRover=" + pointRover +
                '}';
    }
}
