package characters;

import spriteManagement.Sprite;

public abstract class Npc implements Entity {
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
}
