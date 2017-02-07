package gameState;

import events.EventSingleton;
import events.GameOverEvent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyReader extends KeyAdapter {
    public void keyPressed (KeyEvent e){
        int keyCode = e.getKeyCode();
        if ((keyCode == KeyEvent.VK_ESCAPE) ||
                (keyCode == KeyEvent.VK_Q) ||
                (keyCode == KeyEvent.VK_END) ||
                ((keyCode == KeyEvent.VK_C) && e.isControlDown())) {
            EventSingleton.OTTO.getEventBus().post(new GameOverEvent());
        }
    }


}