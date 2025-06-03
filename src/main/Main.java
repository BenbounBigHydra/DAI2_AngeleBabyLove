package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer;
import utils.Color;
import utils.StringStyling;
import utils.Style;

public class Main {

    public static void main(String[] args) {
        String answer;
        Game thisGame = Game.getInstance();
        thisGame.gameOn();

        do {
            System.out.println("Do you want to start a new game or load the saved game ? (new/load)");
            answer = normalizeString(askSomething());
        } while (!answer.equals("new") && !answer.equals("load"));

        if (answer.equals("new")) {
            System.out.println();
            System.out.println(StringStyling.StyleString("Starting a new game...", Style.ITALIC, Color.BLACK));
            System.out.println();

            System.out.println(thisGame.getCommandManager().executeCommand("help"));
            System.out.println(thisGame.getCommandManager().executeCommand("map"));

        } else if (answer.equals("load")) {
            thisGame.gameOff();

            System.out.println();
            System.out.println(StringStyling.StyleString("Loading the saved game...", Style.ITALIC, Color.BLACK));
            System.out.println();

            try {
                thisGame.getCommandTracker().getCommandsToReload().addAll(Files.readAllLines(Paths.get("src/main/savedCommands.txt")));

                java.util.List<String> commands = thisGame.getCommandTracker().getCommandsToReload();
                for (int i = 0; i < commands.size(); i++) {
                    String executeString = commands.get(i);
                    System.out.println(executeString);
                    Game.getInstance().getCommandTracker().addCommand(executeString);
                    System.out.println(thisGame.getCommandManager().executeCommand(executeString));
                }

                thisGame.getCommandTracker().getCommandsToReload().clear();
            } catch (IOException e) {
                e.printStackTrace();
            }

            thisGame.gameOn();
        }

        do {
            System.out.print("What do you want to do : ");

            String action = thisGame.getCommandManager().executeCommand(askSomething());

            if (action == null) {
                thisGame.gameOff();
            } else {
                System.out.println(action);
                System.out.println();
            }
        } while (thisGame.isRunning());

        System.out.println("Congratulation ! You entered the chill and found all the beer");

        System.out.println(StringStyling.StyleString("Terminating...", Style.ITALIC, Color.BLACK));
    }

    public static String askSomething() {
        if (!Game.getInstance().isRunning()) {
            String entry = Game.getInstance().getCommandTracker().getCommandsToReload().get(Game.getInstance().getCommandTracker().getCommandTracker().size() - 1);
            // Game.getInstance().getCommandTracker().getCommandsToReload().remove(Game.getInstance().getCommandTracker().getCommandTracker().size());
            Game.getInstance().getCommandTracker().addCommand(entry);
            System.out.println(entry);
            return entry;
        }

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        String asked = scanner.nextLine();

        Game.getInstance().getCommandTracker().addCommand(asked);

        return asked;
    }

    public static String normalizeString(String unnormalized) {
        String normalized = unnormalized.toLowerCase();
        normalized = Normalizer.normalize(normalized, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
        normalized = normalized.replaceAll("[^A-Za-z]", "");

        return normalized;
    }
}
