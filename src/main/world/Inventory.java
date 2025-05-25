package main.world;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Item> listItemInInventory = new ArrayList<>();

    public List<Item> getListItemInInventory() {
        return listItemInInventory;
    }

    public void addItem(Item i) {
        listItemInInventory.add(i);
    }

    public void removeItem(Item i) {
        listItemInInventory.remove(i);
    }
}
