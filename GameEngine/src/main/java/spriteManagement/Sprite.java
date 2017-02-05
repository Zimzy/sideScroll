package spriteManagement;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by ezekielbuchheit on 2/5/17.
 */
public class Sprite {

    private BufferedImage image;

    public Sprite(BufferedImage image)
    {
        this.image = image;
    }

    public BufferedImage getImage(){return image;}

    public void draw(Graphics graphics, int x, int y) {
        graphics.drawImage(image, x, y, null);
    }
}
