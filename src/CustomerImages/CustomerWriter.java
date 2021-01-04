package CustomerImages;

import UserInterface_Controllers.RepositorySystem;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CustomerWriter {
    public void writeJPGToCustomerFile(String input, int num) {
        File file = new File(input);

        BufferedImage image = null;

        try {
            image = ImageIO.read(file);
            String output = "src/CustomerImages/output" + String.valueOf(num) + ".jpg";
            ImageIO.write(image, "jpg", new File(output));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
