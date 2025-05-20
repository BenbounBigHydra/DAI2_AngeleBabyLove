package main.commands.alterCommands;

public class Take extends AlterCommand{
    
    public Take(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
    }

    @Override
    protected String executeCommand() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
