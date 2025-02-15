package libraries.input.command;

import java.util.Map;
import java.util.function.Function;

public class CommandProcessor<T> implements Function<String[], T> {
    private Map<String, Command<T>> commands;

    public CommandProcessor(Map<String, Command<T>> commands) {
        this.commands = commands;
    }

    public String[] getAvailableCommands() { return commands.keySet().toArray(String[]::new); }
    
    public String getCommandInformation(String name) {
        Command<T> command = commands.get(name);
        if (command == null) { return ""; }

        return command.getInformation();
    }

    public void addCommand(Command<T> command) { commands.putIfAbsent(command.getKey(), command); }
    public void removeCommand(Command<T> command) { commands.remove(command.getKey()); }

    @Override
    public T apply(String[] tokens) {
        Command<T> command = commands.get(tokens[0]);
        if (command == null) { return null; }
        
        return command.execute(tokens);
    }
}