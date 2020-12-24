package Users;

import Products.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{
    private String name;
    private Double money;
    private List<Product> collection;

    public Customer(String name, Double money) {
        this.name = name;
        this.money = money;
        this.collection = new ArrayList<>();
    }

    public UserType getType() {
        return UserType.CUSTOMER;
    }


}
