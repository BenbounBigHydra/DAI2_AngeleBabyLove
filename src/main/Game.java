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
    private boolean isRunning;

    public CommandTracker getCommandTracker() {
        return this.commandTracker;
    }

    private Game() {
        this.player = new Player();
        this.map = new Worldmap();
        this.commands = new CommandManager();
        this.commandTracker = new CommandTracker();
        this.isRunning = false;
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

    public void gameOn(){
        this.isRunning = true;
    }

    public void gameOff(){
        this.isRunning = false;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

}
