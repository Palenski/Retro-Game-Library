package Pong;

import Main.Main;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    static final int breite = 1000;
    static final int höhe = 650;
    static final Dimension screen = new Dimension(breite, höhe);
    static final int ball_diameter = 20;
    static final int paddle_breite = 25;
    static final int paddle_höhe = 150;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;

    GamePanel() { // Spieloberfläche, welche alle Klassen beeinhaltet
        newPaddles();
        newBall();
        score = new Score(breite, höhe);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(screen);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newBall() { // Erstllung des Balls
        ball = new Ball(480, 305, ball_diameter, ball_diameter, 1);
    }

    public void newPaddles() { // Erstellung der Paddle
        paddle1 = new Paddle(50, 225, paddle_breite, paddle_höhe, 1);
        paddle2 = new Paddle(925, 225, paddle_breite, paddle_höhe, 2);
    }

    public void paint(Graphics g) { // Grafische Darstellung
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g) {
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
    }

    public void bewegen() {
        ball.move();
    }

    public void checkCollision() {  // Falls der Bal die Kante oben oder unten berührt
        if (ball.y < 0) {
            ball.setYDirection(ball.yRichtung * -1);
            ball.setSpeed(ball.speed + 0.4);
        } else if (ball.y > 650 - ball.ballBreite) {
            ball.setYDirection(ball.yRichtung * -1);
            ball.setSpeed(ball.speed + 0.4);
        }

       
        if (ball.x <= 75 && ball.x > paddle1.x && ball.y > paddle1.y && ball.y < paddle1.y + paddle1.PaddleHöhe) {  // Falls der Ball die Paddles berührt
            ball.setXDirection(ball.xRichtung * -1);
            ball.setSpeed(ball.speed + 0.4);
        } else if (ball.x >= paddle2.x - ball.ballBreite && ball.x < paddle2.x + paddle2.PaddleBreite
                && ball.y > paddle2.y && ball.y < paddle2.y + paddle2.PaddleHöhe) {
            ball.setXDirection(ball.xRichtung * -1);
            ball.setSpeed(ball.speed + 0.4);
        }

        if (ball.x <= 0) {      //Falls der Ball in der Endzone ist
            score.spieler2++;
            newPaddles();
            newBall();

        } else if (ball.x >= 1000) {
            score.spieler1++;
            newPaddles();
            newBall();

        }

    }

    public void run() {     // Standart Gameloop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.00;
        double nanoSeconds = 1000000000 / amountOfTicks;
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta = delta + (now - lastTime) / nanoSeconds;
            lastTime = now;
            if (delta >= 1) {
                checkCollision();
                bewegen();
                repaint();
                delta--;
            }
        }

    }

    public class AL extends KeyAdapter { // Guckt, ob Paddles bewegt werden müssen
        public void keyPressed(KeyEvent e) {
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
            if (e.getKeyCode() == KeyEvent.VK_Q) {
                Main.pongclose();
                Main.startingWindow2();
            }
        }

        public void KeyReleased(KeyEvent e) {
            paddle1.KeyReleased(e);
            paddle2.KeyReleased(e);
        }
    }
}
