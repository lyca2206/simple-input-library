package simpleinput.command;

public abstract class Command<R> {
    private String key;
    private String information;

    public Command(String key, String information) {
        this.key = key;
        this.information = information;
    }

    public Command(String key, String information, CommandProcessor<R> commandProcessor) {
        this.key = key;
        this.information = information;
        commandProcessor.addCommand(this);
    }

    public String getKey() { return key; }
    public String getInformation() { return information; }
    
    public abstract R execute(String[] args);
}