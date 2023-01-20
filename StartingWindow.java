
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

import Pong.PongWindow;
import TypingGame.TypingGame;

public class StartingWindow implements ActionListener {

    JFrame frame = new JFrame();

    ImageIcon pong = new ImageIcon("Pong/Images/PongStart_snipped1.jpg");
    ImageIcon Backscreen = new ImageIcon("Pong/Images/StartBackscreen.png");

    JButton typingButton = new JButton("Typing Game");
    JButton pongButton = new JButton(pong);

    StartingWindow() {

        typingButton.addActionListener(this);
        typingButton.setBounds(255, 50, 500, 55);
        typingButton.setFont(new Font("Serif", Font.PLAIN, 30));
        frame.add(typingButton);

        pongButton.addActionListener(this);
        pongButton.setBounds(255, 125, 500, 120);
        pongButton.setBorderPainted(false);
        pongButton.setIcon(pong);

        frame.add(pongButton);
        pongButton.setOpaque(false);
        pongButton.setContentAreaFilled(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1750, 750);

        frame.setSize(1000, 650);

        frame.setTitle("Anmeldung");
        frame.setLayout(null);
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
