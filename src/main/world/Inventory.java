package main.world;

import java.util.ArrayList;
import java.util.List;
import main.Game;
import main.commands.alterCommands.Teleport;

public class Inventory {

    private List<Item> listItemInInventory = new ArrayList<>();

    public List<Item> getListItemInInventory() {
        return listItemInInventory;
    }

    public void addItem(Item i) {
        if (i instanceof TeleportationCrystal) { // Add the teleport command once you have the teleportation crystal
            Game.getInstance().getCommandManager().addCommand(new Teleport("This item allow you to teleport in any location you already visited.", "Teleport"));
            System.out.println("You can now teleport to any location you already visited.");
        }
        listItemInInventory.add(i);
    }

    public void removeItem(Item i) {
        listItemInInventory.remove(i);
    }
}
