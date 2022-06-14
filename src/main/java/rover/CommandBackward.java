package rover;

public class CommandBackward implements Command {

    @Override
    public Rover execute(Rover rover) {
        PointRover newPointRover = rover.getPointRover().removePoint(rover.getDirection().getForwardMouvement());
        return new Rover(newPointRover, rover.getDirection());
    }
}
