package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.List;
import utils.Color;
import utils.StringStyling;
import utils.Style;

public class Main {

    public static void main(String[] args) {
        String answer;
        Game thisGame = Game.getInstance();

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
            System.out.println();
            System.out.println(StringStyling.StyleString("Loading the saved game...", Style.ITALIC, Color.BLACK));
            System.out.println();

            try {
                List<String> lines = Files.readAllLines(Paths.get("src/main/savedCommands.txt"));

                for (String string : lines) {
                    System.out.println(thisGame.getCommandManager().executeCommand(string));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        boolean running = true;
        do {
            System.out.print("What do you want to do : ");

            String action = thisGame.getCommandManager().executeCommand(askSomething());

            if (action == null) {
                running = false;
            } else {
                System.out.println(action);
                System.out.println();
            }
        } while (running);

        System.out.println("Congratulation ! You entered the chill and found all the beer");

        System.out.println(StringStyling.StyleString("Terminating...", Style.ITALIC, Color.BLACK));
    }

    public static String askSomething() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        String asked = scanner.nextLine();

        return asked;
    }

    public static String normalizeString(String unnormalized) {
        String normalized = unnormalized.toLowerCase();
        normalized = Normalizer.normalize(normalized, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
        normalized = normalized.replaceAll("[^A-Za-z]", "");

        return normalized;
    }
}
