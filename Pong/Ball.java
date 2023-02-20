package Pong;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Ball extends Rectangle {

    Random random;
    int xRichtung;
    int yRichtung;

    double x;
    double y;
    int ballBreite;
    int ballHöhe;

    double speed;

  
    

    Ball(int x, int y, int ballBreite, int ballHöhe, double speed) {
        this.x = x;
        this.y = y;
        this.ballBreite = ballBreite;
        this.ballHöhe = ballHöhe;
        this.speed = speed;
        random = new Random();
        int randomXRichtung = random.nextInt(2);
        if (randomXRichtung == 0) {
            randomXRichtung--;
        }
        setXDirection(randomXRichtung);

        int randomYRichtung = random.nextInt(2);
        if (randomYRichtung == 0) {
            randomYRichtung--;
        }
        setYDirection(randomYRichtung);

        
    }

    public void setXDirection(int randomXRichtung) {
        xRichtung = randomXRichtung;
    }

    public void setYDirection(int randomYRichtung) {
        yRichtung = randomYRichtung;
    }

    public void setSpeed(double randomSpeed) {
        speed = randomSpeed;
    }

    public void move() {

       x = x + xRichtung * speed;
       y = y + yRichtung * (speed / 2);

    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval((int) x, (int) y, ballBreite, ballHöhe);
    }
}
