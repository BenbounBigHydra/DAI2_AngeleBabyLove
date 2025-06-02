package main.commands.alterCommands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import main.Game;

public class Save extends AlterCommand {

    public Save(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
    }

    @Override
    public String execute() {
        try {
            Files.write(Paths.get("src/main/savedCommands.txt"), new byte[0]);
        } catch (IOException e) {
        }
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
