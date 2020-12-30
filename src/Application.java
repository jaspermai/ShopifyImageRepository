import UserInterface_Controllers.RepositorySystem;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {

        // BufferedImage img = ImageIO.read(new File("LocalPhotos/shopify.jpg"));
        RepositorySystem repositorySystem = new RepositorySystem();
        repositorySystem.start();

    }
}
