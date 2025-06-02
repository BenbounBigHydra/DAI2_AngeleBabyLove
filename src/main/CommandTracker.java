package main;

import java.util.ArrayList;
import java.util.List;

public class CommandTracker {

    private List<String> commandTracker = new ArrayList<>();
    private List<String> commandsToReload = new ArrayList<>();

    public List<String> getCommandTracker() {
        return commandTracker;
    }

    public void addCommand(String command) {
        this.commandTracker.add(command);
    }

    public List<String> getCommandsToReload() {
        return commandsToReload;
    }

    
}
