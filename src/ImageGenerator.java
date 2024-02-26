import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ImageGenerator {

    String PATH = "./images";

    String FILE_EXTENSION = "jpg";

    public void generateImage()  {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Lenght:");

        //int lenght = scanner.nextInt();
        int lenght = 20;

        System.out.println("Width:");

        //int width = scanner.nextInt();
        int width = 10;

        BufferedImage bufferedImage = new BufferedImage(width, lenght, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        g2d.setColor(Color.white);
        g2d.drawString("Image Generator", 5, 5);
        //g2d.fillOval(0, 0, 5, 5);
        g2d.dispose();

        //File file = new File(PATH + File.separator + "example" + "." + FILE_EXTENSION);
        File file = new File("example" + "." + FILE_EXTENSION);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            ImageIO.write(bufferedImage, "jpg", file);
            System.out.println("Write image to " + file.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
