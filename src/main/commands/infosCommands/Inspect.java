package main.commands.infosCommands;

import java.util.ArrayList;
import java.util.List;
import main.Game;
import main.Main;
import main.world.Item;
import main.world.Letter;

public class Inspect extends InfosCommand {

    public Inspect(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
    }

    @Override
    public String execute() {
        List<Item> letters = new ArrayList<>();
        for (Item i : Game.getInstance().getPlayer().getInventory().getListItemInInventory()) {
            if (i instanceof Letter) {
                letters.add(i);
            }
        }
        int number = 0;
        if (letters.isEmpty()) {
            return "You have no letter to inspect";
        } else {
            for (Item i : letters) {
                System.out.println("Lettre 1 : " + i.getDescription());
            }
            boolean verif = true;
            do {
                try {
                    System.out.print("Witch letter do you want to inspect (enter the number) ? ");
                    String numberStr = Main.askSomething();
                    number = Integer.parseInt(numberStr) - 1;
                    verif = false;
                    if (number >= letters.size()) {
                        verif = true;
                        System.out.println("This letter is not on the list");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("This is not a number");
                }
            } while (verif);
        }
        return ((Letter) letters.get(number)).getContent();
    }

}
