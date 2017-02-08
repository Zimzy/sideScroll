package gameRender;

import characters.Entity;
import gameState.KeyReader;
import spriteManagement.SpriteContainer;

import javax.swing.*;
import java.awt.*;

public enum GameRenderManager {
    GAME_RENDER_MANAGER;

    private static GameJFrame gameFrame;

    private Image dbImage;

    Dimension scrDim;

    private Image fartImage;

    public void gameRender(Entity entity) {
        Graphics g = gameFrame.getBufferGraphics();
        g.fillRect(0,0, scrDim.width, scrDim.height);
        entity.draw(g);
        gameFrame.paintScreen();
    };

    public void initializeView() {
        this.gameFrame = new GameJFrame();
    }

    private class GameJFrame extends JPanel {

        public GameJFrame() {
            Toolkit tk = Toolkit.getDefaultToolkit();
            scrDim = tk.getScreenSize();

            SpriteContainer.SPRITE_CONTAINER.setWidth(scrDim.width);
            SpriteContainer.SPRITE_CONTAINER.setHeight(scrDim.height);

            setBackground(Color.white);
            setPreferredSize(scrDim);

            this.setFocusable(true);
            this.requestFocusInWindow();
            this.addListener();

            JFrame gameFrame = new JFrame();

            Container c = gameFrame.getContentPane();
            c.setLayout( new BorderLayout() );
            c.add(this, "Center");

            gameFrame.setUndecorated(true);   // no borders or title bar
            gameFrame.setIgnoreRepaint(true);  // turn off all paint events since doing active rendering
            gameFrame.pack();
            gameFrame.setResizable(false);
            gameFrame.setVisible(true);
        }

        private void addListener() {
            addKeyListener( new KeyReader());
        }

        public void paintScreen()
        // use active rendering to put the buffered image on-screen
        {
            Graphics g;
            try {
                g = this.getGraphics();
                if ((g != null) && (dbImage != null))
                    g.drawImage(dbImage, 0, 0, null);

                Toolkit.getDefaultToolkit().sync();
                g.dispose();
                dbImage.flush();
            }
            catch (Exception e)   // quite commonly seen at applet destruction
            { System.out.println("Graphics error: " + e);  }
        }

        public Graphics getBufferGraphics() {
            if (dbImage == null)
                dbImage = createImage(scrDim.width, scrDim.height);
            return  dbImage.getGraphics();
        }
    }
}
