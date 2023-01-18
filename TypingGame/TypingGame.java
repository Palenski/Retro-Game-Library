package TypingGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Component;

public class TypingGame implements ActionListener {
    JFrame frame = new JFrame();

    JButton button1 = new JButton("Start the Game");

    public TypingGame() {

        button1.setBounds(345, 200, 300, 200);
        button1.setFont(new Font("Serif", Font.PLAIN, 30));
        button1.setFocusable(false);
        button1.setBackground(Color.red);
        button1.setForeground(Color.white);
        button1.addActionListener(this);

        frame.add(button1);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000, 650);

        frame.setTitle("Space Invaders");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.BLACK);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            frame.dispose();
            GameScreen gameScreen = new GameScreen();
        }
    }

}
