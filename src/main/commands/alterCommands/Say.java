package main.commands.alterCommands;

public class Say extends AlterCommand{
    
    public Say(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
    }

    @Override
    protected String executeCommand() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
