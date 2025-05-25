package main.world;

import java.util.List;

public class Puzzle {

    private String solution;
    private List<Item> reward;

    public Puzzle(String solutionT, List<Item> rewardT) {
        this.solution = solutionT;
        this.reward = rewardT;
    }

    public List<Item> getReward() {
        return reward;
    }

    public String getSolution() {
        return solution;
    }

}
