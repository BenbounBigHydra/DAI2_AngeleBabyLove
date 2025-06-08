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
            System.out.println(StringStyling.StyleString(
                "Hey you! What's up?" + System.lineSeparator()
                + "You've just launched the best indie game in all of HEIG!" + System.lineSeparator()
                + "Or at least... that's what we're aiming for." + System.lineSeparator()
                + System.lineSeparator()
                + "Right now, you're on the Cheseaux map." + System.lineSeparator()
                + "As you can see, there's the court area, the Baleinev room, the school, the cafet'," + System.lineSeparator()
                + "and most importantly... the chill zone. That's where you wanna be." + System.lineSeparator()
                + System.lineSeparator()
                + "Why? Well, rumor has it they just got a fresh delivery of beers," + System.lineSeparator()
                + "and your goal is to swipe them all to give 'em a proper taste test." + System.lineSeparator()
                + "Yeah yeah, maybe you're a bit selfish and impatient. So what?" + System.lineSeparator()
                + System.lineSeparator()
                + "Of course, some zones are locked." + System.lineSeparator()
                + "You'll need to explore the map and gather intel to find the legendary keys to chill." + System.lineSeparator()
                + System.lineSeparator()
                + "On your way, you'll bump into some familiar names (or maybe not)," + System.lineSeparator()
                + "representing our so-called \"real\" engineer buddies." + System.lineSeparator()
                + "Oh, and there's Nami—Leo's dog." + System.lineSeparator()
                + "She's got something in her mouth that might come in real handy if you're trying to move faster..." + System.lineSeparator()
                + "I won't spoil it, but don't get too cocky. She's not giving it up without a fight." + System.lineSeparator()
                + System.lineSeparator()
                + "I think that's everything. If I forgot something... too bad." + System.lineSeparator()
                + "Good luck, you're gonna need it."
                , Style.ITALIC, Color.BLACK));
            System.out.println();

            System.out.println(thisGame.getCommandManager().executeCommand("help"));
            System.out.println(StringStyling.StyleString("You", Style.BOLD, Color.GREEN) + " - " + StringStyling.StyleString("Locked", Style.ITALIC, Color.RED));
            System.out.println(thisGame.getCommandManager().executeCommand("map"));

        } else if (answer.equals("load")) {
            thisGame.gameOff();

            System.out.println();
            System.out.println(StringStyling.StyleString("Loading the saved game...", Style.ITALIC, Color.BLACK));
            System.out.println();

            try {
                thisGame.getCommandTracker().getCommandsToReload().addAll(Files.readAllLines(Paths.get("src/main/savedCommands.txt")));

                while (!thisGame.getCommandTracker().getCommandsToReload().isEmpty()) {
                    System.out.println(Game.getInstance().getCommandManager().executeCommand(reloadCommand()));
                }

                thisGame.getCommandTracker().getCommandsToReload().clear();
            } catch (IOException e) {
                e.printStackTrace();
            }

            thisGame.gameOn();
        }

        do {
            System.out.println();
            System.out.print(StringStyling.StyleString("What do you want to do : ", Style.ITALIC, Color.BLACK));

            String action = thisGame.getCommandManager().executeCommand(askSomething());

            if (action == null) {
                thisGame.gameOff();
            } else {
                System.out.println();
                System.out.println(action);
                System.out.println();
            }
        } while (thisGame.isRunning());

        System.out.println("Congratulation ! You entered the chill and found all the beers");

        System.out.println(StringStyling.StyleString("Terminating...", Style.ITALIC, Color.BLACK));
    }

    public static String askSomething() {
        if (!Game.getInstance().isRunning()) {
            String entry = reloadCommand();
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

    public static String reloadCommand() {
        String executeString = Game.getInstance().getCommandTracker().getCommandsToReload().poll();
        System.out.println(executeString);
        Game.getInstance().getCommandTracker().addCommand(executeString);
        return executeString;
    }
}
