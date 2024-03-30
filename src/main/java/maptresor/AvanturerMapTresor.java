package maptresor;

import commandParser.CommandParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AvanturerMapTresor {
    private final Direction direction;
    private final PointAdventurer pointAdventurer;


    private List<PointTresor> pointTresorList;
    private List<MontainsPoint> montainsPoints;
    private String name;
    List<AvanturerMapTresor> pointAdventurers;

    public AvanturerMapTresor(int x, int y, Direction direction) {
        this.pointAdventurer = new PointAdventurer(x, y);
        this.direction = direction;
        pointAdventurers = new ArrayList<>();
    }

    public AvanturerMapTresor(Direction direction, PointAdventurer pointAdventurer, String name) {
        pointAdventurers = new ArrayList<>();
        this.direction = direction;
        this.pointAdventurer = pointAdventurer;
        this.name = name;
    }

    public AvanturerMapTresor(PointAdventurer pointAdventurer, Direction direction) {
        this.pointAdventurer = pointAdventurer;
        this.direction = direction;
    }


    public Direction getDirection() {
        return direction;
    }

    public AvanturerMapTresor(Direction direction, PointAdventurer pointAdventurer, String name, List<MontainsPoint> montainsPoints, List<PointTresor> pointTresorList) {
        this.direction = direction;
        this.pointAdventurer = pointAdventurer;
        this.pointTresorList = pointTresorList;
        this.montainsPoints = montainsPoints;
        this.name = name;
    }

    public List<AvanturerMapTresor> receiveCommandHistorique(String command) {
        List<AvanturerMapTresor> avanturerMapTresors = new ArrayList<>();
        AvanturerMapTresor current = this;
        List<Command> commandList = new CommandParser().parserCommand(command);
        for (Command unitCommand : commandList) {
            current = unitCommand.execute(current);
            avanturerMapTresors.add(current);
        }
        return avanturerMapTresors;
    }

    public AvanturerMapTresor receiveCommand(String command) {
        List<AvanturerMapTresor> avanturerMapTresors = new ArrayList<>();
        AvanturerMapTresor current = this;
        List<Command> commandList = new CommandParser().parserCommand(command);
        for (Command unitCommand : commandList) {
            current = unitCommand.execute(current);
        }
        setPointAdventurers(avanturerMapTresors);
        return current;
    }

    public Boolean isAdenturerGetATresor(PointTresor pointTresor) {
        if (isAdventurierInATresor(pointTresor)) {
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

    private boolean isAdventuerFaceToMontaign(MontainsPoint montainsPoint) {
        AvanturerMapTresor foward = this.receiveCommand("A");
        if (foward.pointAdventurer.x() == montainsPoint.x() && foward.pointAdventurer.y() == montainsPoint.y()) {
            return true;
        }
        return false;
    }


    private boolean isAdventurierInATresor(PointTresor pointTresor) {
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
        return "AvanturerMapTresor{" +
                "direction=" + direction +
                ", pointAdventurer=" + pointAdventurer +
                ", name='" + name + '\'';
    }

    public PointAdventurer getPointAdventurer() {
        return pointAdventurer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AvanturerMapTresor> getPointAdventurers() {
        return pointAdventurers;
    }

    public void setPointAdventurers(List<AvanturerMapTresor> pointAdventurers) {
        this.pointAdventurers = pointAdventurers;
    }

    public List<PointTresor> getPointTresorList() {
        return pointTresorList;
    }

    public List<MontainsPoint> getMontainsPoints() {
        return montainsPoints;
    }
}
