package main.commands.alterCommands;

import main.Game;

public abstract class Move extends AlterCommand {

    public Move(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
    }

    @Override
    public String execute() {
        int[] PP = Game.getInstance().getWorldMap().getPP();
        int[] futurePP = this.calculatePP(PP);

        boolean canMove = this.checkMapBorder(futurePP);
        if (!canMove) {
            return "You've reach the end of the map.";
        }

        //Regarde si la case où se déplacer est vérouillée
        canMove = Game.getInstance().getWorldMap().getMap()[futurePP[0]][futurePP[1]].getUnlockedState();

        if (!canMove) {
            return "This location is locked";
        }

        canMove = Game.getInstance().getWorldMap().getMap()[futurePP[0]][futurePP[1]] != null;
        if (!canMove) {
            return "There is no location here";
        }

        Game.getInstance().getWorldMap().setPP(futurePP[0], futurePP[1]);

        System.out.println(Game.getInstance().getCommandManager().executeCommand("map"));

        return "You've enter a new Location";
    }

    protected abstract int[] calculatePP(int[] actualPosition);

    private boolean checkMapBorder(int[] futurePP) { //Check tous les bords de la map 
        return futurePP[0] < Game.getInstance().getWorldMap().getMap().length && futurePP[0] >= 0 && futurePP[1] < Game.getInstance().getWorldMap().getMap()[0].length && futurePP[1] >= 0;
    }
}
