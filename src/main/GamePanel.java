package main;
import gameState.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;


public class GamePanel extends JPanel implements Runnable, KeyListener {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 600;
    public static final int SCALE = 2;
    private GameStateManager gsm;
    private Thread thread;
    private BufferedImage image;
    private Graphics2D g;
    private boolean running;


    public GamePanel() {
        super();
        setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify() {
        super.addNotify();
        if(thread == null) {
            thread = new Thread(this);
            addKeyListener(this);
            thread.start();
        }

    }

    public void init() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        running = true;
        gsm = new GameStateManager();

    }

    @Override
    public void run() {
        System.out.println("Hello World");
        init();

        long lastTime = System.nanoTime();

        System.out.println(lastTime);

        double delta = 0;
        double nsPerTick = 1_000_000_000D/60D; // 1 billion divided by sixty

        while (running) { //
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;

            while(delta >= 1) {
                update();
                delta -= 1;
            }
            draw();
            drawToScreen();
        }
    }

    public void update() {
        gsm.update();
    }

    public void draw() {
        g.setColor(Color.PINK);
        g.fillRect(0,0,WIDTH,HEIGHT);
        gsm.draw(g);
    }

    public void drawToScreen() {
        Graphics g2 = getGraphics();
        g2.drawImage(image, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        Keys.keySet(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Keys.keySet(e.getKeyCode(), false);
    }
}
