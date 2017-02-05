package nonCharacterObjects;


import spriteManagement.Sprite;

public abstract class Obstacles implements NonCharacterObject{
    @Override
    public Sprite getSprite() {
        return null;
    }

    @Override
    public Sprite getSprite(int animationState) {
        return null;
    }

    @Override
    public NonCharacterObjectTypes getType() {
        return null;
    }
}
