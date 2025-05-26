package main.commands.infosCommands;

import main.Game;
import main.world.Item;

public class Look extends InfosCommand {
    
    public Look(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
    }

    @Override
    public String execute() {
        String toReturn = Game.getInstance().getWorldMap().getMap()[Game.getInstance().getWorldMap().getPP()[0]][Game.getInstance().getWorldMap().getPP()[1]].getDescription();

        for (Item item : Game.getInstance().getWorldMap().getMap()[Game.getInstance().getWorldMap().getPP()[0]][Game.getInstance().getWorldMap().getPP()[1]].getListItems()) {
            toReturn = toReturn + System.lineSeparator() + item.getDescription();
        }

        return toReturn;
    }
    
}
