package main.commands.infosCommands;


import main.Game;
import main.world.Item;
import main.world.Key;
import main.world.TeleportationCrystal;

public class ListInventory extends InfosCommand {

    public ListInventory(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
    }

    @Override
    public String execute() {
        if (Game.getInstance().getPlayer().getInventory().getListItemInInventory().isEmpty()) {
            return "Your inventory is empty";
        } else {
            String toReturn = "Your inventory : " + System.lineSeparator();
            int n = 1;
            for (Item i : Game.getInstance().getPlayer().getInventory().getListItemInInventory()) {
                if (i instanceof Key) {
                    toReturn = toReturn + "Item " + n + " (Key) : " + i.getDescription() + System.lineSeparator();
                } else if (i instanceof TeleportationCrystal) {
                    toReturn = toReturn + "Item " + n + " : " + i.getDescription() + System.lineSeparator();
                } else {
                    toReturn = toReturn + "Item " + n + " (Letter) : " + i.getDescription() + System.lineSeparator();
                }
                n++;
            }
            return toReturn;
        }
    }

}
