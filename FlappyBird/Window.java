
import java.awt.Color;
import java.io.IOException;
import java.net.ServerSocket;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Window extends JFrame{
    public Window(int Breite, int Höhe, String titel, Game game) {
       try {
        game.serverSocket = new ServerSocket(9999);
    } catch (IOException e) {
       System.out.println("Spiel bereits gestartet");
       System.exit(0);
    }
       
        setTitle(titel);
       pack();
       setSize(Breite + getInsets().left + getInsets().right, Höhe + getInsets().top + getInsets().bottom);
       setLocationRelativeTo(null);
       setResizable(false);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
       setBackground(Color.red);

       add(game);
       game.start();
    }
}
