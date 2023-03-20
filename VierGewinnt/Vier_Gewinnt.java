package VierGewinnt;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.tree.DefaultTreeCellEditor;

import Main.Main;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public final class Vier_Gewinnt extends JFrame implements ActionListener {

    private int größe; // Board größe
    private int reihenfolge = 0; // First player 1 will play the game
    private int spielerAnzahl; // Player number
    private int feldGröße;
    private static int leereFelder = 0; // Number of living cells

    private final JFrame frame; // Frame
    private final JPanel panel; // Panel
    private final JButton[][] buttons; // Buttons
    private Felder spielfeld[][]; // Game Board
    private final GridLayout grid; // GridLayout

    ImageIcon leer = new ImageIcon("Images/emptycell.png");
    ImageIcon spieler1 = new ImageIcon("Images/player1.png");
    ImageIcon spieler2 = new ImageIcon("Images/player2.png");

    public Vier_Gewinnt() {
        frame = new JFrame("Vier Gewinnt");
        panel = new JPanel();

        spielerUndFeld(); // Get the game parameters
        spielErstellen(); // Create 2D dynamic Cell array

        buttons = new JButton[getBordGröße()][getBordGröße()]; // Button als Array
        grid = new GridLayout(getBordGröße(), getBordGröße()); // Erzeugt Gridlayout
        panel.setLayout(grid);

        // Initialization board
        bordInitialisieren();
        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setBordGröße(int neueGröße) {
        größe = neueGröße;
    }

    public int getBordGröße() {
        return größe;
    }

    public static int anzahlLeererFelder() {
        return leereFelder;
    }

    /**
     * Get the player number and board größe from the user
     */
    public void spielerUndFeld() {
        // User inputs from input dialogs
        String anzahlSpieler = JOptionPane.showInputDialog("Spieler Anzahl (1 oder 2)"); // Anzahl der Spieler

        try { // Falls der User keine Zahl eingibt
            spielerAnzahl = Integer.parseInt(anzahlSpieler);
        } catch (Exception e) {
            JFrame frameInputError = new JFrame();
            JOptionPane.showMessageDialog(frameInputError,
                    "Wähle zwischen 1 oder 2 Spielern !!!",
                    "Spieler Anzahl Fehler",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        if (spielerAnzahl != 1 && spielerAnzahl != 2) { // Falls der User nicht 1 oder 2 Auswählt
            JFrame frameInputError = new JFrame();
            JOptionPane.showMessageDialog(frameInputError,
                    "Wähle zwischen 1 oder 2 Spielern !!!",
                    "Spieler Anzahl Fehler",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        String größeFeld = JOptionPane.showInputDialog("Spielfeldgröße (mind. 4) "); // Größe des Feldes

        try { // Falls der User keine Zahl eingibt
            feldGröße = Integer.parseInt(größeFeld);

        } catch (Exception e) {
            JFrame frameInputError = new JFrame();
            JOptionPane.showMessageDialog(frameInputError,
                    "Spielfeld muss größer sein als 4 !!!",
                    "Spiel Feld Fehler",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        if (feldGröße < 4) { // Falls der User eine kleinere Zahl als 4 wählt
            JFrame frameInputError = new JFrame();
            JOptionPane.showMessageDialog(frameInputError,
                    "Spielfeld muss größer sein als 4 !!!",
                    "Spiel Feld Fehler",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        setBordGröße(feldGröße);
    }

    public void spielErstellen() { // Spielfeld als 2d Array
        spielfeld = new Felder[getBordGröße()][getBordGröße()];
        for (int i = 0; i < getBordGröße(); i++) {
            for (int j = 0; j < getBordGröße(); j++) {
                spielfeld[i][j] = new Felder();
            }
        }
    }

    /**
     * Add buttons to game board
     */
    public void buttonHinzufügen() {
        for (int i = 0; i < getBordGröße(); ++i) {
            for (int j = 0; j < getBordGröße(); ++j) {
                buttons[i][j] = new JButton(leer); // leer button

                if (spielerAnzahl == 1) // Computer vs Spieler
                {
                    buttons[i][j].addActionListener(new einSpielerListener());
                }

                if (spielerAnzahl == 2) // Spieler vs Spieler
                {
                    buttons[i][j].addActionListener(new zweiSpielerListener());
                }

                panel.add(buttons[i][j]);
            }
        }
    }

    /**
     * Initial all cells to leer
     */
    public void bordInitialisieren() {
        for (int i = getBordGröße() - 2; i >= 0; --i) {
            for (int j = getBordGröße() - 1; j >= 0; --j) {
                spielfeld[i][j].setFeldStatus(-99);
            }
        }
        buttonHinzufügen(); // Fügt die Buttons plus die Listener hinzu
    }

    public void unentschieden(int p) { // Guckt, ob alle Felder ausgefüllt sind und niemand gewonnen hat
        for (int i = getBordGröße() - 2; i >= 0; --i) {
            for (int j = getBordGröße() - 1; j >= 0; --j) {
                if (spielfeld[i][j].getFeldStatus() == 1 || spielfeld[i][j].getFeldStatus() == 2) {
                    if (p == feldGröße * (feldGröße - 1)) {
                        endergebnis(0);
                    }
                    p++;
                }

            }
        }
    }

    /**
     * Game winning state
     * If the four cell is same, user 1 will win the game
     * 
     * @param gewinner integer If the player 1 is equal to 1, otherwise 2
     */

    public void gewinnen(int gewinner) {
        for (int i = 0; i < getBordGröße(); ++i) {
            for (int j = 0; j < getBordGröße(); ++j) {

                if (spielfeld[i][j].getFeldStatus() == gewinner) {
                    if (i + 3 < getBordGröße()) { // Ob Zellen überhaupt da sind
                        if (spielfeld[i + 1][j].getFeldStatus() == gewinner
                                && spielfeld[i + 2][j].getFeldStatus() == gewinner
                                && spielfeld[i + 3][j].getFeldStatus() == gewinner) { // Von oben nach unten
                            if (gewinner == 1) // 1 bedeutet Spieler 1
                                endergebnis(1);
                            else
                                endergebnis(2);
                        }
                    }

                    if (j + 3 < getBordGröße()) { // Ob Zellen überhaupt da sind
                        if (spielfeld[i][j + 1].getFeldStatus() == gewinner
                                && spielfeld[i][j + 2].getFeldStatus() == gewinner
                                && spielfeld[i][j + 3].getFeldStatus() == gewinner) { // Von Links nach Rechts
                            if (gewinner == 1)
                                endergebnis(1);
                            else
                                endergebnis(2);
                        }
                    }

                    if (i < getBordGröße() - 3 && j < getBordGröße() - 3) { // Ob Zellen überhaupt da sind
                        if (spielfeld[i + 1][j + 1].getFeldStatus() == gewinner
                                && spielfeld[i + 2][j + 2].getFeldStatus() == gewinner
                                && spielfeld[i + 3][j + 3].getFeldStatus() == gewinner) { // Diagonale Links nach Rechts
                            if (gewinner == 1)
                                endergebnis(1);
                            else
                                endergebnis(2);
                        }
                    }

                    if (i < getBordGröße() - 3 && j - 3 >= 0) { // Ob Zellen überhaupt da sind
                        if (spielfeld[i + 1][j - 1].getFeldStatus() == gewinner
                                && spielfeld[i + 2][j - 2].getFeldStatus() == gewinner
                                && spielfeld[i + 3][j - 3].getFeldStatus() == gewinner) { // Diagonale Rechts nach Links
                            if (gewinner == 1)
                                endergebnis(1);
                            else
                                endergebnis(2);
                        }
                    }
                }
            }
        }
    }

    public void endergebnis(int sieger) {
        JFrame endergebnisFrame = new JFrame(); // Neuer Gewinnerframe
        if (sieger == 1) {
            JOptionPane.showMessageDialog(
                    endergebnisFrame,
                    "\nGewinner : Spieler 1\n\nDas neue Spiel startet.\n\n",
                    "Spiel Benden",
                    JOptionPane.INFORMATION_MESSAGE);
            erneutSpielen();
        } else if (sieger == 0) {
            JOptionPane.showMessageDialog(
                    endergebnisFrame,
                    "\nUnentschieden : Keiner hat gewonnen\n\nDas neue Spiel startet.\n\n",
                    "Spiel Benden",
                    JOptionPane.INFORMATION_MESSAGE);
            erneutSpielen();
        } else {
            JOptionPane.showMessageDialog(
                    endergebnisFrame,
                    "\nGewinner : Spieler 2\n\nDas neue Spiel startet.\n\n",
                    "Spiel Benden",
                    JOptionPane.INFORMATION_MESSAGE);
            erneutSpielen();
        }
        endergebnisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void erneutSpielen() {
        for (int i = 0; i < getBordGröße(); ++i) {
            for (int j = 0; j < getBordGröße(); ++j) {
                spielfeld[i][j].setFeldStatus(-99); // Initial Value
                buttons[i][j].setIcon(leer); // Put the leer cell icon
            }
        }

        frame.setVisible(false); // Unvisible previous game board
        Main.vierGewinnt();
    }

    /**
     *
     * Action listener to game button
     * Computer vs Player 1
     * 
     */

    public class einSpielerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                for (int i = getBordGröße() - 1; i >= 0; --i) // Check the buttons up to down position
                {
                    for (int j = 0; j <= getBordGröße() - 1; ++j) {
                        // Get the button component that was clicked
                        if (buttons[i][j] == e.getSource()) {

                            if (0 == reihenfolge % 2) // Player 1 operations
                            {
                                for (int k = 0; k <= getBordGröße(); ++i) {
                                    // Player 1 Operations
                                    // Fill the board from down to up
                                    if (spielfeld[i - k][j].getFeldStatus() == 0) {
                                        buttons[i - k][j].setIcon(spieler1); // Change button icon
                                        spielfeld[i - k][j].setAllePosition('X', i); // Set cell parameters
                                        spielfeld[i - k][j].setFeldStatus(1); // Set cell state
                                        ++leereFelder; // Increase living cell number
                                        gewinnen(1); // Check game winning state
                                        unentschieden(1);
                                        break;
                                    }
                                }

                                obereReihe(i, j); // Set the upper cells to leer cell to listen button
                                ++reihenfolge; // Change player order from player 1 to computer
                                break;
                            }

                            // Computer Operations
                            // Basic idea is filling the cells left to right

                            if (1 == reihenfolge % 2) {
                                computerZug(i);
                                unentschieden(1);
                                ++reihenfolge; // Change player order from computer to player 1
                                break;
                            } else {
                                warnung();
                            }
                        } // END EVENT SOURCE
                    } // END SECOND FOR LOOP
                } // END FIRST FOR LOOP

            } // END TRY
            catch (Exception ex) {
                warnung();
            }

        } // END ACTION PERFORMED

    } // END listenButtonOnePlayer CLASS

    public void warnung() {
        JFrame warnungFrame = new JFrame();
        JOptionPane.showMessageDialog(
                warnungFrame,
                "Nicht möglicher Zug !!\nDas Feld ist besetzt!", "Verwarnung",
                JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Set the upper cells to leer cell to listen button
     * 
     * @param rowPos    integer row position to board
     * @param columnPos integer column position to board
     */
    public void obereReihe(int rowPos, int columnPos) {
        try {
            spielfeld[rowPos - 1][columnPos].setFeldStatus(0);
        } catch (Exception ex) {
        }
    }

    /**
     * Computer's logic fills cells from left to right
     * 
     * @param rowPosition Cell row position
     */
    public void computerZug(int reihenPosition) {
        int l;
        int m;
        boolean platzhalter = false;

        for (l = getBordGröße() - 1; (l >= 0) && !platzhalter; --l) {
            for (m = 0; (m < getBordGröße()) && !platzhalter; ++m) {
                if (spielfeld[l][m].getFeldStatus() == 0) {
                    buttons[l][m].setIcon(spieler2); // Set new button icon
                    spielfeld[l][m].setAllePosition('O', reihenPosition); // Set cell parameters
                    spielfeld[l][m].setFeldStatus(2); // Set cell state
                    ++leereFelder;
                    gewinnen(2); // Check the computer winning state
                    platzhalter = true;
                    obereReihe(l, m);
                }
            }
        }
    }

    /**
     * Action listener to game button
     * Player 1 vs Player 2
     */
    public class zweiSpielerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int spielerZugIcon = 0;
                int spielerZug = 0;

                for (int i = getBordGröße() - 1; i >= 0; --i) {
                    for (int j = 0; j <= getBordGröße() - 1; ++j) {
                        if (spielerZugIcon == 0 && buttons[i][j] == e.getSource()) { // Get the button component that
                                                                                     // was clicked
                            if (spielerZug == 0 && reihenfolge % 2 == 0) {
                                // Player 1 Operations
                                // Fill the board from down to up
                                for (int k = 0; k <= getBordGröße(); ++i) {
                                    if (spielfeld[i - k][j].getFeldStatus() == 0 && reihenfolge % 2 == 0) {
                                        buttons[i - k][j].setIcon(spieler1); // Set new icon to player 1
                                        spielfeld[i - k][j].setAllePosition('X', i); // Set cell parameters
                                        spielfeld[i - k][j].setFeldStatus(1);
                                        ++leereFelder; // Increase living cell number
                                        gewinnen(1); // Check player 1 winning state
                                        spielerZug = 1;
                                        spielerZugIcon = 1;
                                        break;
                                    }
                                }
                                obereReihe(i, j); // Set upper cell to leer
                                unentschieden(1);
                                ++reihenfolge; // Change order from player 1 to player 2
                                break;
                            }

                            // Player 2 operations
                            if (spielerZug == 0 && reihenfolge % 2 == 1) {
                                for (int k = 0; k <= getBordGröße(); ++i) {
                                    if (spielfeld[i - k][j].getFeldStatus() == 0 && reihenfolge % 2 == 1) {
                                        buttons[i - k][j].setIcon(spieler2); // Set new icon to player 2
                                        spielfeld[i - k][j].setAllePosition('O', i); // Set cell parameters
                                        spielfeld[i - k][j].setFeldStatus(2); // Set cell state
                                        ++leereFelder;
                                        gewinnen(2);
                                        unentschieden(1);
                                        spielerZug = 1;
                                        spielerZugIcon = 1;
                                        break;
                                    }
                                }
                                obereReihe(i, j);
                                ++reihenfolge;
                                break;
                            }
                        } // END EVENT SOURCE
                    } // END SECOND FOR LOOP
                } // END FIRST FOR LOOP
            } catch (Exception ex) {
                warnung();
            }

        } // END ACTIONPERFORMED
    } // END listenButtonTwoPlayers CLASS

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
