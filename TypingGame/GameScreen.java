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
    String Text = "Niemand schaut später auf sein Leben zurück und erinnert sich an die Nächte, in denen er viel geschlafen hat.";
    String Texte[] = {
            "<html><font color=blue><u>N</u></font>iemand schaut später auf sein Leben zurück und <BR> erinnert sich an die Nächte, in denen er viel geschlafen hat.</html>",
            "<html><font color=blue><u>Ni</u></font>emand schaut später auf sein Leben zurück und <BR> erinnert sich an die Nächte, in denen er viel geschlafen hat.</html>",
            "<html><font color=blue><u>Nie</u></font>mand schaut später auf sein Leben zurück und <BR> erinnert sich an die Nächte, in denen er viel geschlafen hat.</html>",
            "<html><font color=blue><u>Niem</u></font>and schaut später auf sein Leben zurück und <BR> erinnert sich an die Nächte, in denen er viel geschlafen hat.</html>",
            "<html><font color=blue><u>Niema</u></font>nd schaut später auf sein Leben zurück und <BR> erinnert sich an die Nächte, in denen er viel geschlafen hat.</html>"
    };
    Character Letters[] = { 'N', 'i', 'e', 'm', 'a', 'n', 'd', ' ', 's', 'c', 'h', 'a', 'u', 't' };

    public GameScreen() {

        label.setBounds(255, 50, 500, 55);
        label.setFocusable(false);
        label.setText(Texte[0]); // vielleicht später Text aus online Document nehmen oder aus einer .txt
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        label.setForeground(Color.black);
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
            label.setText(Texte[1]);
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
