
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class StartingWindow2 implements ActionListener {

    JFrame frame = new JFrame();

    JButton titleButton = new JButton("Wähle ein Spiel");

    JButton pongButton = new JButton("Pong");
    JButton tictactoeButton = new JButton("TicTacToe");

    JButton typingGameButton = new JButton("Typing Game");
    JButton spaceInvadersButton = new JButton("Space Invader");

    JButton snakeButton = new JButton("Snake");

    JButton logOutButton = new JButton("Beenden");

    public static int Test = 0;

    StartingWindow2() {

        pongButton.setBounds(5, 110, 398, 50);
        pongButton.setFocusable(false);
        pongButton.addActionListener(this);

        tictactoeButton.setBounds(5, 170, 398, 50);
        tictactoeButton.setFocusable(false);
        tictactoeButton.addActionListener(this);

        typingGameButton.setBounds(5, 230, 398, 50);
        typingGameButton.setFocusable(false);
        typingGameButton.addActionListener(this);

        spaceInvadersButton.setBounds(5, 290, 398, 50);
        spaceInvadersButton.setFocusable(false);
        spaceInvadersButton.addActionListener(this);

        snakeButton.setBounds(5,350,398,50);
        snakeButton.setFocusable(false);
        snakeButton.addActionListener(this);

        logOutButton.setBounds(5, 350, 398, 50);
        logOutButton.setFocusable(false);
        logOutButton.addActionListener(this);

        titleButton.setBounds(0, 0, 410, 100);
        titleButton.addActionListener(this);
        titleButton.setFocusable(false);
        titleButton.setFont(new Font(null, Font.BOLD, 23));
        titleButton.setContentAreaFilled(false);
        titleButton.setBorderPainted(false);

        frame.add(titleButton);

        frame.add(pongButton);
        frame.add(tictactoeButton);
        frame.add(typingGameButton);
        frame.add(spaceInvadersButton);
        frame.add(snakeButton);
        frame.add(logOutButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 450);
        frame.setTitle("Startscreen");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public void actionPerformed(ActionEvent e) { // einfache Weiterleitung an die verschiedenen Fenster
        if (e.getSource() == pongButton) {
            frame.dispose();
            Main.pong();
        }

        if (e.getSource() == tictactoeButton) {
            frame.dispose();
            Main.TicTacToe();


            
        }

        if (e.getSource() == typingGameButton) {
            frame.dispose();
            Main.TypingGame();
        }

        if (e.getSource() == spaceInvadersButton) {
            frame.dispose();
            Main.SpaceInvader();
        }

        if(e.getSource() == snakeButton) {
            frame.dispose();
            //fehlt noch start für Snake
        }
        
        if (e.getSource() == logOutButton) {
            frame.dispose();
        }
    }

    

}
