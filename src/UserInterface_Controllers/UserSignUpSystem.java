package UserInterface_Controllers;

import Users.Customer;
import Users.CustomerManager;
import Users.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserSignUpSystem {
    // Constants for text color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";


    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public CustomerManager start() throws IOException {
        String name;
        Double money;
        String input;
        boolean validMoney;
        CustomerManager customerManager;

        System.out.println(ANSI_PURPLE + "Create an account:\n" + ANSI_RESET +
                "Username:");
        name = br.readLine();
        do {
            System.out.print("Money in your account in the format XX.YY (ie. $23.25) between $0.00-$999.99:\n" +
                    "$");
            input = br.readLine();
            validMoney = input.matches("^[0-9]{1,3}.[0-9][0-9]$");
            if (!validMoney) {
                System.out.println(ANSI_RED + "This is not in the format XX.YY or is not between $0.00-$999.99!\n" +
                        ANSI_RESET);
            }
        } while(!validMoney);

        money = Double.parseDouble(input);

        customerManager = new CustomerManager(name, money);

        return customerManager;
    }


}
