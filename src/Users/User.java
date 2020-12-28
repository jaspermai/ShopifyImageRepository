package Users;

import Products.Product;

import java.util.*;

public abstract class User {
    private String name;
    private Double money;

    public String getName() {
        return name;
    }

    public Double getMoney() {
        return money;
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
