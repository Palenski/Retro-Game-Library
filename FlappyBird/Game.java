import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.net.ServerSocket;
import java.nio.Buffer;



public class Game extends Canvas implements Runnable {
    
    public static final int Höhe = 432;
    public static final int Breite = 768;
    public boolean running;

    Thread thread;
    ServerSocket serverSocket;
    private Thread threat;
    public static void main(String[] args) {
        new Window(Breite, Höhe, "Flappy Bird", new Game());
    }

    public synchronized void start() {
        running = true;
        threat = new Thread();
        thread.start();
        run();

    }

    public void init() {

    }

    public void tick() {

    }

    public void render(){

        BufferStrategy bs = this.getBufferStrategy();

        if(bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.red);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.dispose();
        bs.show();

    }

    public void run() {
        init();
        this.requestFocus();

        long pastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta;
        long timer = System.currentTimeMillis();
        int updates = 0;;
        int frames = 0;

        while(running){
            long now = System.nanoTime();
            delta =+ (now - pastTime) / ns;
            pastTime = now;

            while(delta > 0){
                tick();
                updates++;

                render();
                frames++;
                delta--;
            }

            if(System.currentTimeMillis() - timer > 1000) {
                timer =+ 10000;
                System.out.println("FPS: " + frames + "| Ticks: " + updates);
                updates = 0;
                frames = 0;
            }
        }
    }
}