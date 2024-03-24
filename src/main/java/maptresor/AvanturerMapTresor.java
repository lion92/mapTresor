package maptresor;

import commandParser.CommandParser;

import java.util.List;
import java.util.Objects;

public class AvanturerMapTresor {
    private final Direction direction;
    private final PointAdventurer pointAdventurer;

    public AvanturerMapTresor(int x, int y, Direction direction) {
        this.pointAdventurer = new PointAdventurer(x, y);
        this.direction = direction;
    }


    public AvanturerMapTresor(PointAdventurer pointAdventurer, Direction direction) {
        this.pointAdventurer = pointAdventurer;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public PointAdventurer getPointRover() {
        return pointAdventurer;
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
    public Boolean isAdenturerIsFaceToAMontains(MontainsPoint montains) {
        if (isAdventuerFaceToMontaign(montains)) {
            return true;
        }
        return false;
    }

    private boolean isAdventuerFaceToMontaign(MontainsPoint montainsPoint){
        AvanturerMapTresor foward = this.receiveCommand("A");
        if(foward.pointAdventurer.x()==montainsPoint.x() && foward.pointAdventurer.y()==montainsPoint.y()){
            return true;
        }
        return false;
    }


    private boolean isRoverInATresor(PointTresor pointTresor) {
        return this.pointAdventurer.x() == pointTresor.x() && this.pointAdventurer.y() == pointTresor.y();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvanturerMapTresor avanturerMapTresor = (AvanturerMapTresor) o;
        return direction == avanturerMapTresor.direction && Objects.equals(pointAdventurer, avanturerMapTresor.pointAdventurer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, pointAdventurer);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "direction=" + direction +
                ", pointRover=" + pointAdventurer +
                '}';
    }



}
