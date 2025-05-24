package main.commands.alterCommands;

import main.Game;

public abstract class Move extends AlterCommand{
    
    public Move(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
    }
    
    protected void movePlayer(int x, int y){
        int[] PP = Game.getInstance().getWorldMap().getPP();
    }

}
