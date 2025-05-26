package main.world;

public abstract class Item {

    private String description;

    public Item(String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return description;
    }
}
