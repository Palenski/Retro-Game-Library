package StonePaperScissor;

import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;

public class StonePaperScissorMain {

    JFrame frame;

    StonePaperScissorMain() {
        // creating instance of JFrame with name "Schere Stein Papier"
        frame = new JFrame("Schere Stein Papier");

        final JLabel tf = new JLabel("Was wählst du?");
        tf.setBounds(160, 50, 150, 20);

        // creates instance of JButton
        JButton button = new JButton("Stein");

        button.setBounds(200, 200, 90, 50);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText("Du wählst Stein.");

            }
        });

        JButton button1 = new JButton("Papier");

        button1.setBounds(300, 200, 90, 50);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText("Du wählst Papier.");

            }
        });

        JButton button2 = new JButton("Schere");

        button2.setBounds(400, 200, 90, 50);

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText("Du wählst Schere.");

            }
        });

        // setting close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // adds button in JFrame
        frame.add(button);
        frame.add(button1);
        frame.add(button2);
        frame.add(tf);

        // sets 500 width and 600 height
        frame.setSize(800, 600);

        // uses no layout managers
        frame.setLayout(null);

        // makes the frame visible
        frame.setVisible(true);
    }

    final static int ROCK = 1, SCISSOR = 2, PAPER = 3;

    public static void main(String[] args) {
        new StonePaperScissorMain();
        Scanner scan = new Scanner(System.in);
        System.out.println("Player 1: Choose (1) - Rock, (2) - Scissors, or (3) - Paper: ");
        int player1 = scan.nextInt();
        System.out.println("Player 2: Choose (1) - Rock, (2) - Scissors, or (3) - Paper: ");
        int player2 = scan.nextInt();

        if (player1 == player2) {
            System.out.print("It is a tie");
        } else {
            switch (player1) {
                case ROCK:
                    if (player2 == SCISSOR)
                        System.out.print("Spieler gewinnt!");
                    else
                        System.out.print("Computer gewinnt!");
                    break;
                case SCISSOR:
                    if (player2 == PAPER)
                        System.out.print("Spieler gewinnt!");
                    else
                        System.out.print("Computer gewinnt!");
                    break;
                case PAPER:
                    if (player2 == ROCK)
                        System.out.print("Spieler gewinnt!");
                    else
                        System.out.print("Computer gewinnt!");
                    break;
            }
        }

    }

}
