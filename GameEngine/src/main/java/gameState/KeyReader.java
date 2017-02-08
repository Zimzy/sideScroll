package gameState;

import events.EventSingleton;
import events.GameOverEvent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class KeyReader extends KeyAdapter {

    private Set<Integer> exitControls;

    public KeyReader() {
        exitControls = new HashSet<>();
        exitControls.add(KeyEvent.VK_ESCAPE);
        exitControls.add(KeyEvent.VK_Q);
        exitControls.add(KeyEvent.VK_END);
        exitControls.add(KeyEvent.VK_C &  KeyEvent.CTRL_MASK);
    }

    public void keyPressed (KeyEvent e){
        if (exitControls.contains(e.getKeyCode())){
            EventSingleton.OTTO.getEventBus().post(new GameOverEvent());
        } else {
            GameStateManager.GAME_STATE_MANAGER.postKeyDown(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        GameStateManager.GAME_STATE_MANAGER.postKeyUp(e.getKeyCode());
    }
}