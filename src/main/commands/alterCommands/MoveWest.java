package main.commands.alterCommands;

public class MoveWest extends Move {

    public MoveWest(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
    }

    @Override
    protected int[] calculatePP(int[] actualPosition) {
        return new int[]{actualPosition[0], actualPosition[1] - 1};
    }
}
