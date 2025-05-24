package main.commands;

import main.Game;

public class Help extends Command{

    public Help(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
    }

    @Override
    public String execute() {
        String toReturn = "";

        for (Command c : Game.getInstance().getCommandManager().getSetCommands()) {
            toReturn = toReturn + c.getAction() + " : " + c.getDescription() + System.lineSeparator();
        }

        return toReturn;
    }
    
}
