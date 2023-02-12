
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

import Pong.PongGame;
import PongTest.PongWindow;
import TicTacToe.MainTicTacToe;
import TypingGame.TypingGame;

public class StartingWindow implements ActionListener {

    JFrame frame = new JFrame();

    
    JButton typingButton = new JButton("Typing Game");
    JButton pongButton = new JButton("Pong");
    JButton TicTacToeButton = new JButton("TicTacToe");

    StartingWindow() {

        typingButton.addActionListener(this);
        typingButton.setBounds(255, 50, 50, 55);
        typingButton.setFont(new Font("Serif", Font.PLAIN, 30));
       //frame.add(typingButton);

        pongButton.addActionListener(this);
        pongButton.setBounds(255, 125, 50, 50);
        frame.add(pongButton);
        

        TicTacToeButton.addActionListener(this);
        //frame.add(TicTacToeButton);
       


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        frame.setSize(1000, 650);

        frame.setTitle("Starting Window");
        
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBackground(Color.BLACK);
        
        
        
        
        
        

    }

    public void actionPerformed(ActionEvent e) { // einfache Weiterleitung an die verschiedenen Fenster
        if (e.getSource() == typingButton) {
            frame.dispose();
            TypingGame typingGame = new TypingGame();

        }

        if (e.getSource() == pongButton) {
            frame.dispose();
           PongGame pongGame = new PongGame();

        }

        if(e.getSource() == TicTacToeButton){
            frame.dispose();
            MainTicTacToe mainTicTacToe = new MainTicTacToe();
        }
    }

}
