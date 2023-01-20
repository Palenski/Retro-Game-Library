package TypingGame;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;

public class Screen implements KeyListener {
    JFrame frame = new JFrame();

    JLabel label = new JLabel();
    String Text = ("Niemand schaut auf sein Leben und erinnert sich an die Nächte, in denen er viel geschlafen hat.");

    Character Letters[] = { 'N', 'i', 'e', 'm', 'a', 'n', 'd', ' ', 's', 'c', 'h', 'a', 'u', 't' };

    public Screen() {

        label.setBounds(255, 50, 500, 55);
        label.setFocusable(false);
        label.setText("Test"); // vielleicht später Text aus online Document nehmen oder aus einer .txt
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        label.setForeground(Color.black);
        frame.addKeyListener(this);;

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

        if (key == 78) {
            System.out.print("Test hat geklappt");
            
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    
}
