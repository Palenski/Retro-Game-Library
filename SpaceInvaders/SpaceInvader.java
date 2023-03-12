package SpaceInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SpaceInvader {
    JFrame frame = new JFrame();
    JPanel Window = new Window();

    public static Window window;

public SpaceInvader(){

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setSize(600, 600);

    frame.setTitle("Space Invaders");
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setContentPane(Window);
}
}
