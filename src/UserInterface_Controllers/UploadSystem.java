package UserInterface_Controllers;

import Products.Image;
import Products.Product;
import Store.Store;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UploadSystem {
    // Constants for text color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001b[36m";

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void start(Store store) throws IOException {
        String title;
        String filePath;
        String input;
        Double price;
        List<String> hashtags = new ArrayList<>();

        boolean validPrice;
        boolean validFilePath = false;

        int hashtagCount = 0;
        boolean moreHashtags = true;

        List<String> options = new ArrayList<>(Arrays.asList("1", "2"));
        boolean menuOption;

        // Title of image
        System.out.println(ANSI_PURPLE + "Upload an image:\n" + ANSI_RESET +
                "Image Title:");
        title = br.readLine();

        // Price of image
        do {
            System.out.print("Price of the image in the format XX.YY (ie. $12.99) between $0.00-$999.99:\n" +
                    "$");
            input = br.readLine();
            validPrice = input.matches("^[0-9]{1,3}[.][0-9][0-9]$");
            if (!validPrice) {
                System.out.println(ANSI_RED + "This is not in the format XX.YY or is not between $0.00-$999.99!\n" +
                        ANSI_RESET);
            }
        } while(!validPrice);

        price = Double.parseDouble(input);

        // Hashtags for image
        System.out.println("Feel free to add hashtags that best describe your image, up to a maximum of 5 hashtags.");
        do {
            System.out.print("You currently have " + ANSI_CYAN + hashtagCount + ANSI_RESET + " hashtags. Enter a " +
                            "hashtag or '.done' if you have no more hashtags to add.\n" + "#");
            input = br.readLine();
            if(input.equals(".done")) {
                moreHashtags = false;
            }
            else {
                hashtags.add(input);
                hashtagCount++;
                if (hashtagCount >= 5) {
                    moreHashtags = false;
                }
            }
        } while(moreHashtags);

        // Check for valid file path
        System.out.println("File path for image:");
        do {
            input = br.readLine();
            filePath = input;
            validFilePath = true;

        } while(!validFilePath);

        // Summary

        Product newProduct = new Image(title, price, hashtags, filePath);
        newProduct.printSummary();

        // Confirm Yes or No
        do {
            System.out.println("\nDo you want to confirm this upload?\n" +
                    "1: Yes, confirm upload\n" +
                    "2: No, return to main menu");
            input = br.readLine();
            menuOption = options.contains(input);
            if (!menuOption) {
                System.out.println(ANSI_RED + "That is not one of the options!" + ANSI_RESET);
            }
        } while(!menuOption);

        if(input.equals("1")) {
            store.productManager.addProduct(title, newProduct);
        }
    }

}
