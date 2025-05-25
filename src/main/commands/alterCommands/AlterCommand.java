package main.commands.alterCommands;

import main.commands.Command; 

public abstract class AlterCommand extends Command{
    
    public AlterCommand(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
    }
    
    @Override
    protected int noToCompare(){
        return 3;
    }
}