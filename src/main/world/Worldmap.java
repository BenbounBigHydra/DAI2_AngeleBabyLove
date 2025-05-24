package main.world;

public class Worldmap {

    private int[] playerPosition;
    private Location[][] map;

    public Worldmap() {
        //Crée la Map
        this.map = new Location[3][3];

        //Crée et insère les Location dans la map
        //(pour le moment elles sont normalisées pour tester le programme)
        int n = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = new Location("Location n° " + n, "Description de la Location " + n, null, null);
                map[i][j].unlock();
                n++;
            }
        }

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
