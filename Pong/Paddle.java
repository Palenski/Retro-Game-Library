package Pong;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import PongTest.Paddle1;
import javafx.scene.shape.Rectangle;

public class Paddle extends Rectangle {

    int id;
    int x;
    int y;
    int PADDLE_WIDTH;
    int PADDLE_HEIGTH;
    int yVelocity;
    int ySpeed = 10;

    Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGTH, int id) {

        this.x = x;
        this.y = y;
        this.PADDLE_WIDTH = PADDLE_WIDTH;
        this.PADDLE_HEIGTH = PADDLE_HEIGTH;
        this.id = id;

    }

    public void keyPressed(KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W & y > 0) {
                    setYDirection(-ySpeed);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_S & y < 650 - PADDLE_HEIGTH) {
                    setYDirection(ySpeed);
                    move();
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP & y > 0) {
                    setYDirection(-ySpeed);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN & y < 650 - PADDLE_HEIGTH) {
                    setYDirection(ySpeed);
                    move();
                }
                break;
        }
    }

    public void KeyReleased(KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(0);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(0);
                    move();
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(0);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(0);
                    move();
                }
                break;
        }
    }

    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    public void move() {
        y = y + yVelocity;
    }

    public void draw(Graphics g) {
        if (id == 1) {
            g.setColor(Color.blue);
            g.fillRect(x, y, PADDLE_WIDTH, PADDLE_HEIGTH);

        } else {
            g.setColor(Color.red);
            g.fillRect(x, y, PADDLE_WIDTH, PADDLE_HEIGTH);
        }

    }

}
