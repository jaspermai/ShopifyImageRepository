package Products;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductManager {
    private HashMap<String, Product> productMap;

    public ProductManager() {
        this.productMap = new HashMap<>();
    }

    public ProductManager(HashMap<String, Product> productMap) {
        this.productMap = productMap;
    }

    /**
     * Constructs a ProductManager given an ArrayList of titles and an ArrayList of Products.
     * Pre-condition: Length of titles == Length of products
     *
     * @param titles
     * @param products
     */
    public ProductManager(ArrayList<String> titles, ArrayList<Product> products) {
        this.productMap = new HashMap<>();
        for(int i = 0; i < titles.size(); i++) {
            productMap.put(titles.get(i), products.get(i));
        }
    }

    public int numProducts() {
        return this.productMap.size();
    }

    public void addProduct(String title, Product product) {
        this.productMap.put(title, product);
    }

    public boolean hasProduct(String title) {
        return this.productMap.containsKey(title);
    }

    /**
     * Removes product with given title.
     * Pre-condition: hasProduct method has first been called.
     *
     * @param title
     * @return
     */
    public Product removeProduct(String title) {
        Product temp = this.productMap.get(title);
        this.productMap.remove(title);
        return temp;
    }

    /**
     * Gets product with given title.
     * Pre-condition: hasProduct method has first been called.
     *
     * @param title
     * @return
     */
    public Product getProduct(String title) {
        return this.productMap.get(title);
    }

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> result = new ArrayList<>();
        for(String title: this.productMap.keySet()) {
            result.add(this.productMap.get(title));
        }
        return result;
    }

    public ArrayList<String> getProductTitles() {
        ArrayList<String> result = new ArrayList<>();
        for(String title: this.productMap.keySet()) {
            result.add(title);
        }
        return result;
    }

    public void printProductTitles() {
        for(String title: this.productMap.keySet()) {
            System.out.print(title + " (Price: ");
            System.out.printf("%.2f", productMap.get(title).getPrice());
            System.out.println(")");
        }
    }
}
