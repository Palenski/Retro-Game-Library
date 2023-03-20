package RockPaperScissor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GameScreen extends JFrame implements ActionListener {

    Random random = new Random();

    JFrame frame = new JFrame();

    JButton[] buttons = new JButton[3];
    JPanel buttonPanel = new JPanel();

    JLabel[] labels = new JLabel[2];
    JPanel labelPanel = new JPanel();

    JLabel Ergebnis = new JLabel("Das Ergebnis ist: ");
    JPanel Ergebniss = new JPanel();

    String[] stp = { "Schere", "Stein", "Papier" };
    String[] Texte = { "Hier steht was du wählst", "Hier steht was der Computer wählt" };
    String Text2 = "Deine Wahl ist: ";
    String Text4 = "Der Computer wählt: ";

    String PlayerChoice;
    String ComputerChoice;

    public GameScreen() {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setLocationRelativeTo(null);
        frame.setSize(800, 700);
        frame.setTitle("Schere Stein Papier");

        buttonPanel.setLayout(new GridLayout(1, 0));
        buttonPanel.setBackground(new Color(150, 150, 150));
        buttonPanel.setSize(300, 100);

        for (int i = 0; i < 3; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("SansSerif", Font.BOLD, 50));
            buttons[i].setFocusable(true);
            buttons[i].addActionListener(this);
            buttons[i].setEnabled(true);
            buttons[i].setBackground(new Color(0, 0, 0));
            buttons[i].setVisible(true);
            buttons[i].setText(stp[i]);

        }

        labelPanel.setLayout(new GridLayout(1, 0));

        for (int i = 0; i < 2; i++) {

            labels[i] = new JLabel();
            labelPanel.add(labels[i]);
            labels[i].setText(Texte[i]);
        }

        Ergebniss.add(Ergebnis);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(labelPanel, BorderLayout.NORTH);
        frame.add(Ergebniss, BorderLayout.CENTER);
    }

    public void PCTurn() {
        int PCWahl = random.nextInt(3);
        if (PCWahl == 0) {
            labels[1].setText(Text4 + stp[0]);
            ComputerChoice = stp[0];
        }
        if (PCWahl == 1) {
            labels[1].setText(Text4 + stp[1]);
            ComputerChoice = stp[1];
        }
        if (PCWahl == 2) {
            labels[1].setText(Text4 + stp[2]);
            ComputerChoice = stp[2];
        }

        GewinnerErmitlung();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttons[0]) {
            labels[0].setText(Text2 + stp[0]);
            PlayerChoice = buttons[0].getText();
            for (int i = 0; i < 3; i++) {
                buttons[i].setEnabled(false);
            }
        }
        if (e.getSource() == buttons[1]) {
            labels[0].setText(Text2 + stp[1]);
            PlayerChoice = buttons[1].getText();
            for (int i = 0; i < 3; i++) {
                buttons[i].setEnabled(false);
            }
        }
        if (e.getSource() == buttons[2]) {
            labels[0].setText(Text2 + stp[2]);
            PlayerChoice = buttons[2].getText();
            for (int i = 0; i < 3; i++) {
                buttons[i].setEnabled(false);
            }
        }
        PCTurn();
    }

    public void GewinnerErmitlung() {
        if (PlayerChoice.equals("Schere") && ComputerChoice.equals("Schere")) {
            Ergebnis.setText("Unentschieden");
        }
        if (PlayerChoice.equals("Schere") && ComputerChoice.equals("Papier")) {
            Ergebnis.setText("Du gewinnst");
        }
        if (PlayerChoice.equals("Schere") && ComputerChoice.equals("Stein")) {
            Ergebnis.setText("Der Computer gewinnt");
        }
        if (PlayerChoice.equals("Stein") && ComputerChoice.equals("Schere")) {
            Ergebnis.setText("Du gewinnst");
        }
        if (PlayerChoice.equals("Stein") && ComputerChoice.equals("Papier")) {
            Ergebnis.setText("Der Computer gewinnt");
        }
        if (PlayerChoice.equals("Stein") && ComputerChoice.equals("Stein")) {
            Ergebnis.setText("Unentschieden");
        }
        if (PlayerChoice.equals("Papier") && ComputerChoice.equals("Schere")) {
            Ergebnis.setText("Der Computer gewinnt");
        }
        if (PlayerChoice.equals("Papier") && ComputerChoice.equals("Papier")) {
            Ergebnis.setText("Unentschieden");
        }
        if (PlayerChoice.equals("Papier") && ComputerChoice.equals("Stein")) {
            Ergebnis.setText("Du gewinnst");
        }
    }
}