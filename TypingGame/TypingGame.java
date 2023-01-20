package TypingGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;




public class TypingGame implements ActionListener {
    JFrame frame = new JFrame();

    JButton startButton = new JButton("Start the Game");
    JButton backButton = new JButton("Back to menu");


    

    public TypingGame() {

        startButton.setBounds(345, 200, 300, 200);
        startButton.setFont(new Font("Serif", Font.PLAIN, 30));
        startButton.setFocusable(false);
        startButton.setBackground(Color.red);
        startButton.setForeground(Color.white);
        startButton.addActionListener(this);
        frame.add(startButton);

        backButton.setBounds(345,500,300,100);
        backButton.setFont(new Font("Serif", Font.PLAIN, 30));
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        frame.add(backButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000, 650);

        frame.setTitle("Space Invaders");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.BLACK);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            frame.dispose();
            Screen screen = new Screen();
        }
        if(e.getSource() == backButton){
            frame.dispose();
           
            
        }
    }

}
