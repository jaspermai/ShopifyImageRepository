package Users;

import Products.Product;

import java.util.*;

public abstract class User {
    private String name;
    private Double money;
    private List<Product> collection;

    public User(String name, Double money) {
        this.name = name;
        this.money = money;
        this.collection = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public Double getMoney() {
        return this.money;
    }

    public List<Product> getCollection() {
        return this.collection;
    }

    public boolean addMoney(Double amount) {
        this.money = this.money + amount;
        return true;
    }

    public boolean deductMoney(Double amount) {
        if(this.money - amount < 0) {
            return false;
        }
        else{
            this.money = this.money - amount;
            return true;
        }
    }

    public abstract UserType getType();
}
