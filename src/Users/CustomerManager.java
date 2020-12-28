package Users;

import Products.ProductManager;
import Products.Product;

import java.util.ArrayList;

public class CustomerManager {
    public ProductManager productManager;
    private Customer customer;

    public CustomerManager(String name, Double money) {
        productManager = new ProductManager();
        customer = new Customer(name, money);
    }

    /**
     * Adds Product to CustomerManager's productManager and updates customer's amount of money.
     * Pre-condition: Product and title exist.
     *
     * @param title
     * @param product
     * @return
     */
    public boolean buyProduct(String title, Product product) {
        Double price = product.getPrice();
        if(!customer.deductMoney(price)) {
            return false;
        }
        else {
            this.productManager.addProduct(title, product);
            return true;
        }
    }

}
