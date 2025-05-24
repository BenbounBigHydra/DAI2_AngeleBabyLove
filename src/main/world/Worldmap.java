package main.world;

public class Worldmap {
    private int[] playerPosition = new int[2];
    private Location[][] map;

    public Worldmap() {
        this.map = new Location[3][3];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = new Location("Location n° " + (i + j), "Description de la Location " + (i + j), null, null);
                map[i][j].unlock();
            }
        }
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
