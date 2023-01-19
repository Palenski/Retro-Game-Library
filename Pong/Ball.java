package Pong;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;


public class Ball extends JPanel {

    public Ball() {

    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
            
        ImageIcon icon = new ImageIcon("Pong/Images/Red-Ball.png");

        icon.paintIcon(this, g, 50, 50);

        ;
    }


}
