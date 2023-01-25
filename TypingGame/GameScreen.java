package TypingGame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class GameScreen implements KeyListener {
    JFrame frame = new JFrame();

    JLabel label = new JLabel();
    String Text = ("Niemand schaut auf sein Leben und erinnert sich an die Nächte, in denen er viel geschlafen hat.");

    Character Letters[] = { 'N', 'i', 'e', 'm', 'a', 'n', 'd', ' ', 's', 'c', 'h', 'a', 'u', 't' };

    public GameScreen() {

        label.setBounds(255, 50, 500, 55);
        label.setFocusable(false);
        label.setText(Text); // vielleicht später Text aus online Document nehmen oder aus einer .txt
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        label.setForeground(Color.black);
        label.setVisible(true);
        frame.addKeyListener(this);

        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000, 650);

        frame.setTitle("Typing Game");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.white);

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_N) {

            System.out.print("Test");
        }

    }

    @Override // nur für den Computer wichtig
    public void keyTyped(KeyEvent e) {

    }

    @Override // nur für den Computer wichtig
    public void keyReleased(KeyEvent e) {

    }
}
