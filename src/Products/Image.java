package Products;

import java.util.List;

public class Image extends Product {

    public Image(String title, Double price, List<String> hashtags, String filePath) {
        super(title, price, hashtags, filePath);
    }

    public ProductType getType() {
        return ProductType.IMAGE;
    }


}
