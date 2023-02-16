package Pong;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGTH = 650;
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGTH);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGTH = 150;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;

    GamePanel() {
        newPaddles();
        newBall();
        score = new Score(GAME_WIDTH, GAME_HEIGTH);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newBall() {
        // random = new Random();
        ball = new Ball(480, 305, BALL_DIAMETER, BALL_DIAMETER, 1);
    }

    public void newPaddles() {
        paddle1 = new Paddle(50, 225, PADDLE_WIDTH, PADDLE_HEIGTH, 1);
        paddle2 = new Paddle(925, 225, PADDLE_WIDTH, PADDLE_HEIGTH, 2);
    }

    public void paint(Graphics g) {
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

    public void move() {
        ball.move();
    }

    public void checkCollision() {
        //Falls der Bal die Kante oben oder unten berührt
        if (ball.y < 0) {   
            ball.setYDirection(ball.yRichtung * -1);
            ball.setSpeed(ball.speed + 0.4);
        } else if (ball.y > 650 - ball.ballBreite) {
            ball.setYDirection(ball.yRichtung * -1);
            ball.setSpeed(ball.speed + 0.4);
        }

        //Falls der Ball die Paddles berührt
        if(ball.x <= 75 && ball.x > paddle1.x && ball.y > paddle1.y && ball.y < paddle1.y + paddle1.PaddleHöhe){
            ball.setXDirection(ball.xRichtung * -1);
            ball.setSpeed(ball.speed + 0.4);
        } else if (ball.x >= paddle2.x - ball.ballBreite && ball.x < paddle2.x + paddle2.PaddleBreite && ball.y > paddle2.y && ball.y < paddle2.y + paddle2.PaddleHöhe) {
            ball.setXDirection(ball.xRichtung * -1);
            ball.setSpeed(ball.speed + 0.4);
        }
       

        if(ball.x <= 0){
            score.player2++;
            newPaddles();
            newBall();
        }else if(ball.x >= 1000){
            score.player1++;
            newPaddles();
            newBall();
        }

    }

    public void run() {
        // Game loop (basic)
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
                move();
                repaint();
                delta--;
            }
        }

    }

    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }

        public void KeyReleased(KeyEvent e) {
            paddle1.KeyReleased(e);
            paddle2.KeyReleased(e);
        }
    }
}
