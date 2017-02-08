package gameWorld;

import characters.Entity;
import characters.CharacterType;
import characters.MainPlayer;

import java.util.Map;

public class ActiveLevel implements EntityCollection{

    private Map<CharacterType, Entity> enemyMap;
    private MainPlayer player;


    public void loadLevel(Level level) {
        player = new MainPlayer();
    }

    @Override
    public Map<CharacterType, Entity> getCharacters() {
        return null;
    }

    public MainPlayer getPlayer() {
        return player;
    }
}
