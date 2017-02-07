package characters;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MainPlayer extends Player{

    private int step = 0;
    private boolean reverse = false;
    private int timesReversed = 0;

    @Override
    public void update() {
        if (step == 3) {
            reverse = true;
        } else if (step == 0){
            reverse = false;
            timesReversed++;
        }

        step = reverse ? step - 1 : step + 1;
    }

    public void draw(Graphics g) {

        BufferedImage img;
        try {
            String relativeURL = this.getClass().getResource("/NPCSprite.PNG").toString().replace("file:","");
            img = ImageIO.read(new File(relativeURL));

            img = img.getSubimage(step*32,32*3,32,32);


            Graphics2D g2d = (Graphics2D) g;

            if (img != null)
                g2d.drawImage(img, 8*step, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
