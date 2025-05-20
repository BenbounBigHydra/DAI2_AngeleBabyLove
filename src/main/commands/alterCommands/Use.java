package main.commands.alterCommands;

public class Use extends AlterCommand{
    
    public Use(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
    }

    @Override
    protected String executeCommand() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
