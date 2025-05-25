package main.commands;

import java.text.Normalizer;
import java.util.*;
import main.commands.alterCommands.MoveEast;
import main.commands.alterCommands.MoveNorth;
import main.commands.alterCommands.MoveSouth;
import main.commands.alterCommands.MoveWest;
import main.commands.alterCommands.Say;
import main.commands.alterCommands.Take;
import main.commands.alterCommands.Use;
import main.commands.infosCommands.Inspect;
import main.commands.infosCommands.ListInventory;
import main.commands.infosCommands.Look;
import main.commands.infosCommands.MapDisplay;

public class CommandManager {

    private Set<Command> setCommands;

    public Set<Command> getSetCommands() {
        return setCommands;
    }

    public CommandManager() {
        setCommands = new TreeSet<>();

        setCommands.add(new Help("Show you all commands", "help"));

        setCommands.add(new MoveEast("Allow you to move east", "moveeast"));
        setCommands.add(new MoveNorth("Allow you to move north", "movenorth"));
        setCommands.add(new MoveSouth("Allow you to move south", "movesouth"));
        setCommands.add(new MoveWest("Allow you to move west", "movewest"));

        setCommands.add(new MapDisplay("Display the map", "map"));
        setCommands.add(new Look("Show you the place you're in", "look"));
        setCommands.add(new ListInventory("Show items in the inventory", "list"));
        setCommands.add(new Inspect("Allow you to inspect letters in your inventory", "inspect"));

        //Encore à coder
        setCommands.add(new Say("Allow you to propose an answer for a puzzle", "say"));
        setCommands.add(new Take("Allow you to take an item to add in your inventory", "take"));
        setCommands.add(new Use("Allow you to use keys to unlock locations", "use"));
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
