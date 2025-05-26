package main.world;

import java.util.ArrayList;
import java.util.List;
import main.Main;

public class Puzzle {

    private String solution;
    private String saidWhenResolved;
    private List<Item> reward;

    public Puzzle(String solutionT, String saidWhenResolvedT, List<Item> rewardT) {
        this.solution = Main.normalizeString(solutionT);
        this.saidWhenResolved = saidWhenResolvedT;
        this.reward = new ArrayList<>();
        this.reward.addAll(rewardT);
    }

    public String getSaidWhenResolved() {
        return saidWhenResolved;
    }

    public List<Item> getReward() {
        return reward;
    }

    public String getSolution() {
        return solution;
    }

}
