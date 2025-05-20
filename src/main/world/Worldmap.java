package main.world;

public class Worldmap {

    private int[] playerPosition = new int[2];
    private Location[][] map;

    public Worldmap(Location[][] loc) {
        map = loc;
    }

    public int[] getPP() {
        return this.playerPosition;
    }

    public void setPP(int x, int y) {
        playerPosition[0] = x;
        playerPosition[1] = y;
    }
}
