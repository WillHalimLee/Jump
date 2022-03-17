package main;

import entity.Entity;
import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    // Screen Settings

    final int originalTileSize = 16; //16x16 tile
    final int scale = 4;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    public final int maxWorldCol = 14;
    public final int maxWorldRow = 127;

    int FPS =60;

    public TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public CollisionCheck cChecker = new CollisionCheck(this);

    public Player player = new Player(this, keyH);
    //players default position
    private JButton btn;
    public JFrame window;

    public GamePanel(JButton btn, JFrame window){

        this.btn = btn;
        this.window = window;

//        this.setSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

//        musicBtn.setBounds(0, 150, 256, 50);
//        musicBtn.setBackground(new Color(254, 247, 220));
//        musicBtn.setForeground(new Color(234, 92, 43));
//        musicBtn.setFocusable(false);
//        musicBtn.setHorizontalTextPosition(JButton.CENTER);
//        musicBtn.setVerticalTextPosition(JButton.BOTTOM);
//        musicBtn.setFont(new Font("MV Boli", Font.BOLD, 30));
//        musicBtn.setBorderPainted(false);
//        this.add(musicBtn);

    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
            while (gameThread != null) {
                currentTime = System.nanoTime();

                delta += (currentTime - lastTime) / drawInterval;

                lastTime = currentTime;

                if (delta >= 1) {
                    update(); // changes the variables in paintComponent for different animations depending on key input.
                    repaint(); //calls the paintComponent method to redraw  - creates animation
                    delta--;
                }
            }
        }




    // updates the frames
    public void update(){

        player.update(); //calls the update method in player class, allowing character actions
    }

    //main drawing tool
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        tileM.draw(g2);
        player.draw(g2);
        g2.dispose();

        btn.setLocation(450, screenHeight);

    }
}
