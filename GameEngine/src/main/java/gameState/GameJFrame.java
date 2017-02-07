package gameState;

import events.EventSingleton;
import events.GameOverEvent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GameJFrame extends JPanel{

    private BufferedImage img;

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
        addKeyListener( new KeyReader());
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        g.dispose();

    }
}