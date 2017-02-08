package gameWorld;

import characters.*;

import java.util.LinkedList;
import java.util.List;

public class ActiveLevel{

    private List<Player> activePlayers;
    private List<Enemy> enemiesOnScreen;

    public ActiveLevel() {
        activePlayers = new LinkedList<>();
        enemiesOnScreen = new LinkedList<>();
    }

    public void loadLevel(Level level) {
        activePlayers.add(new MainPlayer());
    }

    public List<Player> getActivePlayers() {
        return activePlayers;
    }

    public List<Enemy> getEnemiesOnScreen() {
        return enemiesOnScreen;
    }

}
