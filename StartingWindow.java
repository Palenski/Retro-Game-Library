
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import PongTest.PongWindow;
import TypingGame.TypingGame;

public class StartingWindow implements ActionListener {

    JFrame frame = new JFrame();

    ImageIcon pong = new ImageIcon("Pong/Images/PongStart.png");

    JButton typingButton = new JButton("Typing Game");
    JButton pongButton = new JButton("Pong");
    JButton TicTacToeButton = new JButton("TicTacToe");

    StartingWindow() {

        typingButton.addActionListener(this);
        typingButton.setBounds(255, 50, 500, 55);
        typingButton.setFont(new Font("Serif", Font.PLAIN, 30));
        frame.add(typingButton);

        pongButton.addActionListener(this);
        pongButton.setBounds(255, 125, 500, 120);
        pongButton.setBorderPainted(true);
        pongButton.setIcon(pong);

        frame.add(pongButton);
        pongButton.setOpaque(false);
        pongButton.setContentAreaFilled(false);

        TicTacToeButton.addActionListener(this);
        TicTacToeButton.setBounds(255, 80, 80, 80);
        TicTacToeButton.setBorderPainted(true);
        TicTacToeButton.setIcon(pong);

        frame.add(TicTacToeButton);
        TicTacToeButton.setOpaque(false);
        TicTacToeButton.setContentAreaFilled(false);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        

        frame.setSize(1000, 650);

        frame.setTitle("Starting Window");
        
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBackground(Color.BLACK);
        
        
        
        
        
        /*
         * 
         * 
         * try {
         * frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new
         * File("Pong/Images/StartBackscreen.png")))));
         * } catch (Exception e) {
         * e.printStackTrace();
         * }
         * frame.pack();
         */

    }

    public void actionPerformed(ActionEvent e) { // einfache Weiterleitung an die verschiedenen Fenster
        if (e.getSource() == typingButton) {
            frame.dispose();
            TypingGame typingGame = new TypingGame();

        }

        if (e.getSource() == pongButton) {
            frame.dispose();
            PongWindow pongWindow = new PongWindow();

        }
    }

}
