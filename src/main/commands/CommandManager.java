package main.commands;

import java.util.*;
import main.Main;
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

        setCommands.add(new Help("Show you all commands", "Help"));

        setCommands.add(new MoveEast("Allow you to move east", "Move East"));
        setCommands.add(new MoveNorth("Allow you to move north", "Move North"));
        setCommands.add(new MoveSouth("Allow you to move south", "Move South"));
        setCommands.add(new MoveWest("Allow you to move west", "Move West"));
        setCommands.add(new Say("Allow you to propose an answer for a puzzle", "Say"));
        setCommands.add(new Take("Allow you to take an item to add in your inventory", "Take"));
        setCommands.add(new Use("Allow you to use keys to unlock locations", "Use"));

        setCommands.add(new MapDisplay("Display the map", "Map"));
        setCommands.add(new Look("Show you the place you're in", "Look"));
        setCommands.add(new ListInventory("Show items in the inventory", "List"));
        setCommands.add(new Inspect("Allow you to inspect letters in your inventory", "Inspect"));
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
        String normalized = Main.normalizeString(brutCommand);

        for (Command c : this.setCommands) {
            if (Main.normalizeString(c.getAction()).equals(normalized)) {
                return c;
            }
        }
        return null;
    }
}
