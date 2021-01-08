package Users;

import Products.Product;

import java.util.*;

public abstract class User {
    private String name;
    private Double money;

    public User(String name, Double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public Double getMoney() {
        return this.money;
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
