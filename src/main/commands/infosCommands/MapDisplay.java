package main.commands.infosCommands;

import main.Game;
import utils.Array2Dprinter;
import utils.Color;
import utils.Style;

public class MapDisplay extends InfosCommand {

    public MapDisplay(String descriptionTransfer, String actionTransfer) {
        super(descriptionTransfer, actionTransfer);
        Array2Dprinter.setGrayedOutStyle(Style.ITALIC, Color.RED, Color.BLACK);
        Array2Dprinter.setHighlightStyle(Style.BOLD, Color.GREEN, Color.BLACK);
    }

    @Override
    protected String executeCommand() {
        return Array2Dprinter.print2DArray(Game.getInstance().getWorldMap().getMap(), Game.getInstance().getWorldMap().getPP()[0], Game.getInstance().getWorldMap().getPP()[1]);
    }

}
