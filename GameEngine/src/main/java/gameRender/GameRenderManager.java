package gameRender;

import characters.Entity;
import gameState.KeyReader;
import gameWorld.DataWarehouse;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public enum GameRenderManager {
    GAME_RENDER_MANAGER;

    private GameJFrame gameFrame;

    private Image dbImage;

    private int scaleWidth;
    private int scaleHeight;
    private int xStartPosition;

    private static final int desiredWidth = 640;
    private static final int desiredHeight = 480;

    Dimension scrDim;

    public void gameRender() {
        Graphics g = gameFrame.getBufferGraphics();
        g.fillRect(0,0, scrDim.width, scrDim.height);

        for (Entity entity : DataWarehouse.DATA_WAREHOUSE.getActivePlayers()) {
            entity.draw(g);
        }

        gameFrame.paintScreen();
    };

    public void initializeView() {
        this.gameFrame = new GameJFrame();
    }

    private void setScaling() {
        float tempScaleX;
        float tempScaleY;
        tempScaleX = (float)scrDim.height;
        tempScaleY = ((float)desiredWidth/(float)desiredHeight)*tempScaleX;
        scaleHeight = (int)tempScaleX;
        scaleWidth = (int)tempScaleY;

        xStartPosition = Math.abs(scrDim.width - scaleWidth)/2;
    }

    private class GameJFrame extends JPanel {

        public GameJFrame() {
            Toolkit tk = Toolkit.getDefaultToolkit();
            scrDim = tk.getScreenSize();

            setBackground(Color.black);
            setPreferredSize(scrDim);

            setScaling();

            this.setFocusable(true);
            this.requestFocusInWindow();
            this.addListener();

            JFrame gameFrame = new JFrame();

            Container c = gameFrame.getContentPane();
            c.setLayout( new BorderLayout() );
            c.add(this, "Center");

//            gameFrame.setBackground(Color.black);
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
                if ((g != null) && (dbImage != null)) {

                    BufferedImage after = new BufferedImage(scaleWidth, scaleHeight, BufferedImage.TYPE_INT_RGB);

                    Graphics g2 = after.createGraphics();
                    g2.drawImage(dbImage, 0, 0, scaleWidth, scaleHeight, null);
                    g2.dispose();

                    g.drawImage(after, xStartPosition, 0, null);

                    Toolkit.getDefaultToolkit().sync();
                    g.dispose();
                    dbImage.flush();
                }
            }
            catch (Exception e)   // quite commonly seen at applet destruction
            { System.out.println("Graphics error: " + e);  }
        }

        public Graphics getBufferGraphics() {
            if (dbImage == null) {
                dbImage = createImage(desiredWidth, desiredHeight);
            }
            return  dbImage.getGraphics();
        }
    }
}