package UserInterface_Controllers;

import Store.Store;
import Users.CustomerManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class RepositorySystem {
    // Constants for text color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";

    // Constants for menu options
    private final String QUIT = "9";
    private final String SIGNUP = "0";

    private final String UPLOAD_IMAGE = "0";
    private final String VIEW_GALLERY_BUY_IMAGE = "1";

    private final String BUY_IMAGE = "0";
    private final String BACK_TO_MENU = "9";

    // Initialize managers, launchers
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private Store store;
    private UserSignUpSystem userSignUpSystem;
    private UploadSystem uploadSystem;
    private GallerySystem gallerySystem;
    private CustomerManager currentCustomer;

    public RepositorySystem() {
        init();
    }

    // private void save

    private void quit() {
        System.out.println("Thank you, see you soon!");
        System.exit(0);
    }

    private void init() {
        store = new Store();
        userSignUpSystem = new UserSignUpSystem();
        uploadSystem = new UploadSystem();
        gallerySystem = new GallerySystem();
    }

    public void start() throws IOException {
        String choice;
        boolean menuOption;
        ArrayList<String> options;

        System.out.println(ANSI_PURPLE + "Welcome to THE image repository system, where you can showcase " +
                "your best work or purchase your favourite displays." + ANSI_RESET);

        while(true) {
            options = new ArrayList<>(Arrays.asList("0", "9"));
            do {
                System.out.println("\nPlease choose between:\n" +
                        "0: Sign Up\n" +
                        "9: Quit");

                choice = br.readLine();
                menuOption = options.contains(choice);
                if (!menuOption) {
                    System.out.println(ANSI_RED + "That is not one of the options!" + ANSI_RESET);
                }
            } while (!menuOption);


            switch (choice) {
                case SIGNUP:
                    currentCustomer = userSignUpSystem.start();
                    break;
                case QUIT:
                    this.quit();
            }

            while(true) {
                System.out.print(ANSI_PURPLE + "\nWelcome " + currentCustomer.getName() + ",\n" +
                        "Your current balance is $");
                System.out.printf("%.2f", currentCustomer.getMoney());
                System.out.println("." + ANSI_RESET);

                options = new ArrayList<>(Arrays.asList("0", "1", "9"));
                do {
                    System.out.println("\nPlease choose between:\n" +
                            "0: Upload Image\n" +
                            "1: View Gallery/ Buy Image\n" +
                            "9: Quit");
                    choice = br.readLine();
                    menuOption = options.contains(choice);
                    if (!menuOption) {
                        System.out.println(ANSI_RED + "That is not one of the options!" + ANSI_RESET);
                    }
                } while(!menuOption);

                switch (choice) {
                    case UPLOAD_IMAGE:
                        uploadSystem.start(store);
                        break;
                    case VIEW_GALLERY_BUY_IMAGE:
                        gallerySystem.start(store, currentCustomer);
                        break;
                    case QUIT:
                        this.quit();
                }
            }




        }



    }


}
