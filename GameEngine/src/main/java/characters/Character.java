package characters;

import spriteManagement.Sprite;

public interface Character {
    Sprite getSprite();
    Sprite getSprite(int animationState);
    CharacterType getType();
}
