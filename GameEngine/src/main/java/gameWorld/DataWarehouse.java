package gameWorld;

import characters.Enemy;
import characters.Player;
import characters.PlayerControlManager;

import java.util.List;

public enum DataWarehouse {
    DATA_WAREHOUSE;
    private ActiveLevel level;
    private PlayerControlManager playerControlManager;

    DataWarehouse() {;
    }

    public List<Player> getActivePlayers() {
        return level.getActivePlayers();
    }

    public List<Enemy> getEnemiesOnScreen() {
        return level.getEnemiesOnScreen();
    }

    public void loadLevel(Level level){
        this.level = new ActiveLevel();
        this.level.loadLevel(level);
    };
}