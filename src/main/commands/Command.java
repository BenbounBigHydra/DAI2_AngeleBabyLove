package main.commands;

import java.text.Normalizer;

public abstract class Command implements ICommand {

    private String description;
    private String action;

    public Command(String descriptionTransfer, String actionTransfer) {
        this.description = descriptionTransfer;
        String actionNormalized = actionTransfer.toLowerCase();
        actionNormalized = Normalizer.normalize(actionNormalized, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
        actionNormalized = actionNormalized.replaceAll("[^A-Za-z]", "");
        this.action = actionNormalized;
    }

    public String getDescription() {
        return this.description;
    }

    public String getAction() {
        return this.action;
    }

    public String execute() {
        String message = null;
        message = this.executeCommand();
        return message;
    }

    protected abstract String executeCommand();
}
