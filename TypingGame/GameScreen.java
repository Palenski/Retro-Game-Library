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
    String Text = ("<html>Niemand schaut auf sein Leben und erinnert sich an die Nächte, in denen er viel geschlafen hat.</html>");
    String Var1 = ("<html> <font color = Blue> N </font> iemand schaut auf sein Leben und erinnert sich an die Nächte, in denen er viel geschlafen hat.</html>");
    String[] TextVarianten = {
            "<html> <font color = Blue> N </font>iemand schaut auf sein Leben und erinnert sich an die Nächte, in denen er viel geschlafen hat.</html>",
            "<html> <font color = Blue> Ni </font>emand schaut auf sein Leben und erinnert sich an die Nächte, in denen er viel geschlafen hat.</html>" };

    String [] TextVariantenFalse = {
        "<html> <font color = Red> N </font>iemand schaut auf sein Leben und erinnert sich an die Nächte, in denen er viel geschlafen hat.</html>",
        "<html><font color = Blue> N </Fonte> <font color = Red> i </font>emand schaut auf sein Leben und erinnert sich an die Nächte, in denen er viel geschlafen hat.</html>",};

    

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
        int[] keys = { 78, 73 };
        int i = 0;

        if (key == keys[i]) {
            label.setText(TextVarianten[i]);
            //System.out.print("Test");
            i++;
            System.out.print(i);
        }
        else{
            label.setText(TextVariantenFalse[i]);
        }

    }

    @Override // nur für den Computer wichtig
    public void keyTyped(KeyEvent e) {

    }

    @Override // nur für den Computer wichtig
    public void keyReleased(KeyEvent e) {

    }
}
