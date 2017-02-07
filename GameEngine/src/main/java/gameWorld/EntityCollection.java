package gameWorld;

import characters.Character;
import characters.CharacterType;

import java.util.Map;

public interface EntityCollection {
    public Map<CharacterType, Character> getCharacters();
}
