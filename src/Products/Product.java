package Products;

import java.util.List;

public abstract class Product {
    // Constants for text color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001b[36m";

    private String title;
    private Double price;
    private List<String> hashtags;
    private String filePath;

    public Product(String title, Double price, List<String> hashtags, String filePath) {
        this.title = title;
        this.price = price;
        this.hashtags = hashtags;
        this.filePath = filePath;
    }

    public String getTitle() {
        return this.title;
    }

    public Double getPrice() {
        return this.price;
    }

    public List<String> getHashtags() {
        return this.hashtags;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public abstract ProductType getType();

    public void printSummary() {
        System.out.println("\n" + ANSI_PURPLE + "Summary of the image:" + ANSI_RESET);
        System.out.println("Title: " + ANSI_CYAN + this.title + ANSI_RESET);
        System.out.print("Price: " + ANSI_CYAN);
        System.out.printf("%.2f", this.price);
        System.out.println(ANSI_RESET);
        System.out.print("Hashtags:");
        for(String hashtag: this.hashtags) {
            System.out.print(ANSI_CYAN + " #" + hashtag + ANSI_RESET);
        }
        System.out.println("\nFile Path: " + ANSI_CYAN + this.filePath + ANSI_RESET);
    }

}
