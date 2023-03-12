package SpaceInvaders;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Window extends JPanel{


    public Window(){
        super();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;

        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, 600, 600);
        g2.setColor(Color.GREEN);
        g2.fillRect(30, 530, 535, 5);
    }
    
}

