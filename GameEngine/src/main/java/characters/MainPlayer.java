package characters;


import spriteManagement.Sprite;
import spriteManagement.SpriteContainer;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MainPlayer extends Player {

    private int step = 0;
    private int positionX = 100;
    private int positionY = 200;
    private boolean walkright = false;
    private boolean walkleft = false;

    private String spriteSheet;

    private PlayerControlManager playerControlManager;


    public MainPlayer() {
        spriteSheet = this.getClass().getResource("/NPCSprite.PNG").toString().replace("file:", "");
        loadSpritesIntoContainer();
        playerControlManager = new PlayerControlManager();
    }

    @Override
    public void loadSpritesIntoContainer() {
    }

    @Override
    public void update() {
        if (walkright) {
            positionX += 8;
        }
        if (walkleft){
             positionX -= 8;
        }
    }



    public void draw(Graphics g) {
        Sprite sprite = SpriteContainer.SPRITE_CONTAINER.getSprite(spriteSheet);
        Graphics2D g2d = (Graphics2D) g;

        if (sprite != null && sprite.getImage() != null) {
            g2d.drawImage(sprite.getImage().getSubimage(step * 32, 32 * 3, 32, 32), positionX, positionY, null);
        }

    }

    public void postKeyDown(int keyCode) {
        playerControlManager.setButtonPressed(keyCode);
        if (keyCode == KeyEvent.VK_D) {
            walkright = true;
        }
        if (keyCode == KeyEvent.VK_A)  {
            walkleft = true;
        }
    }

    public void postKeyUp(int keyCode) {
        playerControlManager.setButtonReleased(keyCode);
        if (keyCode == KeyEvent.VK_D) {
            walkright = false;
        }
        if (keyCode == KeyEvent.VK_A)  {
            walkleft = false;
        }
    }



}
