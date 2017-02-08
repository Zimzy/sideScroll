package gameWorld;

import characters.Entity;
import characters.CharacterType;

import java.util.Map;

public interface EntityCollection {
    public Map<CharacterType, Entity> getCharacters();
}
