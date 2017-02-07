package gameWorld;

import characters.Character;
import characters.CharacterType;
import characters.MainPlayer;

import java.util.Map;

public class ActiveLevel implements EntityCollection{

    private Map<CharacterType, Character> enemyMap;
    private MainPlayer player;


    public void loadLevel(Level level) {
        player = new MainPlayer();
    }

    @Override
    public Map<CharacterType, Character> getCharacters() {
        return null;
    }

    public MainPlayer getPlayer() {
        return player;
    }
}
