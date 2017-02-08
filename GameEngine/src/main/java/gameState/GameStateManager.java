package gameState;

import characters.Entity;

public enum GameStateManager {
    GAME_STATE_MANAGER;

    public void loadLevel(){};

    public void gameUpdate(Entity entity) {
        entity.update();
    };
}
