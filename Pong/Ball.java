package Pong;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Ball extends Rectangle {

    Random random;
    int xRichtung;
    int yRichtung;

    int x;
    int y;
    int ballBreite;
    int ballHöhe;

  
    

    Ball(int x, int y, int ballBreite, int ballHöhe) {
        this.x = x;
        this.y = y;
        this.ballBreite = ballBreite;
        this.ballHöhe = ballHöhe;
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

    public void move() {

       

        if (y < 0 || y > 640) {
            x = x + xRichtung;
            yRichtung = yRichtung * -1;
            y = y + yRichtung;
        } else if(1==2){
            y = y + yRichtung;
            xRichtung = xRichtung * -1;
            x = x + xRichtung;
        } else {
            x = x + xRichtung;
            y = y + yRichtung;
        }

    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, ballBreite, ballHöhe);
    }
}
