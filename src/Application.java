import UserInterface_Controllers.RepositorySystem;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Application {
    public static void main(String[] args) throws IOException {
        RepositorySystem repositorySystem = new RepositorySystem();
        repositorySystem.start();

//        File file = new File("src/LocalImages/shopify.jpg");
//
//        BufferedImage image = null;
//
//        try
//        {
//            image = ImageIO.read(file);
//
//            ImageIO.write(image, "jpg", new File("src/CustomerImages/shopify.jpg"));
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
    }
}
