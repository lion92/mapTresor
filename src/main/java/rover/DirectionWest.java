package rover;

public class DirectionWest implements IDirection{
    private PointRover pointRover;

    public DirectionWest(PointRover rover) {
        this.pointRover = rover;
    }

    @Override
    public PointRover move() {
        return pointRover.moveWest();
    }
}
