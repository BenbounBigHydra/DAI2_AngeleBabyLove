package main.commands.alterCommands;

import main.Game;
import main.Main;
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
            boolean verif = true;
            int number = 0;
            do {
                try {
                    System.out.print("Witch item do you want to take (enter the number) ? ");
                    String numberStr = Main.askSomething();
                    number = Integer.parseInt(numberStr) - 1;
                    verif = false;
                    if (number >= currentLoc.getListItems().size()) {
                        verif = true;
                        System.out.println("This item is not in the location");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("This is not a number");
                }
            } while (verif);
            Game.getInstance().getPlayer().getInventory().addItem(currentLoc.getListItems().get(number));
            currentLoc.getListItems().remove(number);
            return "This item has been added to your inventory";
        }
    }
}
