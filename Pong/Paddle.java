package Pong;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import org.ietf.jgss.GSSContext;

public class Paddle extends Rectangle {

    int id;
    int x;
    int y;
    int PaddleBreite;
    int PaddleHöhe;
    int yRichtung;
    int yGeschwindigkeit = 15;

    Paddle(int x, int y, int PaddleBreite, int PaddleHöhe, int id) {

        this.x = x;
        this.y = y;
        this.PaddleBreite = PaddleBreite;
        this.PaddleHöhe = PaddleHöhe;
        this.id = id;

    }

    public void keyPressed(KeyEvent e) { // Bewegt die verschiedenen Paddles
        switch (id) { // Entscheidet, welches Paddle bewegt wird
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W & y > 0) {
                    setYRichtung(-yGeschwindigkeit);
                    bewegen();
                }
                if (e.getKeyCode() == KeyEvent.VK_S & y < 650 - PaddleHöhe) {
                    setYRichtung(yGeschwindigkeit);
                    bewegen();
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP & y > 0) {
                    setYRichtung(-yGeschwindigkeit);
                    bewegen();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN & y < 650 - PaddleHöhe) {
                    setYRichtung(yGeschwindigkeit);
                    bewegen();
                }
                break;
        }
    }

    public void KeyReleased(KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYRichtung(0);
                    bewegen();
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYRichtung(0);
                    bewegen();
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYRichtung(0);
                    bewegen();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYRichtung(0);
                    bewegen();
                }
                break;
        }
    }

    public void setYRichtung(int yRichtung2) {
        yRichtung = yRichtung2;
    }

    public void bewegen() {
        y = y + yRichtung;
    }

    public void draw(Graphics g) { // Grafische Darstellung
        if (id == 1) {
            g.setColor(Color.blue);
            g.fillRect(x, y, PaddleBreite, PaddleHöhe);

        } else {
            g.setColor(Color.red);
            g.fillRect(x, y, PaddleBreite, PaddleHöhe);
        }

    }

}
