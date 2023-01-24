package Pong;

import java.awt.Color;

import javafx.scene.canvas.GraphicsContext;

public class Paddle2 implements Runnable {

    public static int x;
    public static int y;
    public static GraphicsContext gc;
    public static boolean running;

    public Paddle2(int x, int y, GraphicsContext gc, boolean running) {

        this.x = x;
        this.y = y;
        this.gc = gc;
        this.running = false;
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

            clear();
            draw(x, y);
            x++;
            // y++;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
