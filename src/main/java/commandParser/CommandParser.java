package commandParser;

import rover.Command;
import rover.CommandBackward;
import rover.CommandForward;

import java.util.ArrayList;
import java.util.List;

public class CommandParser {
    public List<Command> parserCommand(String command) {
        List<Command> listCommand = new ArrayList<>();
        for (char commandChar : command.toCharArray()) {
            if(commandChar=='F'){
                listCommand.add(new CommandForward());
            }
            if(commandChar=='B'){
                listCommand.add(new CommandBackward());
            }

        }
        return listCommand;
    }
}
