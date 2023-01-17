package SpaceInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SpaceInvader {
    JFrame frame = new JFrame();

public SpaceInvader(){

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000, 650);

        frame.setTitle("Space Invaders");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.black);
}
}
