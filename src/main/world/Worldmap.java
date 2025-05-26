package main.world;

import java.util.ArrayList;
import java.util.List;

public class Worldmap {

    private int[] playerPosition;
    private Location[][] map;

    public Worldmap() {
        //Crée la Map
        this.map = new Location[3][3];

        //Crée les item pour les Locations
        //Créer les clés
        Key keyChill = new Key("The chill's key");
        Key keyCafet = new Key("The Cafeteria's key");
        //Créer le puzzle 1 et ajouter les clés
        List<Item> reward = new ArrayList<>();
        reward.add(keyChill);
        Puzzle puzzleOfHiddenKey = new Puzzle("Coffee machine", "You just found the key of the Chill.", reward);
        //Créer le puzzle 2 et ajouter les clés
        reward.clear();
        reward.add(keyCafet);
        Puzzle puzzleOfSteveHour = new Puzzle("7", "Oh thank you for your help! I was going to be late for my non-existent class. For your information, I saw Léo leaving a letter for Jerem in the cafeteria. You should pick it up before he finds it. ", reward);
        //Créer les lettres
        Letter letterSteve = new Letter("A letter smelling fish", "Hello there ! I ave a lesson soon but I have no idea wshat time it is. Could you tell me, I lost my phone and I'm currently working on...well nothing but...you see");
        Letter letterLeo = new Letter("A well folded letter", "Hey Jerem ! I left the key of the chill hidden in our favourite machine of the cafeteria. You can grab it next time.");

        //Crée et insère les Location dans la map
        //(pour le moment elles sont normalisées pour tester le programme)
        map[0][0] = new Location("School", "The working place. Steve is sit in a corner doing anything but work.", puzzleOfSteveHour, null);
        map[0][0].unlock();
        map[0][1] = new Location("Chill", "The best place on earth", null, keyChill);
        map[0][2] = new Location("Cafeteria", "The place to eat sweets and drink lots of coffee", puzzleOfHiddenKey, null);
        map[0][2].unlock();
        map[1][0] = new Location("School", "The building lobby", null, null);
        map[1][0].unlock();
        map[1][1] = new Location("Court", "The shadow of the majestic fountain can be seen on the 7", null, null);
        map[1][1].unlock();
        map[1][2] = new Location("Cafeteria", "The Gertrude's Cafeteria", null, keyCafet);
        map[1][2].addItems(letterLeo);
        map[2][0] = new Location("School", "The building lobby", null, null);
        map[2][0].unlock();
        map[2][1] = new Location("Court", "The concrete courtyard", null, null);
        map[2][1].unlock();
        map[2][2] = new Location("Court", "The concrete courtyard", null, null);
        map[2][2].unlock();
        map[2][2].addItems(letterSteve);

        //Défini la position du player
        playerPosition = new int[2];
        playerPosition[0] = 2;
        playerPosition[1] = 2;
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
