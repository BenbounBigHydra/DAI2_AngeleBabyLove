package main.commands.infosCommands;

import main.Game;
import main.world.Item;

public class Look extends InfosCommand {

    public Look(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
    }

    @Override
    @SuppressWarnings("SizeReplaceableByIsEmpty")
    public String execute() {
        if (Game.getInstance().getWorldMap().getMap()[Game.getInstance().getWorldMap().getPP()[0]][Game.getInstance().getWorldMap().getPP()[1]].getName().equals("Chill")) {
            return null;
        }
        String toReturn = Game.getInstance().getWorldMap().getMap()[Game.getInstance().getWorldMap().getPP()[0]][Game.getInstance().getWorldMap().getPP()[1]].getDescription();

        if (!Game.getInstance().getWorldMap().getMap()[Game.getInstance().getWorldMap().getPP()[0]][Game.getInstance().getWorldMap().getPP()[1]].getListItems().isEmpty()) {
            toReturn = toReturn + System.lineSeparator() + "Available items in this location :";
            for (Item item : Game.getInstance().getWorldMap().getMap()[Game.getInstance().getWorldMap().getPP()[0]][Game.getInstance().getWorldMap().getPP()[1]].getListItems()) {
                toReturn = toReturn + System.lineSeparator() + item.getDescription();
            }
        }

        return toReturn;
    }

}
