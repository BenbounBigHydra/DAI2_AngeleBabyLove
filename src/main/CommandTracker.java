package main;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CommandTracker {

    private List<String> commandTracker = new ArrayList<>();

    private Deque<String> commandsToReload = new ArrayDeque<>();

    public List<String> getCommandTracker() {
        return commandTracker;
    }

    public void addCommand(String command) {
        String commandNorm = Main.normalizeString(command);
        if (commandNorm.equals("new") || commandNorm.equals("load") || commandNorm.equals("save")) {
        } else {
            this.commandTracker.add(command);
        }
    }

    public Deque<String> getCommandsToReload() {
        return commandsToReload;
    }
}
