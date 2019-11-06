package threads;

import threads.actions.Actions;
import threads.model.Ship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Actions load = Actions.LOADING;
        Actions unload = Actions.UNLOADING;
        List<Ship> shipList = new ArrayList<Ship>(Arrays.asList(
                new Ship("1", 25, 25, unload),
                new Ship("2", 25, 15, load),
                new Ship("3", 25, 0, load),
                new Ship("4", 25, 25, unload),
                new Ship("5", 25, 0, load)
        ));
        AtomicInteger harborCapacity = new AtomicInteger(50);
        PierThread firstPier;
        PierThread secondPier = null;
        PierThread thirdPier = null;
        firstPier = new PierThread(shipList.get(0), harborCapacity, "first pier");
        firstPier.start();
        int i = 1;
        while (i < shipList.size()) {
            if (firstPier.getState().toString().equals("RUNNABLE")) {
                if (i == shipList.size()) {
                    break;
                }
                secondPier = new PierThread(shipList.get(i), harborCapacity, "second pier");
                secondPier.start();
                i++;
            }
            if (secondPier != null && secondPier.getState().toString().equals("RUNNABLE")) {
                if (i == shipList.size()) {
                    break;
                }
                thirdPier = new PierThread(shipList.get(i), harborCapacity, "third pier");
                thirdPier.start();
                i++;
            }
            if (thirdPier != null && thirdPier.getState().toString().equals("RUNNABLE")) {
                if (firstPier.getState().toString().equals("RUNNABLE")) {
                    try {
                        firstPier.join();
                        if (i == shipList.size()) {
                            break;
                        }
                        firstPier = new PierThread(shipList.get(i), harborCapacity, "first pier");
                        firstPier.start();
                        i++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    if (i == shipList.size()) {
                        break;
                    }
                    firstPier = new PierThread(shipList.get(i), harborCapacity, "first pier");
                    firstPier.start();
                    i++;
                }
            }
        }
        try {
            firstPier.join();
            secondPier.join();
            secondPier.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Current capacity of harbor: " + harborCapacity.get());
    }
}