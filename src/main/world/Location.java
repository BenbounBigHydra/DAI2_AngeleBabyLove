package main.world;

import java.util.List;

public class Location {
    private String name;
    private String description;
    private boolean unlocked;
    private List<Puzzle> listPuzzles;
    private List<Item> listItems;
    private Key requiredKey;

    public Location(String nameTransfer, String descripionTransfer, List<Puzzle> puzzlesTransfer, Key keyTransfer) {
        this.name = nameTransfer;
        this.description = descripionTransfer;
        this.unlocked = false;
        this.listPuzzles = puzzlesTransfer;
        this.requiredKey = keyTransfer;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean getUnlockedState(){
        return this.unlocked;
    }

    public List<Item> getListItems(){
        return this.listItems;
    }

    public List<Puzzle> getListPuzzle(){
        return this.listPuzzles;
    }

    public void removePuzzle (Puzzle puzzleToRemove) {
        this.listPuzzles.remove(puzzleToRemove);
    }

    public void addItems(List<Item> itemsToAdd) {
        this.listItems.addAll(itemsToAdd);
    }

    public void removeItem (Item itemToRemove) {
        this.listItems.remove(itemToRemove);
    }

    public void unlock() {
        this.unlocked = true;
    }

    public boolean checkKey (Key keyToCheck) {
        return this.requiredKey == keyToCheck;         
        }
    } 

