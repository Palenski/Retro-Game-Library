package PongTest;

import javafx.scene.canvas.GraphicsContext;

public class Ball implements Runnable {

    public static int x;
    public static int y;
    public static GraphicsContext gc;
    public static boolean running;

    public Ball(int x, int y, GraphicsContext gc, boolean running) {

        this.x = x;
        this.y = y;
        this.gc = gc;
        this.running = true;
    }

    public static void clear() {
        gc.clearRect(x, y, 21, 21);
        
    }

    static void draw(int x, int y) {
        clear();
        gc.fillOval(x, y, 20, 20);
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
