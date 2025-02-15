package libraries.input.command.generic;

import libraries.input.command.Command;
import libraries.input.command.CommandProcessor;

public class QuitCommand extends Command<Boolean> {
    public QuitCommand(
        String key,
        String information,
        CommandProcessor<Boolean> commandProcessor
    ) { super(key, information, commandProcessor); }

    @Override
    public Boolean execute(String[] args) {
        System.out.println(" > Exiting the program...");
        return false;
    }
}