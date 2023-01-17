package TypingGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameScreen {
    JFrame frame = new JFrame();

    JLabel label = new JLabel();
    String Text = "<html><font color=blue><u>N</u></font>iemand schaut später auf sein Leben zurück und <BR> erinnert sich an die Nächte, in denen er viel geschlafen hat.</html>";
    

    public GameScreen() {

        label.setBounds(255, 50, 500, 55);
        label.setFocusable(false);
        label.setText(Text);              //vielleicht später Text aus online Document nehmen oder aus einer .txt
        label.setFont(new Font ("Serif", Font.PLAIN, 20));
        label.setForeground(Color.black);
       

        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000, 650);

        frame.setTitle("Space Invaders");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.white);
    }
}
