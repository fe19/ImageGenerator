import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ImageGenerator {

    int IMAGE_HEIGHT = 500;
    int IMAGE_WIDTH = 1000;
    String IMAGE_NAME = "Grundriss";
    String FILE_EXTENSION = "jpg";
    String PATH = ".";
    int FACTOR_M_IN_PIXEL = 30;
    int MARGIN_IN_PIXEL = 50;

    public void generateImage()  {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Length:");
        //int length = scanner.nextInt();
        int widthInM = 20;

        System.out.println("Width:");
        //int width = scanner.nextInt();
        int heightInM = 10;

        System.out.println("Rooms:");
        //int nbrRooms = scanner.nextInt();
        int nbrRooms = 2;

        BufferedImage bufferedImage = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.white);
        graphics2D.drawString("Grundriss für " + nbrRooms + " Zimmer mit " + widthInM * heightInM + "m^2", 20, 20);
        //g2d.fillOval(0, 0, 5, 5);
        graphics2D.drawRect(MARGIN_IN_PIXEL, MARGIN_IN_PIXEL, MARGIN_IN_PIXEL + widthInM * FACTOR_M_IN_PIXEL, MARGIN_IN_PIXEL + heightInM * FACTOR_M_IN_PIXEL);
        graphics2D.dispose();

        File file = new File(PATH + File.separator + IMAGE_NAME + "." + FILE_EXTENSION);

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

    private void drawGroundplan() {

    }

}
