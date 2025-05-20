package main.commands.alterCommands;

public class MoveEast extends Move {

    public MoveEast(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
    }

    @Override
    protected int[] calculatePP(int[] actualPosition) {
        return new int[]{actualPosition[0], actualPosition[1] + 1};
    }

}
