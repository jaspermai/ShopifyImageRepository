package UserInterface_Controllers;

import CustomerImages.CustomerWriter;
import Products.Product;
import Store.Store;
import Users.CustomerManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GallerySystem {
    // Constants for text color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001b[36m";

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void start(Store store, CustomerManager customerManager) throws IOException {
        List<String> options;
        String choice;
        boolean menuOption;
        boolean menuOption2;
        CustomerWriter customerWriter = new CustomerWriter();


        // View Gallery
        System.out.println(ANSI_PURPLE + "View the gallery of images in the store:" + ANSI_RESET);
        System.out.print(ANSI_CYAN);
        store.productManager.printProductTitles();
        System.out.print(ANSI_RESET);

        options = new ArrayList<>(Arrays.asList("0", "9"));
        do {
            System.out.println("\nPlease choose between:\n" +
                    "0: Buy an Image\n" +
                    "9: Return to Main Menu");
            choice = br.readLine();
            menuOption = options.contains(choice);
            if (!menuOption) {
                System.out.println(ANSI_RED + "That is not one of the options!" + ANSI_RESET);
            }
        } while(!menuOption);

        options = store.productManager.getProductTitles();
        if(choice.equals("0")) {
            if(options.size() == 0) {
                System.out.println(ANSI_RED + "There are no images in the store! Perhaps you would like to " +
                        "upload the first one." + ANSI_RESET);
            }
            else {
                do {
                    System.out.println("\nPlease choose the image you would like to buy or '.home' to return back to " +
                            "main menu:");
                    choice = br.readLine();
                    menuOption2 = options.contains(choice);
                    if(choice.equals(".home")) {
                        return;
                    }
                    else if (!menuOption2) {
                        System.out.println(ANSI_RED + "That is not one of the options!" +
                                " Here are the images in the store (or '.home' to return back to main menu):");
                        System.out.print(ANSI_CYAN);
                        store.productManager.printProductTitles();
                        System.out.println(ANSI_RESET);
                    }
                } while (!menuOption2);

                // At this point, we know that choice is a valid product option
                // Check if customer has enough money
                Double productPrice = store.productManager.getProduct(choice).getPrice();

                if (productPrice > customerManager.getMoney()) {
                    System.out.println(ANSI_RED + "You do not have enough money in your account to purchase this item!"
                    + ANSI_RESET);
                }
                else {
                    // Remove from store, add to customer, remove money from customer, add to customer local file
                    Product product = store.productManager.removeProduct(choice);
                    customerManager.buyProduct(choice, product);
                    customerWriter.writeJPGToCustomerFile(product.getFilePath(),
                            customerManager.productManager.numProducts());
                    System.out.println(ANSI_CYAN + "Cheers, you have purchased " + ANSI_PURPLE + choice + ANSI_CYAN +
                            "! The image should now be in your CustomerImages folder." + ANSI_RESET);
                }

            }
        }

    }

}
