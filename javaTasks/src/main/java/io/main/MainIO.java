package io.main;

import io.actions.AddToFile;
import io.actions.ReadFile;
import io.model.Movie;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainIO {
    public static void main(String[] args) {
        String argument = "";
        for (String arg : args) {
            argument += arg;
        }
        File file = new File(argument);
        if (file.exists() && file.isFile()) {
            ReadFile readFile = new ReadFile();
            readFile.read(file);
        } else {
            Movie fistfulOfDollars = new Movie("Fistful of Dollars.avi");
            Movie goodBadUgly = new Movie("The Good, the Bad and the Ugly.avi");
            Movie rambo = new Movie("First Blood.avi");
            Movie predator = new Movie("Predator.avi");
            Movie killbill = new Movie("Kill Bill.avi");
            List<Movie> westerns = new ArrayList<>(Arrays.asList(fistfulOfDollars, goodBadUgly));
            List<Movie> actions = new ArrayList<>(Arrays.asList(rambo, predator, killbill));
            AddToFile addToFile = new AddToFile();
            addToFile.addToFile(westerns, actions, argument);
        }
    }
}
