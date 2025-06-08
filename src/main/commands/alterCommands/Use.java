package main.commands.alterCommands;

import java.util.ArrayList;
import java.util.List;
import main.Game;
import main.Main;
import main.world.*;

public class Use extends AlterCommand {

    public Use(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
    }

    @Override
    public String execute() {
        Key keyToUse;
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
            int a = 1;
            for (Item i : keys) {
                System.out.println("Key " + a + " : " + i.getDescription());
                a++;
            }
            boolean verif = true;
            do {
                try {
                    System.out.print("Witch key do you want to use (enter the number) ? ");
                    String numberStr = Main.askSomething();
                    number = Integer.parseInt(numberStr) - 1;
                    verif = false;
                    if (number >= keys.size() || number < 0) {
                        verif = true;
                        System.out.println("This key is not on the list");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("This is not a number");
                }
            } while (verif);
            keyToUse = (Key) keys.get(number);
        }

        return checkKey(keyToUse);
    }

    private String checkKey(Key keyToUse) {
        Location[][] currentMap = Game.getInstance().getWorldMap().getMap();
        int[] PP = Game.getInstance().getWorldMap().getPP();

        if (checkKeyOnOneLoc(PP[0] + 1, PP[1], keyToUse)) {
            currentMap[PP[0] + 1][PP[1]].unlock();
            return "You've unlocked the " + currentMap[PP[0] + 1][PP[1]].getName();

        } else if (checkKeyOnOneLoc(PP[0] - 1, PP[1], keyToUse)) {
            currentMap[PP[0] - 1][PP[1]].unlock();
            return "You've unlocked the " + currentMap[PP[0] - 1][PP[1]].getName();

        } else if (checkKeyOnOneLoc(PP[0], PP[1] + 1, keyToUse)) {
            currentMap[PP[0]][PP[1] + 1].unlock();
            return "You've unlocked the " + currentMap[PP[0]][PP[1] + 1].getName();

        } else if (checkKeyOnOneLoc(PP[0], PP[1] - 1, keyToUse)) {
            currentMap[PP[0]][PP[1] - 1].unlock();
            return "You've unlocked the " + currentMap[PP[0]][PP[1] - 1].getName();

        } else {
            return "This key didn't opened any location.";
        }
    }

    private boolean checkKeyOnOneLoc(int x, int y, Key keyToUse) {
        Location[][] currentMap = Game.getInstance().getWorldMap().getMap();
        if (currentMap.length > x && currentMap[0].length > y && x >= 0 && y >= 0) {
            return currentMap[x][y].checkKey(keyToUse);
        } else {
            return false;
        }
    }
}
