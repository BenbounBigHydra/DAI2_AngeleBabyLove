package main.commands.alterCommands;

public class MoveNorth extends Move {

    public MoveNorth(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
    }

    @Override
    protected int[] calculatePP(int[] actualPosition) {
        return new int[]{actualPosition[0] - 1, actualPosition[1]};
    }
}
