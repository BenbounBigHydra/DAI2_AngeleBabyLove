package main.commands;

public abstract class Command implements ICommand, Comparable<Command> {

    private String description;
    private String action;

    public Command(String descriptionTransfer, String actionTransfer) {
        this.description = descriptionTransfer;
        String actionNormalized = actionTransfer;
        this.action = actionNormalized;
    }

    public String getDescription() {
        return this.description;
    }

    public String getAction() {
        return this.action;
    }

    @Override
    public int compareTo(Command c) {
        int diff = this.noToCompare() - c.noToCompare();
        if (diff != 0) {
            return diff;
        } else {
            return this.getAction().compareTo(c.getAction());
        }
    }

    protected abstract int noToCompare();
}
