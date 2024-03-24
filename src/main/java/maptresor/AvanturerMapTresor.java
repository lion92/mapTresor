package maptresor;

import commandParser.CommandParser;

import java.util.List;
import java.util.Objects;

public class AvanturerMapTresor {
    private final Direction direction;
    private final PointRover pointRover;

    public AvanturerMapTresor(int x, int y, Direction direction) {
        this.pointRover = new PointRover(x, y);
        this.direction = direction;
    }


    public AvanturerMapTresor(PointRover pointRover, Direction direction) {
        this.pointRover = pointRover;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public PointRover getPointRover() {
        return pointRover;
    }

    public AvanturerMapTresor receiveCommand(String command) {
        AvanturerMapTresor current = this;
        List<Command> commandList = new CommandParser().parserCommand(command);
        for (Command unitCommand : commandList) {
            current = unitCommand.execute(current);
        }
        return current;
    }

    public Boolean isAdenturerGetATresor(PointTresor pointTresor) {
        if (isRoverInATresor(pointTresor)) {
            return true;
        }
            return false;
    }

    private boolean isRoverInATresor(PointTresor pointTresor) {
        return this.pointRover.x() == pointTresor.x() && this.pointRover.y() == pointTresor.y();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvanturerMapTresor avanturerMapTresor = (AvanturerMapTresor) o;
        return direction == avanturerMapTresor.direction && Objects.equals(pointRover, avanturerMapTresor.pointRover);
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
