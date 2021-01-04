package Users;

import Products.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{


    public Customer(String name, Double money) {
        super(name, money);
    }

    public UserType getType() {
        return UserType.CUSTOMER;
    }




}
