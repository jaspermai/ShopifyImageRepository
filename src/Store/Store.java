package Store;

import Products.ProductManager;

public class Store {
    public ProductManager productManager;

    public Store() {
        productManager = new ProductManager();
    }

    public Store(ProductManager productManager) {
        this.productManager = productManager;
    }
}
