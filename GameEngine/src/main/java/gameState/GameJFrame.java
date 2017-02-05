package gameState;

import events.EventSingleton;
import events.GameOverEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GameJFrame extends JPanel{

    public GameJFrame() {

        this.setPreferredSize(new Dimension(640,480));

        JFrame gameFrame = new JFrame("Sample Frame");
        gameFrame.setSize(640, 480);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addListener();

        gameFrame.add(this);
        gameFrame.pack();
        gameFrame.setVisible(true);

        setFocusable(true);
        requestFocusInWindow();
    }

    private void addListener() {
        addKeyListener( new KeyAdapter() {
            // listen for esc, q, end, ctrl-c
            public void keyPressed (KeyEvent e){
                int keyCode = e.getKeyCode();
                if ((keyCode == KeyEvent.VK_ESCAPE) ||
                        (keyCode == KeyEvent.VK_Q) ||
                        (keyCode == KeyEvent.VK_END) ||
                        ((keyCode == KeyEvent.VK_C) && e.isControlDown())) {
                    EventSingleton.OTTO.getEventBus().post(new GameOverEvent());
                }
            }
        });
    }
}