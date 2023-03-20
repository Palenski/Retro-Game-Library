package Pong;

import java.awt.*;

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
        int randomXRichtung = random.nextInt(2); // Sorgt für einen fairen Start, da der Ball Random in eine Richtung beginnt zu gehen
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

    public void setXDirection(int randomXRichtung) {    //Veränderung in der X-Ebene
        xRichtung = randomXRichtung;
    }

    public void setYDirection(int randomYRichtung) {    // Veränderung in der Y-Ebene
        yRichtung = randomYRichtung;
    }

    public void setSpeed(double randomSpeed) {      //Damit sich der Speed erhöht
        speed = randomSpeed;
    }

    public void move() { // bewegt den Ball

        x = x + xRichtung * speed;
        y = y + yRichtung * (speed / 2);

    }

    public void draw(Graphics g) { // Grafische Darstellung
        g.setColor(Color.white);
        g.fillOval((int) x, (int) y, ballBreite, ballHöhe);
    }
}
