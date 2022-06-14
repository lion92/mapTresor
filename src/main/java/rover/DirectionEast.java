package rover;

public class DirectionEast implements IDirection{
    private PointRover pointRover;

    public DirectionEast(PointRover rover) {
        this.pointRover = rover;
    }

    @Override
    public PointRover move() {
        return pointRover.moveEast();
    }
}
