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
import java.awt.event.KeyListener;

public final class Vier_Gewinnt extends JFrame implements ActionListener {

    private int größe; 
    private int reihenfolge = 0; //Entscheidet, wer später als erstes beginnt
    private int spielerAnzahl;
    private int feldGröße;
    private static int leereFelder = 0; 

    private final JFrame frame; 
    private final JPanel panel; 
    private final JButton[][] buttons; 
    private Felder spielfeld[][];
    private final GridLayout grid; 

    ImageIcon leer = new ImageIcon("Images/emptycell.png");
    ImageIcon spieler1 = new ImageIcon("Images/player1.png");
    ImageIcon spieler2 = new ImageIcon("Images/player2.png");

    public Vier_Gewinnt() {
            
        frame = new JFrame("Vier Gewinnt");
        panel = new JPanel();
        panel.addKeyListener(new keyListener());
        
        spielerUndFeld(); 
        spielErstellen(); 

        buttons = new JButton[getBordGröße()][getBordGröße()]; // Button als Array
        grid = new GridLayout(getBordGröße(), getBordGröße()); // Erzeugt Gridlayout
        panel.setLayout(grid);

        bordInitialisieren();

        frame.setContentPane(panel);
        frame.pack();
        frame.addKeyListener(new keyListener());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void setBordGröße(int neueGröße) {       //Allgemeine Set und Get Methoden
        größe = neueGröße;
    }

    public int getBordGröße() {
        return größe;
    }

    public static int anzahlLeererFelder() {
        return leereFelder;
    }

    public void spielErstellen() {      // Spielfeld als 2d Array
        spielfeld = new Felder[getBordGröße()][getBordGröße()];
        for (int i = 0; i < getBordGröße(); i++) {
            for (int j = 0; j < getBordGröße(); j++) {
                spielfeld[i][j] = new Felder();
            }
        }
    }

    public void spielerUndFeld() {
        String anzahlSpieler = JOptionPane.showInputDialog("Spieler Anzahl (1 oder 2)"); // Anzahl der Spieler

        try {       // Falls der User keine Zahl eingibt
            spielerAnzahl = Integer.parseInt(anzahlSpieler);
        } catch (Exception e) {
            JFrame frameInputError = new JFrame();
            JOptionPane.showMessageDialog(frameInputError,
                    "Wähle zwischen 1 oder 2 Spielern !!!",
                    "Spieler Anzahl Fehler",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        if (spielerAnzahl != 1 && spielerAnzahl != 2) {     // Falls der User nicht 1 oder 2 Auswählt
            JFrame frameInputError = new JFrame();
            JOptionPane.showMessageDialog(frameInputError,
                    "Wähle zwischen 1 oder 2 Spielern !!!",
                    "Spieler Anzahl Fehler",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        String größeFeld = JOptionPane.showInputDialog("Spielfeldgröße (mind. 4) ");    // Größe des Feldes

        try {    // Falls der User keine Zahl eingibt
            feldGröße = Integer.parseInt(größeFeld);

        } catch (Exception e) {
            JFrame frameInputError = new JFrame();
            JOptionPane.showMessageDialog(frameInputError,
                    "Spielfeld muss größer sein als 4 !!!",
                    "Spiel Feld Fehler",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        if (feldGröße < 4) {    // Falls der User eine kleinere Zahl als 4 wählt
            JFrame frameInputError = new JFrame();
            JOptionPane.showMessageDialog(frameInputError,
                    "Spielfeld muss größer sein als 4 !!!",
                    "Spiel Feld Fehler",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        setBordGröße(feldGröße);
    }


    public void buttonHinzufügen() {
        for (int i = 0; i < getBordGröße(); ++i) {
            for (int j = 0; j < getBordGröße(); ++j) {
                buttons[i][j] = new JButton(leer);      //Dem Button werden hier die Icons hinzugefügt

                if (spielerAnzahl == 1) // Computer vs Spieler
                {
                    buttons[i][j].addActionListener(new einSpielerListener());      //Fügt den Buttons die ActionListener hinzu
                }

                if (spielerAnzahl == 2) // Spieler vs Spieler
                {
                    buttons[i][j].addActionListener(new zweiSpielerListener());
                }

                panel.add(buttons[i][j]);
            }
        }
    }


    public void bordInitialisieren() {      //Alle Felder sind am Anfang auf leer gesetzt
        for (int i = getBordGröße() - 2; i >= 0; --i) {
            for (int j = getBordGröße() - 1; j >= 0; --j) {
                spielfeld[i][j].setFeldStatus(-99);
            }
        }
        buttonHinzufügen(); // Fügt die Buttons plus die Listener hinzu
    }

    
    public void endergebnis(int sieger) {
        JFrame endergebnisFrame = new JFrame(); // Neuer Gewinnerframe
        if (sieger == 1) {
            JOptionPane.showMessageDialog(
                    endergebnisFrame,
                    "\nGewinner : Spieler 1\n\nDas neue Spiel startet.\n\n",
                    "Spiel Benden",
                    JOptionPane.INFORMATION_MESSAGE);
            erneutSpielen();        //Spiel wird wieder von vorne gestartet
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


    public void gewinnen(int gewinner) {        //Entscheidet wer gewonnen hat. Bei 1 ist es Spieler 1, ansonten Spieler 2
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
    

    public void obereReihe(int rowPos, int columnPos) {     //Damit der Computer weiß, wann die Reihen gefüllt sind
        try {
            spielfeld[rowPos - 1][columnPos].setFeldStatus(0);
        } catch (Exception ex) {
        }
    }


    public void warnung() {     //Für den Fall, dass der Spieler ein schon besetztes Feld angecklickt hat
        JFrame warnungFrame = new JFrame();     //Frame wird erstellt und mit Inhalt gefüllt
        JOptionPane.showMessageDialog(
                warnungFrame,
                "Nicht möglicher Zug !!\nDas Feld ist besetzt!", "Verwarnung",
                JOptionPane.WARNING_MESSAGE);
    }


    public void computerZug(int reihenPosition) {       //Erstellung der "KI"
        int l;
        int m;
        boolean platzhalter = false;

        for (l = getBordGröße() - 1; (l >= 0) && !platzhalter; --l) {
            for (m = 0; (m < getBordGröße()) && !platzhalter; ++m) {
                if (spielfeld[l][m].getFeldStatus() == 0) {
                    buttons[l][m].setIcon(spieler2); 
                    spielfeld[l][m].setAllePosition('O', reihenPosition); 
                    spielfeld[l][m].setFeldStatus(2);       //Setzt den Status auf besetzt durch Spieler 2
                    leereFelder++;
                    gewinnen(2);     //Zur Ermittlung des Siegers    
                    platzhalter = true;
                    obereReihe(l, m);
                }
            }
        }
    }


    public void erneutSpielen() {
        for (int i = 0; i < getBordGröße(); ++i) {
            for (int j = 0; j < getBordGröße(); ++j) {
                spielfeld[i][j].setFeldStatus(-99);         // Felder werden wieder auf Leer gesetzt
                buttons[i][j].setIcon(leer);        //Die Anfangs Icons werden wieder hergestellt
            }
        }

        frame.dispose();    //Löscht den alten Frame
        Main.vierGewinnt(); //Und erstellt den Neuen
    }
    

        public class einSpielerListener implements ActionListener {     //Spieler vs Computer
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                for (int i = getBordGröße() - 1; i >= 0; --i){ // Ckeckt von oben nach unten
                    for (int j = 0; j <= getBordGröße() - 1; ++j) {
                        if (buttons[i][j] == e.getSource()) {
                            if (0 == reihenfolge % 2){   //Spieler 1 ist dann am Zug
                                for (int k = 0; k <= getBordGröße(); ++i) {
                                    if (spielfeld[i - k][j].getFeldStatus() == 0) {     //Sorgt im allgemeinen dafür, dass das Bord von unten nach oben gefüllt wird
                                        buttons[i - k][j].setIcon(spieler1);     // Button Icon wird verändert
                                        spielfeld[i - k][j].setAllePosition('X', i);    // Wichtig für Gewinn-Methode
                                        spielfeld[i - k][j].setFeldStatus(1);
                                        ++leereFelder; 
                                        gewinnen(1);        // Überprüft, ob Spieler 1 gewonnen hat
                                        unentschieden(1);           //Überprüft ob Unentschieden besteht
                                        break;
                                    }
                                }

                                obereReihe(i, j); 
                                reihenfolge++;      //Nach dem Zug ist der Computer dran
                                
                                break;
                            }

                            if (1 == reihenfolge % 2) {     //Dumme KI, welche von links nach rechts die Reihen auffüllt
                                java.util.concurrent.TimeUnit.SECONDS.sleep(2);
                                computerZug(i);
                                unentschieden(1);
                                reihenfolge++;      // Reihenfolge wird wieder geändert
                                break;
                            } else {
                                warnung();      //Falls der Spieler auf ein falsches Feld geklickt hat
                            }
                        }
                    } 
                }
            } 
            catch (Exception ex) {
                warnung();
            }
        }
    }


    public class zweiSpielerListener implements ActionListener {        //Selbes Prinzip wie oben, nur Spieler vs Spieler
        @Override       
        public void actionPerformed(ActionEvent e) {
            try {
                int spielerZugIcon = 0;
                int spielerZug = 0;

                for (int i = getBordGröße() - 1; i >= 0; --i) {
                    for (int j = 0; j <= getBordGröße() - 1; ++j) {
                        if (spielerZugIcon == 0 && buttons[i][j] == e.getSource()) {    //Zeigt dem Computer, welches Feld angeklickt wurde
                            if (spielerZug == 0 && reihenfolge % 2 == 0) {      //ermittlung, wer am Zug ist
                                for (int k = 0; k <= getBordGröße(); ++i) {
                                    if (spielfeld[i - k][j].getFeldStatus() == 0 && reihenfolge % 2 == 0) {
                                        buttons[i - k][j].setIcon(spieler1); 
                                        spielfeld[i - k][j].setAllePosition('X', i); 
                                        spielfeld[i - k][j].setFeldStatus(1);
                                        leereFelder++;
                                        gewinnen(1); // Checkt ob der Spieler gewonnen hat
                                        spielerZug = 1;
                                        spielerZugIcon = 1;
                                        break;
                                    }
                                }
                                obereReihe(i, j); 
                                unentschieden(1);
                                reihenfolge++;      //Ändert die Reihenfolge
                                break;
                            }

                            if (spielerZug == 0 && reihenfolge % 2 == 1) {      //Spieler 2 ist hier am Zug
                                for (int k = 0; k <= getBordGröße(); ++i) {
                                    if (spielfeld[i - k][j].getFeldStatus() == 0 && reihenfolge % 2 == 1) {
                                        buttons[i - k][j].setIcon(spieler2); 
                                        spielfeld[i - k][j].setAllePosition('O', i); 
                                        spielfeld[i - k][j].setFeldStatus(2);
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
                        }
                    } 
                } 
            } catch (Exception ex) {
                warnung();
            }
        } 
    } 


    public class keyListener implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_Q) {
                Main.startingWindow2();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_Q) {
                Main.startingWindow2();
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_Q) {
                Main.startingWindow2();
            }
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
       
    }

}
