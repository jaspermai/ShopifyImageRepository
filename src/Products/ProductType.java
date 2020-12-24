package Products;

public enum ProductType {
    IMAGE("Image");

    private String type;

    ProductType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }


}
