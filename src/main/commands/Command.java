package main.commands;

import java.text.Normalizer;

public abstract class Command implements ICommand {

    @SuppressWarnings("FieldMayBeFinal")
    private String description;
    @SuppressWarnings("FieldMayBeFinal")
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
        String message = this.executeCommand();
        return message;
    }

    protected abstract String executeCommand();
}
