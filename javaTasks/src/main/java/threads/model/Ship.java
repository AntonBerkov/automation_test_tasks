package threads.model;

import threads.actions.Actions;

public class Ship {
    private String name;
    private int maxCapacity;
    private int currentCapacity;
    private Actions action;

    public Ship(String name, int maxCapacity, int currentCapacity, Actions action) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public Actions getAction() {
        return action;
    }
}
