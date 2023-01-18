
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class StartingWindow implements ActionListener {

    JFrame frame = new JFrame();

    JButton typingButton = new JButton();

    StartingWindow() {

        typingButton.addActionListener(this);
        frame.add(typingButton);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1750, 750);

        frame.setSize(1000, 650);

        frame.setTitle("Anmeldung");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    public void actionPerformed(ActionEvent e) { // einfache Weiterleitung an die verschiedenen Fenster
        if (e.getSource() == typingButton) {
            frame.dispose();
            
        }

        }
    }


