package RockPaperScissor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GameFrame extends JFrame implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JButton[] buttons = new JButton[3];
    JPanel buttonPanel = new JPanel();
    JLabel[] labels = new JLabel[2];
    JPanel labelPanel = new JPanel();
    JLabel label = new JLabel();
    JLabel PCLabel = new JLabel();
    String[] stp = { "Schere", "Stein", "Papier" };
    String[] Texte = {"Hier steht was du wählst", "Hier steht was der Computer wählt"};
    String Text1 = "Hier steht was du wählst";
    String Text2 = "Deine Wahl ist: ";
    String Text3 = "Hier steht was der Computer wählt       ";
    String Text4 = "Der Computer wählt: ";

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
    }

    public GameFrame() {

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLocationRelativeTo(null);
        frame.setSize(800, 700);
        frame.setTitle("Schere Stein Papier");

        buttonPanel.setLayout(new GridLayout(1, 0));
        buttonPanel.setBackground(new Color(150, 150, 150));
        buttonPanel.setSize(300, 100);

        
        

        for (int i = 0; i < 3; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("SansSerif", Font.BOLD, 50));
            buttons[i].setFocusable(true);
            buttons[i].addActionListener(this);
            buttons[i].setEnabled(true);
            buttons[i].setBackground(new Color(0, 0, 0));
            buttons[i].setVisible(true);
            buttons[i].setText(stp[i]);

        }

        label.setText(Text1);
        PCLabel.setText(Text3);

        labelPanel.setLayout(new GridLayout(1,0));

        for(int i = 0; i < 2; i++){
            
                labels[i] = new JLabel();
                labelPanel.add(labels[i]);
                labels[i].setText(Texte[i]);
        }

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(labelPanel,BorderLayout.NORTH);
    }

    
    public void PCTurn(){
        int PCWahl = random.nextInt(3);
        if(PCWahl == 0){
            labels[1].setText(Text4 + stp[0]);
        }
        if(PCWahl == 1){
            labels[1].setText(Text4 + stp[1]);
        }
        if(PCWahl == 2){
            labels[1].setText(Text4 + stp[2]);
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 3; i++) {
            if (e.getSource() == buttons[i]) {
                labels[0].setText(Text2 + stp[i]);
            }
            buttons[i].setEnabled(false);
            PCTurn();
        }
    }
}