package Pong;

import java.awt.*;
import java.awt.event.*;
import java.util.*;




public class Score extends Rectangle{
    
    static int GAME_WIDTH;
    static int GAME_HEIGTH;
    int player1;
    int player2;
    
    Score(int GAME_WIDTH, int GAME_HEIGTH){
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGTH = GAME_HEIGTH;
    }

    public void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.PLAIN, 60));

        //g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGTH);

        g.drawString(String.valueOf(String.valueOf(player1/10)+String.valueOf(player1%10) + "   :   " + String.valueOf(player2/10)+String.valueOf(player2%10)), 380, 100);

        
       
    }
}
