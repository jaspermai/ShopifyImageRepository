import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
	    BufferedImage image = ImageIO.read(new File("LocalPhotos/shopify.png"));
    }
}
