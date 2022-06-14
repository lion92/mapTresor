package rover;

public class CommandTurnLeft implements Command{
    @Override
    public Rover execute(Rover rover) {
        return new Rover(rover.getPointRover(),rover.getDirection().turnLeft());
    }
}
