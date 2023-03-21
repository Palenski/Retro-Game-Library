package RockPaperScissor;

import java.awt.*;
import java.awt.RenderingHints.Key;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

import java.util.*;

import Main.Main;

public class Game_Frame extends JFrame implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();

    JButton[] buttons = new JButton[3];
    JPanel buttonPanel = new JPanel();

    JButton[] labels = new JButton[2];
    JPanel labelPanel = new JPanel();

    String ErgebnissText = "Das Ergebnis ist: ";
    JButton Ergebnis = new JButton(ErgebnissText);
    JPanel Ergebniss = new JPanel();

    JPanel mittePanel = new JPanel(); // in diesem Panel sind: Back to start button, ErgebnisButton und der
                                      // RestartButton

    String[] stp = { "Schere", "Stein", "Papier" };
    String[] Texte = { "Hier steht was du wählst", "Hier steht was der PC wählt" };

    ImageIcon papierIcon = new ImageIcon("Images/Papier.jpg");
    ImageIcon steinIcon = new ImageIcon("Images/Stein.jpg");
    ImageIcon schereIcon = new ImageIcon("Images/Schere.png");

    String Text2 = "Deine Wahl ist: ";
    String Text4 = "Der PC wählt: ";

    Integer PlayerChoice = 0;
    String ComputerChoice;

    JButton restarButton = new JButton("Noch eine Runde?");
    JButton backToStart = new JButton("Wieder zurück zum Start?");

    public Game_Frame() {

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.white);

        frame.addKeyListener(new MyKeyAdapter());

        frame.setTitle("Schere Stein Papier");

        buttonPanel.setLayout(new GridLayout(1, 0));
        buttonPanel.setBackground(new Color(150, 150, 150));
        buttonPanel.setPreferredSize(new Dimension(266, 220));

        for (int i = 0; i < 3; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("SansSerif", Font.BOLD, 50));
            buttons[i].setFocusable(true);
            buttons[i].addActionListener(this);
            buttons[i].setEnabled(true);
            buttons[i].setContentAreaFilled(true);
            buttons[i].setBorderPainted(false);
            ;
            buttons[i].setVisible(true);
            buttons[i].setBackground(Color.WHITE);
            if (i == 0) {
                buttons[i].setIcon(schereIcon);
            }
            if (i == 1) {
                buttons[i].setIcon(steinIcon);
            }
            if (i == 2) {
                buttons[i].setIcon(papierIcon);
            }

        }

        labelPanel.setLayout(new GridLayout(1, 0));
        labelPanel.setPreferredSize(new Dimension(400, 200));

        for (int i = 0; i < 2; i++) {

            labels[i] = new JButton();
            labelPanel.add(labels[i]);
            labels[i].setText(Texte[i]);
            labels[i].setBorderPainted(false);
            labels[i].setContentAreaFilled(true);
            labels[i].setFocusable(false);
            labels[i].setEnabled(false);
            if (i == 0) {
                labels[i].setBackground(Color.RED);
            } else {
                labels[i].setBackground(Color.BLUE);
            }
            labels[i].setFocusable(false);
            labels[i].setEnabled(true);
            labels[i].setForeground(Color.BLACK);
            labels[i].setFont(new Font("SansSerif", Font.BOLD, 25));

        }

        Ergebnis.setBorderPainted(false);
        Ergebnis.setEnabled(true);
        Ergebnis.setFocusable(false);
        Ergebnis.setForeground(Color.BLACK);
        Ergebnis.setContentAreaFilled(false);
        Ergebnis.setHorizontalAlignment(SwingConstants.LEFT);
        Ergebnis.setBorderPainted(false);
        Ergebnis.setFont(new Font("SansSerif", Font.BOLD, 50));

        Ergebniss.add(Ergebnis);

        restarButton.setBackground(Color.YELLOW);
        restarButton.setVisible(true);
        restarButton.setFocusable(true);
        restarButton.addActionListener(this);

        backToStart.setBackground(Color.YELLOW);
        backToStart.setVisible(true);
        backToStart.setFocusable(true);
        backToStart.addActionListener(this);

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
            PlayerChoice = 1; // Wahl Schere
            for (int i = 0; i < 3; i++) {
                buttons[i].setEnabled(false);
            }
            PCTurn();
        }
        if (e.getSource() == buttons[1]) {
            labels[0].setText(Text2 + stp[1]);
            PlayerChoice = 2; // Wahl Stein
            for (int i = 0; i < 3; i++) {
                buttons[i].setEnabled(false);
            }
            PCTurn();
        }
        if (e.getSource() == buttons[2]) {
            labels[0].setText(Text2 + stp[2]);
            PlayerChoice = 3; // Wahl Papier
            for (int i = 0; i < 3; i++) {
                buttons[i].setEnabled(false);
            }
            PCTurn();
        }
        if (e.getSource() == restarButton) {
            for (int i = 0; i < 3; i++) {
                buttons[i].setEnabled(true);
                labels[i].setText(Texte[i]);
                Ergebnis.setText(ErgebnissText);
                frame.remove(restarButton);
                frame.remove(backToStart);
            }
        }
        if (e.getSource() == backToStart) {
            frame.dispose();
            Main.startingWindow2();
        }

    }

    public void GewinnerErmitlung() {
        if (PlayerChoice.equals(1) && ComputerChoice.equals("Schere")) {
            Ergebnis.setText("Unentschieden");
        }
        if (PlayerChoice.equals(1) && ComputerChoice.equals("Papier")) {
            Ergebnis.setText("Du gewinnst");
        }
        if (PlayerChoice.equals(1) && ComputerChoice.equals("Stein")) {
            Ergebnis.setText("<html> <p>Der Computer <br>  gewinnt </p></html>");
        }
        if (PlayerChoice.equals(2) && ComputerChoice.equals("Schere")) {
            Ergebnis.setText("Du gewinnst");
        }
        if (PlayerChoice.equals(2) && ComputerChoice.equals("Papier")) {
            Ergebnis.setText("<html> <p>Der Computer <br> gewinnt </p></html>");
        }
        if (PlayerChoice.equals(2) && ComputerChoice.equals("Stein")) {
            Ergebnis.setText("Unentschieden");
        }
        if (PlayerChoice.equals(3) && ComputerChoice.equals("Schere")) {
            Ergebnis.setText("<html> <p>Der Computer <br> gewinnt </p></html>");
        }
        if (PlayerChoice.equals(3) && ComputerChoice.equals("Papier")) {
            Ergebnis.setText("Unentschieden");
        }
        if (PlayerChoice.equals(3) && ComputerChoice.equals("Stein")) {
            Ergebnis.setText("Du gewinnst");
        }

        frame.add(restarButton, BorderLayout.EAST);
        frame.add(backToStart, BorderLayout.WEST);
    }

    public class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) { // KeyListener, um die Snake steuern zu können und auch um das Spiel zu
                                             // verlassen
            switch (e.getKeyCode()) {

                case KeyEvent.VK_Q:
                    Main.RockPaperScissorClose();
                    Main.startingWindow2();
                    break;
            }
        }
    }

    public void close() {
        frame.dispose();
    }
}
