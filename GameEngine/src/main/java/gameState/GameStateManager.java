package gameState;

import characters.Player;
import gameWorld.DataWarehouse;
import gameWorld.Level;

public enum GameStateManager {
    GAME_STATE_MANAGER;

    public void loadLevel(Level level){
        DataWarehouse.DATA_WAREHOUSE.loadLevel(level);
    };

    public void gameUpdate() {
        for (Player player : DataWarehouse.DATA_WAREHOUSE.getActivePlayers()) {
            player.update();
        }
    };

    public void postKeyDown(int keyCode) {
        for (Player player : DataWarehouse.DATA_WAREHOUSE.getActivePlayers()) {
            player.postKeyDown(keyCode);
        }
    }

    public void postKeyUp(int keyCode) {
        for (Player player : DataWarehouse.DATA_WAREHOUSE.getActivePlayers()) {
            player.postKeyUp(keyCode);
        }
    }
}
