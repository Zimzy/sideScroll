package characters;


import spriteManagement.Sprite;
import spriteManagement.SpriteContainer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainPlayer extends Player{

    private int step = 0;
    private boolean reverse = false;
    private int timesReversed = 0;



    private String spriteSheet;

    public MainPlayer() {
        spriteSheet = this.getClass().getResource("/NPCSprite.PNG").toString().replace("file:","");
        loadSpritesIntoContainer();
    }

    @Override
    public void loadSpritesIntoContainer() {
        BufferedImage img;
        try {
            img = ImageIO.read(new File(spriteSheet));

            for (int i = 0; i<4; i++)
                SpriteContainer.SPRITE_CONTAINER.storeInContainer("walk"+i,img.getSubimage(i*32,32*3,32,32));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
        Sprite img = SpriteContainer.SPRITE_CONTAINER.getSprite("walk"+step);
            Graphics2D g2d = (Graphics2D) g;

            if (img != null)
                g2d.drawImage(img.getImage(), 100*timesReversed, 100, null);

    }
}
