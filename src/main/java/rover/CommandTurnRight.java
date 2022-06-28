package rover;

public class CommandTurnRight implements Command {
    @Override
    public Rover execute(Rover rover) {
        return new Rover(rover.getPointRover(), rover.getDirection().turnRight());
    }
}
