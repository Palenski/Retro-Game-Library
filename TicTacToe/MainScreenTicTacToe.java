package TicTacToe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.management.timer.Timer;
import javax.swing.*;


/*
 * Zuerst wird ein Startscreen angezeigt, wenn man dann hier auf
 * Start drückt kommt man zum eigentlichen Spiel
 */



public class MainScreenTicTacToe implements ActionListener {
    
    JFrame frame = new JFrame();
    JButton start = new JButton();
    JPanel ButtonsGrid = new JPanel();

    public MainScreenTicTacToe(){



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 700);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        ButtonsGrid.setLayout(new GridLayout(3,3));
        
        start.setText("<html><p><font color = Green>Tic Tac Toe </font> </p></html>"); 
        start.addActionListener(this);
        start.setSize(50,50);
        start.setBackground(new Color(0,0,0));
        start.setFont(new Font("SansSerif", Font.BOLD, 120));
    


        frame.add(start);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start) {
           
            timer();
            TicTacToeGame ticTacToe = new TicTacToeGame();   
            frame.dispose();      
        }
        
    }

    public void timer(){
        
        try {
            
            Thread.sleep(0);
        } catch (Exception e) {
           e.setStackTrace(null);
        }
    }

}