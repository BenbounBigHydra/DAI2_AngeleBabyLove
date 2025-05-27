package main.commands;

import main.Game;
import utils.Color;
import utils.StringStyling;
import utils.Style;

public class Help extends Command{

    public Help(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
    }

    @Override
    public String execute() {
        String toReturn = "";

        for (Command c : Game.getInstance().getCommandManager().getSetCommands()) {
            toReturn = toReturn + StringStyling.StyleString(c.getAction(), Style.BOLD, Color.GREEN) + " : " + c.getDescription() + System.lineSeparator();
        }

        return toReturn;
    }

    @Override
    protected int noToCompare(){
        return 1;
    }
}
