package Pong;

import java.awt.*;
import java.awt.event.*;
import java.util.*;


import javafx.scene.shape.Rectangle;

public class Ball extends Rectangle{
   
    Random random;
    int xVelocity;
    int yVelocity;

    int x;
    int y;
    int ballWidth;
    int ballHeighth;
    
    Ball(int x, int y, int ballWidth, int ballHeighth){
        this.x = x;
        this.y = y;
        this.ballWidth = ballWidth;
        this.ballHeighth = ballHeighth;
        random = new Random();
        int randomXDirection = random.nextInt(2);
        if(randomXDirection == 0){
            randomXDirection--;
        }
        setXDirection(randomXDirection);

        int randomYDirection = random.nextInt(2);
        if (randomYDirection == 0) {
            randomYDirection--;
        }
        setYDirection(randomYDirection);

    }

    public void setXDirection(int randomXDirection){
        xVelocity = randomXDirection;
    }

    public void setYDirection(int randomYDirection){
        yVelocity = randomYDirection;
    }

    public void move(){
        x = x + xVelocity;
        y = y + yVelocity;
    }

    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x, y, ballWidth, ballHeighth);
    }
}
