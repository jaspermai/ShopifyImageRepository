package Products;

import java.util.List;

public class Image extends Product {
    private String title;
    private Double price;
    private List<String> hashtags;
    private String filePath;

    public Image(String title, Double price, List<String> hashtags, String filePath) {
        this.title = title;
        this.price = price;
        this.hashtags = hashtags;
        this.filePath = filePath;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public ProductType getType() {
        return ProductType.IMAGE;
    }
}
