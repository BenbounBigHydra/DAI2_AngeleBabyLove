package main.world;

public abstract class Item {

    private String descritpion;

    public Item(String desc) {
        this.descritpion = desc;
    }

    public String getDescritpion() {
        return descritpion;
    }
}
