package Products;

import java.util.List;

public abstract class Product {
    private String title;
    private Double price;
    private List<String> hashtags;

    public String getTitle() {
        return this.title;
    }

    public Double getPrice() {
        return this.price;
    }

    public List<String> getHashtags() {
        return this.hashtags;
    }

    public abstract ProductType getType();

}
