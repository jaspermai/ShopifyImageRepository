package Users;

/**
 * The possible Users in the program
 */
public enum UserType {
    CUSTOMER("Customer");

    private String type;

    UserType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }



}
