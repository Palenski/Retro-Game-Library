package PongTest;

import java.awt.Color;

import javax.swing.JPanel;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

public class Paddle1 extends JPanel implements Runnable {

    public static int x;
    public static int y;
    public static GraphicsContext gc;
    public static boolean running;

    public Paddle1(int x, int y, GraphicsContext gc, boolean running) {

        this.x = x;
        this.y = y;
        this.gc = gc;
        this.running = true;

        
    }

    public static void clear() {
        gc.clearRect(x, y, 20, 175);
    }

    static void draw(int x, int y) {
        clear();
        gc.fillRect(x, y, 20, 175);

    }

    public void run() {

        while (running) {

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
    

}

