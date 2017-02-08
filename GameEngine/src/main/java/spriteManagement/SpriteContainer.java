package spriteManagement;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public enum SpriteContainer {
    SPRITE_CONTAINER;

    private int scaleWidth;
    private int scaleHeight;

    private Map<String, Sprite> spriteMap = new HashMap<>();

    public Sprite getSprite (String spriteFileReference) {
        return spriteMap.get(spriteFileReference);
    }

    public void purgeContainer() {
        spriteMap.clear();
    }

    public void setWidth(int width) {
        scaleWidth = (int)((32.0/640.0)*width);
        if (scaleWidth%32>0) {
            scaleWidth += 32 - (scaleWidth % 32);
        }
    }

    public void setHeight(int height) {
        scaleHeight = (int)((32.0/480.0)*height);
        scaleHeight += 32-(scaleHeight%32);
    }

    public void storeInContainer(String animation, BufferedImage sourceImage) {
        // create an accelerated image of the right size to store our sprite in
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        Image image = gc.createCompatibleImage(sourceImage.getWidth(),sourceImage.getHeight(),Transparency.BITMASK);

        // draw our source image into the accelerated image
        image.getGraphics().drawImage(sourceImage,0,0,null);
        BufferedImage tImage = (BufferedImage) image;
        tImage = new BufferedImage(tImage.getWidth(), tImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D gt = tImage.createGraphics();
        //System.out.println("Starting drawTImage");
        gt.setComposite(AlphaComposite.Src);
        gt.drawImage((BufferedImage) image, null, 0, 0);
        gt.dispose();
        for(int i = 0; i < tImage.getHeight(); i++) {
            for(int j = 0; j < tImage.getWidth(); j++) {
                //System.out.println("Want 0xFF69B4. Got " + tImage.getRGB(j, i));
                if(tImage.getRGB(j, i) == -38476)
                {
                    //System.out.println("Creating transparent pixel");
                    tImage.setRGB(j, i, 0x8F1C1C);
                }
            }
        }

        BufferedImage after = new BufferedImage(scaleWidth, scaleHeight, BufferedImage.TYPE_INT_RGB);

        Graphics g = after.createGraphics();
        g.drawImage(tImage, 0, 0, scaleWidth, scaleHeight, null);
        g.dispose();

        Sprite sprite = new Sprite(after);
        spriteMap.put(animation,sprite);
    }
}
