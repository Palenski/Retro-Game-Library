package Main;

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
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class StartingWindow2 implements ActionListener {

    JFrame frame = new JFrame();

    JButton titleButton = new JButton("<html><p><font color = Black>Wähle dein Spiel </font> </p></html>"); // HTML
                                                                                                            // Befehle
                                                                                                            // für eine
                                                                                                            // bessere
                                                                                                            // Gesatltung
                                                                                                            // der
                                                                                                            // Schrift

    ImageIcon iconPong = new ImageIcon("Images/discover.png"); // Bild aus dem Ordner Images wird hier dem Icon
                                                               // zugewiesen
    JButton pongButton = new JButton(iconPong); // Beim erstellen der Buttons wird jedem ein Icon mit passendem Bild
                                                // zugewiesen

    ImageIcon iconConnectFourButton = new ImageIcon("Images/369922d484c072edefc5a27ce992ea79.png");
    JButton connectFourButton = new JButton(iconConnectFourButton);

    ImageIcon iconTicTacToe = new ImageIcon("Images/tictactoe.png");
    JButton tictactoeButton = new JButton(iconTicTacToe);

    ImageIcon iconRockPaperScissor = new ImageIcon(
            "Images/handzeichen-ikonensatz-von-schere-stein-papier-rockpaperscissorsvector-illustration-190036698.jpg");
    JButton RockPaperScissor = new JButton(iconRockPaperScissor);

    ImageIcon iconSnake = new ImageIcon("Images/Snake-Title.png");
    JButton snakeButton = new JButton(iconSnake);

    ImageIcon iconTypingGame = new ImageIcon("Images/360_F_433466592_JpXOCCvbV3kMKTWo3jZKhGBnqEafnmfw.jpg");
    JButton TypingGameButton = new JButton(iconTypingGame);

    ImageIcon iconExit = new ImageIcon("Images/81ZEliCxW5L._AC_UL320_.jpg");
    JButton logOutButton = new JButton(iconExit);

    StartingWindow2() {     //Platzieren und Modifizieren der einzelnen Buttons auf dem Startfenster

        pongButton.setBounds(8, 110, 398, 125);
        pongButton.setFocusable(false);
        pongButton.addActionListener(this);
        pongButton.setBorderPainted(false);

        connectFourButton.setBounds(415, 110, 398, 125);
        connectFourButton.setFocusable(false);
        connectFourButton.addActionListener(this);
        connectFourButton.setBorderPainted(false);

        tictactoeButton.setBounds(8, 245, 398, 125);
        tictactoeButton.setFocusable(false);
        tictactoeButton.addActionListener(this);
        tictactoeButton.setBorderPainted(false);
        tictactoeButton.setBackground(Color.black);

        RockPaperScissor.setBounds(415, 245, 398, 125);
        RockPaperScissor.setFocusable(false);
        RockPaperScissor.addActionListener(this);
        RockPaperScissor.setBorderPainted(false);

        snakeButton.setBounds(8, 380, 398, 125);
        snakeButton.setFocusable(false);
        snakeButton.addActionListener(this);
        snakeButton.setBorderPainted(false);

        TypingGameButton.setBounds(415, 380, 398, 125);
        TypingGameButton.setFocusable(false);
        TypingGameButton.addActionListener(this);
        TypingGameButton.setBorderPainted(false);

        logOutButton.setBounds(8, 515, 805, 125);
        logOutButton.setFocusable(false);
        logOutButton.addActionListener(this);
        logOutButton.setContentAreaFilled(false);
        logOutButton.setBorderPainted(false);

        titleButton.setBounds(0, 0, 820, 100);
        titleButton.addActionListener(this);
        titleButton.setFocusable(false);
        titleButton.setFont(new Font(null, Font.BOLD, 43));

        titleButton.setContentAreaFilled(false);
        titleButton.setBorderPainted(false);

        frame.add(titleButton);

        frame.add(pongButton);
        frame.add(tictactoeButton);
        frame.add(RockPaperScissor);
        frame.add(TypingGameButton);
        frame.add(snakeButton);
        frame.add(connectFourButton);
        frame.add(logOutButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(837, 700);
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

        if (e.getSource() == connectFourButton) {
            frame.dispose();
            Main.connectFour();
        }

        if (e.getSource() == tictactoeButton) {
            frame.dispose();
            Main.TicTacToe();
        }

        if (e.getSource() == RockPaperScissor) {
            frame.dispose();
            Main.rockPaperScissor();
        }

        if (e.getSource() == snakeButton) {
            frame.dispose();
            Main.Snake();
        }

        if (e.getSource() == logOutButton) {
            frame.dispose();
        }
    }

}
