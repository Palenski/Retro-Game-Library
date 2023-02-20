package Pong;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Score extends Rectangle {

    static int breite;
    static int höhe;
    int spieler1;
    int spieler2;

    Score(int höhe, int breite) {
        Score.breite = breite;
        Score.höhe = höhe;
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.PLAIN, 60));
        g.drawString(String.valueOf(String.valueOf(spieler1 / 10) + String.valueOf(spieler1 % 10) + "   :   " + String.valueOf(spieler2 / 10) + String.valueOf(spieler2 % 10)), 380, 100);

    }
}
