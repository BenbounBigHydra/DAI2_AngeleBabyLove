package main.commands.alterCommands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import main.Game;

public class Save extends AlterCommand {

    public Save(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
    }

    @Override
    public String execute() {
        String filePath = "src/main/savedCommands.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String s : Game.getInstance().getCommandTracker().getCt()) {
                writer.write(s);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
        return "Your game has been saved";
    }

}
