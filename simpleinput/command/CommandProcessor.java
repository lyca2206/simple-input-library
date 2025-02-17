package simpleinput.command;

import java.util.Map;
import java.util.function.Function;

public class CommandProcessor<R> implements Function<String[], R> {
    private Map<String, Command<R>> commands;

    public CommandProcessor(Map<String, Command<R>> commands) {
        this.commands = commands;
    }

    public String[] getAvailableCommands() { return commands.keySet().toArray(String[]::new); }
    
    public String getCommandInformation(String name) {
        Command<R> command = commands.get(name);
        if (command == null) { return ""; }

        return command.getInformation();
    }

    public void addCommand(Command<R> command) { commands.putIfAbsent(command.getKey(), command); }
    public void removeCommand(Command<R> command) { commands.remove(command.getKey()); }

    @Override
    public R apply(String[] tokens) {
        Command<R> command = commands.get(tokens[0]);
        if (command == null) { return null; }
        
        return command.execute(tokens);
    }
}