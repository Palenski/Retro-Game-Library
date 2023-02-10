package TicTacToe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;



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
                        Überprüfung();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        TextFeld.setText("X ist am Zug");
                        Überprüfung();
                    }
                }
            }
        }

    }

    public void firstTurn() {

        try { // zuerst wird der Titel angezeigt, nach 2000 Millisekunden dann wer am Zug ist
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            
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

    public void Überprüfung() {
        // überprüfen ob X gewinnt
        if ((buttons[0].getText() == "X") &&
                (buttons[1].getText() == "X") &&
                (buttons[2].getText() == "X")) {
            xWins(0, 1, 2);
        }
        
        if ((buttons[3].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[5].getText() == "X")) {
            xWins(3, 4, 5);
        }

        if ((buttons[6].getText() == "X") &&
                (buttons[7].getText() == "X") &&
                (buttons[8].getText() == "X")) {
            xWins(6, 7, 8);
        }

        if ((buttons[0].getText() == "X") &&
                (buttons[3].getText() == "X") &&
                (buttons[6].getText() == "X")) {
            xWins(0, 3, 6);
        }

        if ((buttons[1].getText() == "X") &&
                (buttons[7].getText() == "X") &&
                (buttons[4].getText() == "X")) {
            xWins(1, 7, 4);
        }

        if ((buttons[2].getText() == "X") &&
                (buttons[5].getText() == "X") &&
                (buttons[8].getText() == "X")) {
            xWins(2, 5, 8);
        }

        if ((buttons[0].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[8].getText() == "X")) {
            xWins(0, 4, 8);
        }

        if ((buttons[2].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[6].getText() == "X")) {
            xWins(2, 4, 6);
        }

        // überprüfen ob O gewinnt

        if ((buttons[0].getText() == "O") &&
                (buttons[1].getText() == "O") &&
                (buttons[2].getText() == "O")) {
            oWins(0, 1, 2);
        }

        if ((buttons[3].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[5].getText() == "O")) {
            oWins(3, 4, 5);
        }

        if ((buttons[6].getText() == "O") &&
                (buttons[7].getText() == "O") &&
                (buttons[8].getText() == "O")) {
            oWins(6, 7, 8);
        }

        if ((buttons[0].getText() == "O") &&
                (buttons[3].getText() == "O") &&
                (buttons[6].getText() == "O")) {
            oWins(0, 3, 6);
        }

        if ((buttons[1].getText() == "O") &&
                (buttons[7].getText() == "O") &&
                (buttons[4].getText() == "O")) {
            oWins(1, 7, 4);
        }

        if ((buttons[2].getText() == "O") &&
                (buttons[5].getText() == "O") &&
                (buttons[8].getText() == "O")) {
            oWins(2, 5, 8);
        }

        if ((buttons[0].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[8].getText() == "O")) {
            oWins(0, 4, 8);
        }

        if ((buttons[2].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[6].getText() == "O")) {
            oWins(2, 4, 6);
        }

    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        TextFeld.setText("X hat gewonnen!");

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        TextFeld.setText("O hat gewonnen!");

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
    }

    public void Draw(){
        TextFeld.setText("Unentschieden");
    }
}