
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class StartingWindow2 implements ActionListener {

    JFrame frame = new JFrame();


   



    JButton titleButton = new JButton("Wähle ein Spiel");
    

    Icon normal = new ImageIcon(getClass().getResource("Images/Pong.png"));
  
    
    JButton pongButton = new JButton(normal);

    JButton tictactoeButton = new JButton();
    //static ImageIcon iconTicTactToe = new ImageIcon();

    JButton typingGameButton = new JButton("Typing Game");
    static ImageIcon icontypigingGame = new ImageIcon();

    JButton spaceInvadersButton = new JButton("Space Invader");
    static ImageIcon iconSpaceInvaders = new ImageIcon();

    JButton snakeButton = new JButton("Snake");
    static ImageIcon iconSnakeButton = new ImageIcon();

    JButton spiel6 = new JButton("6");
    static ImageIcon iconSpiel6 = new ImageIcon();

    JButton logOutButton = new JButton("Beenden");


    StartingWindow2() {

        pongButton.setBounds(8, 110, 398, 125);
        pongButton.setFocusable(false);
        pongButton.addActionListener(this);

        tictactoeButton.setBounds(8, 245, 398, 125);
        tictactoeButton.setFocusable(false);
        tictactoeButton.addActionListener(this);
      
        tictactoeButton.setIcon(new ImageIcon("Pong.png"));


        typingGameButton.setBounds(8, 380, 398, 125);
        typingGameButton.setFocusable(false);
        typingGameButton.addActionListener(this);

        spaceInvadersButton.setBounds(415, 110, 398, 125);
        spaceInvadersButton.setFocusable(false);
        spaceInvadersButton.addActionListener(this);

        snakeButton.setBounds(415,245,398,125);
        snakeButton.setFocusable(false);
        snakeButton.addActionListener(this);

        spiel6.setBounds(415, 380, 398, 125);
        spiel6.setFocusable(false);
        spiel6.addActionListener(this);

        logOutButton.setBounds(8, 515, 805, 125);
        logOutButton.setFocusable(false);
        logOutButton.addActionListener(this);

        titleButton.setBounds(0, 0, 820, 100);
        titleButton.addActionListener(this);
        titleButton.setFocusable(false);
        titleButton.setFont(new Font(null, Font.BOLD, 43));
        titleButton.setContentAreaFilled(false);
        titleButton.setBorderPainted(false);

        frame.add(titleButton);

        frame.add(pongButton);
        frame.add(tictactoeButton);
        frame.add(typingGameButton);
        frame.add(spaceInvadersButton);
        frame.add(snakeButton);
        frame.add(spiel6);
        frame.add(logOutButton);

        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(837, 750);
        frame.setTitle("Startscreen");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.PINK);
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
            Main.Snake();
        }
        
        if (e.getSource() == logOutButton) {
            frame.dispose();
        }
    }

    

}
