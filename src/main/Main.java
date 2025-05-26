package main;

import java.text.Normalizer;
import utils.Color;
import utils.StringStyling;
import utils.Style;

public class Main {

    public static void main(String[] args) {
        System.out.println(StringStyling.StyleString("Starting...", Style.ITALIC, Color.BLACK));
        Game thisGame = Game.getInstance();

        boolean running = true;
        do {
            System.out.print("What do you want to do : ");

            String action = thisGame.getCommandManager().executeCommand(askSomething());

            if (action == null) {
                running = false;
            } else {
                System.out.println(action);
            }
        } while (running);

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
