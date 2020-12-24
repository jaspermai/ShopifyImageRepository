package Users;

import Products.Product;

import java.util.*;

public abstract class User {
    private String name;
    private Double money;
    private List<Product> collection;

    public String getName() {
        return name;
    }

    public Double getMoney() {
        return money;
    }

    public List<Product> getCollection(){
        return collection;
    }

    public abstract UserType getType();
}
