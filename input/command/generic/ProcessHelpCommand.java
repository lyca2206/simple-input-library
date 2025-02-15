package libraries.input.command.generic;

import java.util.Arrays;

import libraries.input.command.Command;
import libraries.input.command.CommandProcessor;

public class ProcessHelpCommand extends Command<Boolean> {
    private CommandProcessor<Boolean> commandProcessor;
    
    public ProcessHelpCommand(
        String key,
        String information,
        CommandProcessor<Boolean> commandProcessor
    ) {
        super(key, information, commandProcessor);
        this.commandProcessor = commandProcessor;
    }

    @Override
    public Boolean execute(String[] args) {
        try {
            String information = commandProcessor.getCommandInformation(args[1]);
            System.out.println( " > " + information );
        } catch (IndexOutOfBoundsException _) {
            String[] commands = commandProcessor.getAvailableCommands();

            String message = Arrays.toString(commands);
            message = message.substring(1, message.length() - 1);
            
            System.out.println( " > " + message );
        }
        
        return true;
    }
}