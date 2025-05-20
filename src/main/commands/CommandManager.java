package main.commands;

import java.text.Normalizer;
import java.util.*;

public class CommandManager {

    private List<Command> listCommands = new ArrayList<>();

    public void addCommand(Command c) {
        this.listCommands.add(c);
    }

    public String executeCommand(String brutCommand) {
        String message = null;

        Command commandToExecute = this.translateCommand(brutCommand);

        commandToExecute.execute();

        return message;
    }

    private Command translateCommand(String brutCommand) {
        String normalized = brutCommand.toLowerCase();
        normalized = Normalizer.normalize(normalized, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
        normalized = normalized.replaceAll("[^A-Za-z]", "");

        for (Command c : this.listCommands) {
            if (c.getAction() == normalized) {
                return c;
            }
        }
        return null;
    }
}
