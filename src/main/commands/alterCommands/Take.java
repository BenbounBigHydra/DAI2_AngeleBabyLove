package main.commands.alterCommands;

import main.Game;
import main.world.Item;
import main.world.Location;

public class Take extends AlterCommand {

    public Take(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
    }

    @Override
    public String execute() {
        Location currentLoc = Game.getInstance().getWorldMap().getMap()[Game.getInstance().getWorldMap().getPP()[0]][Game.getInstance().getWorldMap().getPP()[1]];
        if (currentLoc.getListItems().isEmpty()) {
            return "There is no item to take";
        } else {
            int n = 1;
            for (Item i : currentLoc.getListItems()) {
                System.out.println("Item " + n + " : " + i.getDescritpion());
            }
            do {
                System.out.println("Witch item do you want to take (enter the number) ? ");
            } while (false);
        }
    }
}
