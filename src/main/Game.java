package main;

import main.commands.CommandManager;
import main.world.Player;
import main.world.Worldmap;

public class Game {

    private static Game instance;
    private Player player;
    private Worldmap map;
    private CommandManager commands;
    private CommandTracker commandTracker;

    public CommandTracker getCommandTracker() {
        return this.commandTracker;
    }

    private Game() {
        this.player = new Player();
        this.map = new Worldmap();
        this.commands = new CommandManager();
        this.commandTracker = new CommandTracker();
    }

    public static Game getInstance() {
        if (Game.instance == null) {
            Game.instance = new Game();
        }
        return Game.instance;
        //System.out.println("Initializing game...");
    }

    public CommandManager getCommandManager() {
        return this.commands;
    }

    public Worldmap getWorldMap() {
        return this.map;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void run() {
        System.out.println("Running game...");
        // your runtime code here...

        // end of game
    }

}
