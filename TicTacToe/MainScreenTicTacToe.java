package TicTacToe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.management.timer.Timer;
import javax.swing.*;

public class MainScreenTicTacToe implements ActionListener {
    
    JFrame frame = new JFrame();
    JButton start = new JButton();
    JPanel ButtonsGrid = new JPanel();

    MainScreenTicTacToe(){



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        ButtonsGrid.setLayout(new GridLayout(3,3));
        
        start.setText("<html><font color = Green> Starte: <p>Tic Tac Toe </p> </font> </html>");
        start.addActionListener(this);
        start.setSize(50,50);
        start.setBackground(new Color(0,0,0));
        start.setFont(new Font("SansSerif", Font.BOLD, 120));
        


        frame.add(start);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start) {
            start.setText("Wilkommen zu Tic Tac Toe");
            int i = 0;
            for(int u = 0; u<5;u++){
                u++;
                if(u == 4){
                    frame.dispose();
                    TicTacToe ticTacToe = new TicTacToe();
                }
            }
            
        }
        
    }


}