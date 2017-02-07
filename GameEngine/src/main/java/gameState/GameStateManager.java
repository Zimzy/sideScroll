package gameState;

import characters.Character;
import characters.MainPlayer;

import java.awt.*;

public enum GameStateManager {
    GAME_STATE_MANAGER;

    MainPlayer player = new MainPlayer();

    public void loadLevel(){};

    public void gameUpdate(Character character) {
        character.update();
    };
}
