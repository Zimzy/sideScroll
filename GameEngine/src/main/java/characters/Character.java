package characters;

import spriteManagement.Sprite;

import java.awt.*;

public interface Character {
    Sprite getSprite();
    Sprite getSprite(int animationState);
    CharacterType getType();
    void update();
    void draw(Graphics g);
}
