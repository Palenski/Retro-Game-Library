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

   JPanel redPanel = new JPanel();

   JPanel bluePanel = new JPanel();

    


    public PongWindow() {
        
       
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0, 0, 50, 613);

        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(935, 0, 50, 613);

        ball.setBounds(300, 300, 25, 25);

        frame.add(ball);
        frame.add(redPanel);
        frame.add(bluePanel);

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
