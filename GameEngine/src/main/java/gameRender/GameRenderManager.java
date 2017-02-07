package gameRender;

import characters.Character;
import gameState.GameJFrame;

import java.awt.*;

public enum GameRenderManager {
    GAME_RENDER_MANAGER;

    private static GameJFrame gameFrame;

    public void gameRender(Character character) {
        Graphics g = gameFrame.getGraphics();
        character.draw(g);
        gameFrame.paintComponent(g);
    };

    public void initializeView() {
        this.gameFrame = new GameJFrame();
    }
}
