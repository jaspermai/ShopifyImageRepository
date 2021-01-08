package UserInterface_Controllers;

import Users.CustomerManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionSystem {
    // Constants for text color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001b[36m";

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void start(CustomerManager customerManager) throws IOException {
        System.out.println(ANSI_PURPLE + "Welcome " + ANSI_CYAN + customerManager.getName() + ANSI_PURPLE + " to " +
                "your personal collection." + ANSI_RESET);

        if(customerManager.productManager.numProducts() == 0) {
            System.out.println(ANSI_RED + "\nYou have no products in your collection! Try buying something from the " +
                    "Image Repository.");
        }
        else {
            System.out.println("\nYour collection:");
            System.out.print(ANSI_CYAN);
            customerManager.productManager.printProductTitles();
            System.out.print(ANSI_RESET);
        }

        List<String> options = new ArrayList<>(Arrays.asList("9"));
        String choice;
        boolean menuOption;

        do {
            System.out.println("\nPlease choose between:\n" +
                    "9: Return to Main Menu");
            choice = br.readLine();
            menuOption = options.contains(choice);
            if (!menuOption) {
                System.out.println(ANSI_RED + "That is not one of the options!" + ANSI_RESET);
            }
        } while(!menuOption);
    }
}
