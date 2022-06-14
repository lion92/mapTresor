package commandParser;

import rover.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommandParser {

    public Map<Character, Command> charToCommand = Map.of(
            'F', new CommandForward(),
            'B', new CommandBackward(),
            'R',new CommandTurnRight(),
                'L', new CommandTurnLeft());

    public List<Command> parserCommand(String command) {
        return command.chars()
                .mapToObj(c -> (char) c)
                .map(charactere -> charToCommand.get(charactere))
                .collect(Collectors.toList());
    }
}
