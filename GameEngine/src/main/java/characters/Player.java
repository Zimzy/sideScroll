package characters;

import spriteManagement.Sprite;

public abstract class Player implements Entity {

    @Override
    public Sprite getSprite() {
        return null;
    }

    @Override
    public Sprite getSprite(int animationState) {
        return null;
    }

    @Override
    public CharacterType getType() {
        return null;
    }

    abstract public void postKeyDown(int keyCode);

    abstract public void postKeyUp(int keyCode);
}
