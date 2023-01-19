package Pong;

import javax.swing.*;
import java.awt.*;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import java.awt.Graphics;



public class PongWindow implements ActionListener {

    JFrame frame = new JFrame();

    JPanel panel = new JPanel();

    Ball ball = new Ball();

    JPanel player1Panel = new JPanel();
    JPanel player2Panel = new JPanel();

   JPanel end1Panel = new JPanel();
   JPanel end2Panel = new JPanel();

    


    public PongWindow() {
        
       
        end1Panel.setBackground(Color.GRAY);
        end1Panel.setBounds(0, 0, 25, 613);

        end2Panel.setBackground(Color.GRAY);
        end2Panel.setBounds(960, 0, 25, 613);

        player1Panel.setBackground(Color.GREEN);
        player1Panel.setBounds(80, 200, 25, 175);

        player2Panel.setBackground(Color.BLUE);
        player2Panel.setBounds(880, 200, 25, 175);

        ball.setBounds(393, 220, 100, 100);

        
        frame.add(end1Panel);
        frame.add(end2Panel);
        frame.add(player1Panel);
        frame.add(player2Panel);
        frame.add(ball);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000, 650);

        frame.setTitle("Pong");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    public void actionPerformed(ActionEvent e) { // einfache Weiterleitung an die verschiedenen Fenster

    }
}
