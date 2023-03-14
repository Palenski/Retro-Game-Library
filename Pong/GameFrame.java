package Pong;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GameFrame extends JFrame{
    
    public static GamePanel panel = new GamePanel();
    
    
    
    public GameFrame(){     //Erstellt den Frame
        
        this.add(panel);
        this.setTitle("Ping Pong");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        
        
    }

    public static void close(){
        
    }
    

}
