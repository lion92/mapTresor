package commandParser;

import maptresor.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommandParser {

    public Map<Character, Command> charToCommand = Map.of(
            'A', new CommandForward(),
            'D', new CommandTurnRight(),
            'G', new CommandTurnLeft());

    public List<Command> parserCommand(String command) {
        return command.chars()
                .mapToObj(c -> (char) c)
                .map(charactere -> charToCommand.get(charactere))
                .collect(Collectors.toList());
    }
}
