package main.world;

import java.util.Map;

public class TeleportationCrystal extends Item {

    private static TeleportationCrystal instance;
    private static Map<Location, int[]> locationList = new java.util.HashMap<>();

    private TeleportationCrystal(String description) {
        super(description);
    }

    public void addLocationToList(Location location, int x, int y) {
        int[] coordinates = new int[]{x, y};
        locationList.put(location, coordinates);
    }

    public static TeleportationCrystal getInstance() {
        if (instance == null) {
            instance = new TeleportationCrystal("This item allows you to teleport to any location you have already visited.");
        }
        return instance;
    }

    public Map<Location, int[]> getLocationList() {
        return locationList;
    }
}
