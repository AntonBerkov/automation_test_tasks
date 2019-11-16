package threads;

import threads.actions.Actions;
import threads.exceptions.HarborEmptyException;
import threads.exceptions.HarborFullException;
import threads.exceptions.IllegalCapacityException;
import threads.exceptions.WrongActionException;
import threads.model.Ship;

import java.util.concurrent.atomic.AtomicInteger;

public class PierThread extends Thread {
    private Ship ship;
    private AtomicInteger harborCapacity;
    private String pierName;
    private static final int MAX_HARBOR_CAPACITY = 200;

    public PierThread(Ship ship, AtomicInteger harborCapacity, String pierName) {
        this.ship = ship;
        this.harborCapacity = harborCapacity;
        this.pierName = pierName;
    }

    public void run() {
        System.out.println("Ship " + ship.getName() + " arrived at the " + pierName);
        try {
            shipCheck();
        } catch (IllegalCapacityException | WrongActionException | HarborFullException | HarborEmptyException e) {
            e.printStackTrace();
        }
        System.out.println("Ship " + ship.getName() + " left the " + pierName);
    }

    public void shipCheck() throws IllegalCapacityException, WrongActionException, HarborFullException, HarborEmptyException {
        if ((ship.getCurrentCapacity() < 0) || (ship.getCurrentCapacity() > ship.getMaxCapacity())) {
            throw new IllegalCapacityException
                    ("Current capacity of " + ship.getName() + " should be more than 0 and less than max capacity");
        } else if ((ship.getAction().equals(Actions.LOADING) && (ship.getCurrentCapacity() == 25)) ||
                (ship.getAction().equals(Actions.UNLOADING) && (ship.getCurrentCapacity() == 0))) {
            throw new WrongActionException("Ship " + ship.getName() +
                    "can't be loaded or unloaded because of " + ship.getCurrentCapacity() + " " + ship.getAction());
        } else shipLoadAndUnload();
    }

    public void shipLoadAndUnload() throws HarborFullException, HarborEmptyException {
        String action = ship.getAction().toString();
        switch (action) {
            case "UNLOADING": {
                if ((harborCapacity.get() + ship.getCurrentCapacity()) > MAX_HARBOR_CAPACITY) {
                    throw new HarborFullException("The harbor is full");
                } else {
                    harborCapacity.addAndGet(ship.getCurrentCapacity());
                    System.out.println("Ship " + ship.getName() + " is unloaded");
                }
            }
            break;
            case "LOADING": {
                int load = ship.getMaxCapacity() - ship.getCurrentCapacity();
                if ((harborCapacity.get() - load) < 0) {
                    throw new HarborEmptyException("Harbor is empty");
                } else {
                    harborCapacity.addAndGet(-load);
                    System.out.println("Ship " + ship.getName() + " is loaded");
                }
            }
            break;
        }
    }

}
