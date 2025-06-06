package main.world;

import java.util.ArrayList;
import java.util.List;

public class Worldmap {

    private int[] playerPosition;
    private Location[][] map;

    public Worldmap() {
        //Crée la Map
        this.map = new Location[4][3];

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
        Puzzle puzzleOfSteveHour = new Puzzle("seven", "Oh thank you for your help! I was going to be late for my non-existent class. For your information, I saw Léo leaving a letter for Jerem in the cafeteria. You should pick it up before he finds it. The cafeteria is closed, but here's the access badge. You should take it with you. ", reward);
        //Créer les lettres
        Letter letterSteve = new Letter("A letter smelling fish", "Hello there! I have an appointment soon, but I have no idea what time it is because I lost my phone again. Can you help me out? I'm currently working on... well, not much, but I'm pretending to. Thanks for your help! -Steve");
        Letter letterLeo = new Letter("A well folded letter", "Hey Jerem ! I left the key of the chill hidden in our favourite machine of the cafeteria. You can grab it next time. Has anyone seen my dog? She stole my magic teleportation crystal again... -Léo");

        //Crée et insère les Location dans la map
        //(pour le moment elles sont normalisées pour tester le programme)
        map[0][0] = new Location("School", "The place to study. Steve is sitting in a corner. He is pretending to work very well.", puzzleOfSteveHour, null);
        map[0][0].unlock();
        map[0][1] = new Location("Chill", "The best place on earth <3", null, keyChill);
        map[0][2] = new Location("Cafeteria", "The place to eat sweets and drink lots of coffee.", puzzleOfHiddenKey, null);
        map[0][2].unlock();
        map[1][0] = new Location("School", "The building lobby", null, null);
        map[1][0].unlock();
        map[1][1] = new Location("Court", "The shadow of the majestic fountain can be seen on the seven", null, null);
        map[1][1].unlock();
        map[1][2] = new Location("Cafeteria", "The Gertrude's Cafeteria", null, keyCafet);
        map[1][2].addItems(letterLeo);
        map[2][0] = new Location("School", "The building's lobby", null, null);
        map[2][0].unlock();
        map[2][1] = new Location("Court", "The concrete courtyard", null, null);
        map[2][1].unlock();
        map[2][2] = new Location("Court", "The concrete courtyard", null, null);
        map[2][2].unlock();
        map[2][2].addItems(letterSteve);
        map[3][0] = new Location("School", "The building lobby", null, null);
        map[3][0].unlock();
        map[3][1] = new Location("Court", "The courtyard where Nami is sitting. She greets you with her paw.", null, null);
        map[3][1].unlock();
        map[3][2] = new Location("Baleinev room", "The Baleinev room. Raph is sitting on the sofa. You can hear him explaining to a new student that the fountain in the courtyard is a sundial.", null, null);
        map[3][2].unlock();


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
