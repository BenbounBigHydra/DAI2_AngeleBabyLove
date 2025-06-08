package main.commands.alterCommands;

import java.util.Map;
import main.Game;
import main.Main;
import main.world.Location;
import main.world.TeleportationCrystal;

public class Teleport extends AlterCommand {

    public Teleport(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
    }

    @Override
    public String execute() {
        if (!Game.getInstance().getPlayer().getInventory().getListItemInInventory().contains(TeleportationCrystal.getInstance())) {
            return "You don't have the teleportation crystal.";
        }

        /*System.out.println("Available destinations:");
        for (Location loc : TeleportationCrystal.getInstance().getLocationList().keySet()) {
            System.out.println("- " + loc.getName());
        }*/

        System.out.println("Where do you want to teleport?");
        String destination = Main.normalizeString(Main.askSomething());

        for (Map.Entry<Location, int[]> entry : TeleportationCrystal.getInstance().getLocationList().entrySet()) {
            if ((Main.normalizeString(entry.getKey().getName())).equals(destination)) {
                int[] coordinates = entry.getValue();
                Game.getInstance().getWorldMap().setPP(coordinates[0], coordinates[1]);
                System.out.println(Game.getInstance().getCommandManager().executeCommand("map"));
                return "You have been teleported.";
            }
        }

        return "You can't teleport to " + destination;
    }

}
