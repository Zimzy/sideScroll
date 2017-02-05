package nonCharacterObjects;


import spriteManagement.Sprite;

public interface NonCharacterObject {
    Sprite getSprite();
    Sprite getSprite(int animationState);
    NonCharacterObjectTypes getType();
}
