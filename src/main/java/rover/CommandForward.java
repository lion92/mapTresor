package rover;

public class CommandForward implements Command {

    @Override
    public Rover execute(Rover rover) {
        PointRover newPointRover = rover.getPointRover().sumPoint(rover.getDirection().getForwardMouvement());
        return new Rover(newPointRover, rover.getDirection());
    }
}
