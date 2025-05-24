package main.commands;

import java.text.Normalizer;
import java.util.*;
import main.commands.alterCommands.MoveEast;
import main.commands.alterCommands.MoveNorth;
import main.commands.alterCommands.MoveSouth;
import main.commands.alterCommands.MoveWest;
import main.commands.infosCommands.MapDisplay;

public class CommandManager {

    private Set<Command> setCommands = new HashSet<>();

    public CommandManager() {
        setCommands.add(new MoveEast("Allow you to move east", "moveeast"));
        setCommands.add(new MoveNorth("Allow you to move north", "movenorth"));
        setCommands.add(new MoveSouth("Allow you to move south", "movesouth"));
        setCommands.add(new MoveWest("Allow you to move west", "movewest"));

        setCommands.add(new MapDisplay("Display the map", "map"));
        //Il faudra ajouter ici les autres commandes
    }

    public void addCommand(Command c) {
        this.setCommands.add(c);
    }

    public String executeCommand(String brutCommand) {
        String message = null;

        Command commandToExecute = this.translateCommand(brutCommand);

        if (commandToExecute != null) {
            message = commandToExecute.execute();
        } else {
            message = "This command doesn't exist";
        }

        return message;
    }

    private Command translateCommand(String brutCommand) {
        String normalized = brutCommand.toLowerCase();
        normalized = Normalizer.normalize(normalized, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
        normalized = normalized.replaceAll("[^A-Za-z]", "");

        for (Command c : this.setCommands) {
            if (c.getAction().equals(normalized)) {
                return c;
            }
        }
        return null;
    }
}
