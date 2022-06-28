package rover;

import commandParser.CommandParser;

import java.util.List;
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

    public Direction getDirection() {
        return direction;
    }

    public PointRover getPointRover() {
        return pointRover;
    }

    public Rover receiveCommand(String command) {
        Rover current = this;
        List<Command> commandList = new CommandParser().parserCommand(command);
        for (Command unitCommand : commandList) {
            current = unitCommand.execute(current);
        }
        return current;
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
