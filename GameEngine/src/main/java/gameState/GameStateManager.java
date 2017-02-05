package gameState;

import javax.swing.*;

/**
 * Created by ezekielbuchheit on 2/5/17.
 */
public enum GameStateManager {
    GAME_STATE_MANAGER;

    private static GameJFrame gameFrame;

    public void initializeView() {
        this.gameFrame = new GameJFrame();
    }


    public void loadLevel(){};

    public void gameUpdate() {};
}
