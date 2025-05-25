package main.world;

public class Player {

    private Inventory inventory;

    public Player() {
        inventory = new Inventory();
        /*inventory.addItem(new Letter("TEST LETTRE 1", "CONTENU LETTRE 1"));
        inventory.addItem(new Letter("TEST LETTRE 2", "CONTENU LETTRE 2"));
        inventory.addItem(new Letter("TEST LETTRE 3", "CONTENU LETTRE 3"));
        inventory.addItem(new Letter("TEST LETTRE 4", "CONTENU LETTRE 4"));*/
    }

    public Inventory getInventory() {
        return inventory;
    }
}
