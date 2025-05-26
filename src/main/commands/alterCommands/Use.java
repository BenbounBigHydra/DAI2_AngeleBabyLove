package main.commands.alterCommands;

import java.util.ArrayList;
import java.util.List;
import main.Game;
import main.Main;
import main.world.Item;
import main.world.Key;

public class Use extends AlterCommand {

    public Use(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
    }

    @Override
    public String execute() {
        List<Item> keys = new ArrayList<>();
        for (Item i : Game.getInstance().getPlayer().getInventory().getListItemInInventory()) {
            if (i instanceof Key) {
                keys.add(i);
            }
        }
        int number = 0;
        if (keys.isEmpty()) {
            return "You have no key to use";
        } else {
            int a = 0;
            for (Item i : keys) {
                System.out.println("Key " + a + " : " + i.getDescritpion());
            }
            boolean verif = true;
            do {
                try {
                    System.out.print("Witch key do you want to use (enter the number) ? ");
                    String numberStr = Main.askSomething();
                    number = Integer.parseInt(numberStr) - 1;
                    verif = false;
                    if (number >= keys.size()) {
                        verif = true;
                        System.out.println("This key is not on the list");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("This is not a number");
                }
            } while (verif);
            Key keyToUse = (Key) keys.get(number);
        }

        return "Pas encore codé";
    }
}
