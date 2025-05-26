package main.commands.alterCommands;

import java.util.List;
import main.Game;
import main.Main;
import main.world.Item;
import main.world.Puzzle;

public class Say extends AlterCommand {

    public Say(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
    }

    @Override
    public String execute() {
        List<Puzzle> listPuzzles = Game.getInstance().getWorldMap().getMap()[Game.getInstance().getWorldMap().getPP()[0]][Game.getInstance().getWorldMap().getPP()[1]].getListPuzzle();
        System.out.println("What's your answer ?");
        String answer = Main.normalizeString(Main.askSomething());
        if (listPuzzles != null) {
            for (Puzzle p : listPuzzles) {
                if (answer.equals(p.getSolution())) {
                    listPuzzles.remove(p);
                    for (Item i : p.getReward()) {
                        Game.getInstance().getPlayer().getInventory().getListItemInInventory().add(i);
                    }
                    return p.getSaidWhenResolved();
                }
            }
        }
        return "This answer did nothing";
    }

}
