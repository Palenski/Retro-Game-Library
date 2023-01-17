package TypingGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class GameScreen implements KeyListener {
    JFrame frame = new JFrame();

    JLabel label = new JLabel();
    String Text = "<html><font color=blue><u>N</u></font>iemand schaut später auf sein Leben zurück und <BR> erinnert sich an die Nächte, in denen er viel geschlafen hat.</html>";

    public GameScreen() {

        label.setBounds(255, 50, 500, 55);
        label.setFocusable(false);
        label.setText(Text); // vielleicht später Text aus online Document nehmen oder aus einer .txt
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        label.setForeground(Color.black);
        frame.addKeyListener(this);

        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000, 650);

        frame.setTitle("Space Invaders");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.white);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_N) {
            label.setText("<html><font color=blue><u>Ni</u></font>emand schaut später auf sein Leben zurück und <BR> erinnert sich an die Nächte, in denen er viel geschlafen hat.</html>");
            
        }
    }

    @Override //nur für den Computer wichtig
    public void keyTyped(KeyEvent e) {

    }

    @Override //nur für den Computer wichtig
    public void keyReleased(KeyEvent e) {

    }
}
