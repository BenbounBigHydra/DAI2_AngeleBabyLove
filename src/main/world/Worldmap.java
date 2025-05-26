package main.world;

import java.util.ArrayList;
import java.util.List;

public class Worldmap {

    private int[] playerPosition;
    private Location[][] map;

    public Worldmap() {
        //Crée la Map
        this.map = new Location[3][3];

        //Crée et insère les Location dans la map
        //(pour le moment elles sont normalisées pour tester le programme)
        map[0][0] = new Location("Garden", "The house's garden", null, null);
        map[0][0].unlock();
        map[0][1] = new Location("Garden", "The house's garden", null, null);
        map[0][1].unlock();
        map[0][2] = new Location("Garden", "The house's garden", null, null);
        map[0][2].unlock();
        map[1][0] = new Location("Garden", "The house's garden", null, null);
        map[1][0].unlock();
        map[1][1] = new Location("House", "The house", null, null);
        map[1][2] = new Location("Cafeteria", "The Gertrude's Cafeteria", null, new Key("The Cafeteria's key"));
        map[1][2].unlock();
        map[2][0] = new Location("School", "The building lobby", null, null);
        map[2][0].unlock();
        map[2][1] = new Location("Court", "The concrete courtyard", null, null);
        map[2][1].unlock();
        map[2][2] = new Location("Court", "The concrete courtyard", null, null);
        map[2][2].unlock();
        
        List<Item> toAdd = new ArrayList<>();
        toAdd.add(map[1][1].getRequiredKey());
        map[2][2].addItems(toAdd);

        //Défini la position du player
        playerPosition = new int[2];
        playerPosition[0] = 0;
        playerPosition[1] = 0;
    }

    public int[] getPP() {
        return this.playerPosition;
    }

    public void setPP(int x, int y) {
        playerPosition[0] = x;
        playerPosition[1] = y;
    }

    public Location[][] getMap() {
        return this.map;
    }
}
