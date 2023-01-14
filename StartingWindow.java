
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class StartingWindow implements ActionListener {

    JFrame frame = new JFrame();

    JButton titleButton = new JButton("Bitte wählen Sie eine der Optionen");

    JButton einzahlButton = new JButton("Einzahlen");
    JButton auszahlButton = new JButton("Auszahlen");

    JButton transaktionButton = new JButton("Transaktionen");
    JButton kontoauszugButton = new JButton("Kontoauszug");

    JButton logOutButton = new JButton("Log Out");

    StartingWindow() {

        einzahlButton.setBounds(5, 110, 398, 50);
        einzahlButton.setFocusable(false);
        einzahlButton.addActionListener(this);

        auszahlButton.setBounds(5, 170, 398, 50);
        auszahlButton.setFocusable(false);
        auszahlButton.addActionListener(this);

        transaktionButton.setBounds(5, 230, 398, 50);
        transaktionButton.setFocusable(false);
        transaktionButton.addActionListener(this);

        kontoauszugButton.setBounds(5, 290, 398, 50);
        kontoauszugButton.setFocusable(false);
        kontoauszugButton.addActionListener(this);

        logOutButton.setBounds(5, 350, 398, 50);
        logOutButton.setFocusable(false);
        logOutButton.addActionListener(this);

        titleButton.setBounds(0, 0, 410, 100);
        titleButton.addActionListener(this);
        titleButton.setFocusable(false);
        titleButton.setFont(new Font(null, Font.BOLD, 23));
        titleButton.setContentAreaFilled(false);
        titleButton.setBorderPainted(false);

        frame.add(titleButton);

        frame.add(einzahlButton);
        frame.add(auszahlButton);
        frame.add(transaktionButton);
        frame.add(kontoauszugButton);
        frame.add(logOutButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000, 650);

        frame.setTitle("Anmeldung");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    public void actionPerformed(ActionEvent e) { // einfache Weiterleitung an die verschiedenen Fenster
        if (e.getSource() == einzahlButton) {
            // frame.dispose();
            // Main.einzahlen();
            System.out.println("Test 1");

        }
        if (e.getSource() == auszahlButton) {
            // frame.dispose();
            // Main.auszahlen();
            System.out.println("Test 2");

        }
        if (e.getSource() == transaktionButton) {
            // frame.dispose();
            // Main.transaktionen();
            System.out.println("Test 3");

        }
        if (e.getSource() == kontoauszugButton) {
            // frame.dispose();
            // Main.kontoauszug();
            System.out.println("Test 4");

        }
        if (e.getSource() == logOutButton) {
            frame.dispose();

        }
    }

}
