package TicTacToe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import Main.Main;
import Pong.Paddle;

/*
 * Das Hauptspiel "Tic Tac Toe"
 */

public class TicTacToeGame implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel Titel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel TextFeld = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton RestartButton = new JButton();
    JButton BackToStart = new JButton();
    Paddle paddle1;
    Paddle paddle2;
    boolean player1_turn;

    int RundenZähler = 0; // wird pro Runde hochgezählt

    int XScore = 0; // Score von X (Spieler 1)
    int OScore = 0; // Score von O (Spieler 2)

    public TicTacToeGame() {

        /*
         * Wie der Frame aussieht
         */
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.addKeyListener(new MyKeyAdapter());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        

        /*
         * Wie das Textfeld (oben) aussieht
         */
        TextFeld.setBackground(new Color(0, 0, 0));
        TextFeld.setForeground(new Color(25, 255, 0));
        TextFeld.setFont(new Font("SansSerif", Font.BOLD, 65));
        TextFeld.setHorizontalAlignment(JLabel.CENTER);
        TextFeld.setText("TicTacToe");
        TextFeld.setOpaque(true);

        Titel.setLayout(new BorderLayout());
        Titel.setBounds(0, 0, 800, 100);

        /*
         * Es wird ein Grid erstellt, auf welchem die Buttons plaziert werden
         */
        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150));

        /*
         * Der Buttons, womit man das Spiel neustarten kann
         */
        RestartButton.setHorizontalAlignment(JButton.CENTER);
        RestartButton.setText("Neustart?");
        RestartButton.addActionListener(this);
        RestartButton.setBackground(Color.DARK_GRAY);
        RestartButton.setBorderPainted(false);
        RestartButton.setVisible(true);

        /*
         * Das Grid für die Buttons wird erstellt
         * Es ist 3x3 groß
         */
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("SansSerif", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setEnabled(false);
            buttons[i].setBackground(new Color(0, 0, 0));

        }

        /*
         * Der Titel und das Grid werden hinzugefügt
         */
        Titel.add(TextFeld);
        frame.add(Titel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();

    }


    public void actionPerformed(ActionEvent e) { //wenn der Button gedrückt wird, dann wird das hier genannte ausgeführt
        /*
         *  Wenn das Boolean player1_turn = True ist, dann ist Spieler 1 am Zug, wenn player1_turn = false ist, dann ist Spieler 2 am Zug
         */
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) { //wenn unten ausgelost wurde das Spieler 1 anfängt dann greift diese Schleife (siehe Zeile 147 - 153)
                    if (buttons[i].getText() == "") { //Wenn der Button noch nicht benutzt wurde (man kann dadurch keinen Button überschreiben)
                        buttons[i].setForeground(new Color(255, 0, 0)); //Bei Spieler 1 ist die Schrift Rot (in RGB angegeben)
                        buttons[i].setText("X"); //es wird X reingeschrieben
                        player1_turn = false; //Danach ist Spieler 2 dran
                        TextFeld.setText("X:" + XScore + "    O ist am Zug   " + "O:" + OScore); //Im Textfeld wird angezeigt, dass nun 
                        Überprüfung(); //es wird geprüft, ob ein Spieler gewonnen
                        RundenZähler++; //der Rundenzähler geht einen hoch
                    }
                } else { //das selbe wie in Zeile 105 - 113 nur für O
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255)); //Blau
                        buttons[i].setText("O"); //Es wird O in das Feld geschrieben
                        player1_turn = true; //Spieler 1 ist am Zug
                        TextFeld.setText("X:" + XScore + "    X ist am Zug   " + "O:" + OScore);
                        Überprüfung(); //es wird geprüft, ob ein Spieler gewonnen
                        RundenZähler++; //der Rundenzähler geht einen hoch
                    }
                }
            }
        }

        if (e.getSource() == RestartButton) { //Das Feld wird zurückgesetzt für die nächste Runde
            for (int i = 0; i < 9; i++) {
                buttons[i].setText("");
                buttons[i].setEnabled(true);
                buttons[i].setForeground(new Color(0, 0, 0));
                buttons[i].setBackground(Color.BLACK);
            }
            RestartButton.setVisible(false);
        }
    }

    public class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_Q:
                    close();
                    Main.startingWindow2();
                    break;
            }
        }
    }

    public void firstTurn() {

        try { // zuerst wird der Titel angezeigt, nach 2000 Millisekunden dann wer am Zug ist
            Thread.sleep(0);
            TextFeld.setText("Tic Tac Toe");
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        /*
         * es wird bestimmt wer anfängt
         * eine zufällige Zahl zwischen 0 und 1 wird generiert:
         * wenn die Zahl 0 ist, dann fängt Spieler 1 an (X). Anderenfalls beginnt
         * Spieler 2 (O)
         * Dies wird daraufhin oben im Textfeld angezeigt
         */
        if (random.nextInt(2) == 0) { // es wird ausgelost wer zuerst am Zug ist
            player1_turn = true;
            TextFeld.setText("X:" + XScore + "    O ist am Zug   " + "O:" + OScore);
        } else {
            player1_turn = false;
            TextFeld.setText("O ist am Zug");
        }

        /*
         * Die Buttons auf dem Grid können benutzt werden
         */
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(true);
        }
    }

    public void Überprüfung() {
        /*
         * Es wird nach jedem Zu danch geprüft, ob jemand gewonnen hat
         * Dies wird dadurch gemacht, dass alle Optionen aufgelistet sind in dieser
         * Methode
         * Abhänig davon wer gewinnt, wird die entsprechende Methode aufgerufen und die
         * Werte für die
         * richtige Buttons weiter gegeben
         */
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

        /*
         * Wenn der Rundenzähl auf 9 ist und keine der oben aufgeführten Optionen in
         * Kraft tat, dann liegt ein Unentschieden vor.
         * Die Buttons können dann nicht mehr benutzt werden und oben im Textfeld wird
         * angezeigt das es sich um ein Unetschieden handelt
         */
        if (RundenZähler == 9) {
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(false);
            }

            TextFeld.setText("Unentschieden");
        }

    }

    public void xWins(int a, int b, int c) {

        /*
         * Wenn Spieler 1 (X) gewonnen hat werden die Knöpfe die zum Sieg führen rot
         */
        buttons[a].setBackground(Color.RED);
        buttons[b].setBackground(Color.RED);
        buttons[c].setBackground(Color.RED);

        /*
         * Auf dem Textfeld wird angezeigt das X gewonnen hat
         * Der Score von Spieler 1 geht einen hoch
         * Der Rundenzähler wird zurück auf 0 gesetzt für die nächste Runde
         */
        TextFeld.setText("X hat gewonnen!");
        RestartButton.setVisible(true);
        XScore++;
        RundenZähler = 0;

        /*
         * Die Buttons werden Disabled
         * Und der Restartbutton wird hinzugefügt
         */
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        frame.add(RestartButton, BorderLayout.PAGE_END);
    }

    public void oWins(int a, int b, int c) {

        /*
         * Wenn Spieler 2 (O) gewonnen hat werden die Knöpfe die zum Sieg führen blau
         */
        buttons[a].setBackground(Color.BLUE);
        buttons[b].setBackground(Color.BLUE);
        buttons[c].setBackground(Color.BLUE);

        /*
         * Auf dem Textfeld wird angezeigt das O gewonnen hat
         * Der Score von Spieler 2 geht einen hoch
         * Der Rundenzähler wird zurück auf 0 gesetzt für die nächste Runde
         */
        TextFeld.setText("O hat gewonnen!");
        RestartButton.setVisible(true);
        OScore++;
        RundenZähler = 0;

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        frame.add(RestartButton, BorderLayout.SOUTH);

    }

    public void Draw() {

        TextFeld.setText("Unentschieden");

        for (int i = 0; i < 9; i++) {
            buttons[i].remove(i);
        }

        frame.add(RestartButton, BorderLayout.SOUTH);

    }

    public void close(){
        frame.dispose();
    }

}