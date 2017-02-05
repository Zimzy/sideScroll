package gameState;

import com.google.common.eventbus.EventBus;
import events.GameOverEvent;
import events.JFrameReadyEvent;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GameJFrame extends JFrame{
    public GameJFrame() {
        JFrame gameFrame = new JFrame("Sample Frame");
        gameFrame.setSize(640, 480);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);

        setFocusable(true);
        requestFocus( ); // JPanel now receives key events
        readyForTermination( );
    }

    private void readyForTermination( )
    {
        addKeyListener( new KeyAdapter( ) {
            // listen for esc, q, end, ctrl-c
            public void keyPressed(KeyEvent e)
            { int keyCode = e.getKeyCode( );
                if ((keyCode == KeyEvent.VK_ESCAPE) ||
                        (keyCode == KeyEvent.VK_Q) ||
                        (keyCode == KeyEvent.VK_END) ||
                        ((keyCode == KeyEvent.VK_C) && e.isControlDown( )) ) {
                    new EventBus().post(new GameOverEvent());
                }
            }
        });
    }

    @Override
    public void addNotify() {
        super.addNotify();
        new EventBus().post(new JFrameReadyEvent());
    }
}
