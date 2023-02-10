package TicTacToe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import org.w3c.dom.Text;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel Titel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel TextFeld = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TicTacToe() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        TextFeld.setBackground(new Color(25, 25, 25));
        TextFeld.setForeground(new Color(25, 255, 0));
        TextFeld.setFont(new Font("Ink Free", Font.BOLD, 75));
        TextFeld.setHorizontalAlignment(JLabel.CENTER);
        TextFeld.setText("TicTacToe");
        TextFeld.setOpaque(true);

        Titel.setLayout(new BorderLayout());
        Titel.setBounds(0, 0, 800, 100);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        Titel.add(TextFeld);
        frame.add(Titel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        TextFeld.setText("O ist am Zug");
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        TextFeld.setText("X ist am Zug");
                    }
                }
            }
        }

    }

    public void firstTurn() {

        try { // zuerst wird der Titel angezeigt, nach 2000 Millisekunden dann wer am Zug ist
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) { // es wird ausgelost wer zuerst am Zug ist
            player1_turn = true;
            TextFeld.setText("X ist am Zug");
        } else {
            player1_turn = false;
            TextFeld.setText("O ist am Zug");
        }
    }

    public void check() {

    }

    public void xWins(int a, int b, int c) {

    }

    public void oWins(int a, int b, int c) {

    }
}
