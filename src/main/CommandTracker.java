package main;

import java.util.ArrayList;
import java.util.List;

public class CommandTracker {

    private List<String> ct = new ArrayList<>();

    public List<String> getCt() {
        return ct;
    }

    public void addCommand(String command) {
        this.ct.add(command);
    }
}
