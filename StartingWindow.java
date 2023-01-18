
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;

import Pong.PongWindow;
import TypingGame.TypingGame;

public class StartingWindow implements ActionListener {

    JFrame frame = new JFrame();

    JButton typingButton = new JButton("Typing Game");
    JButton pongButton = new JButton("Pong");

    StartingWindow() {

        typingButton.addActionListener(this);
        typingButton.setBounds(255, 50, 500, 55);
        frame.add(typingButton);


        pongButton.addActionListener(this);
        pongButton.setBounds(255, 125, 500, 55);
        frame.add(pongButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1750, 750);

        frame.setSize(1000, 650);

        frame.setTitle("Anmeldung");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

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


