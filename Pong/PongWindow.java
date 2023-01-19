package Pong;

import javax.swing.*;
import java.awt.*;

import java.awt.Color;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import java.awt.Graphics;

public class PongWindow implements KeyListener {

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

        frame.addKeyListener(this);

        frame.addKeyListener(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000, 650);

        frame.setTitle("Pong");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

        

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        int y1 = player1Panel.getY() - 5;
        int y2 = player2Panel.getY();

      


        ball.setBounds(ball.getX() + 5, ball.getY() + 5, 100, 100);



        if (key == KeyEvent.VK_W) {
            if (y1 > 0) {
                y1 = y1 - 5;
                player1Panel.setBounds(80, player1Panel.getY() - 5, 25, 175);
            }

        }

        if (key == KeyEvent.VK_S) {
            if (y1 < 440) {
                y1 = y1 + 5;
                player1Panel.setBounds(80, player1Panel.getY() + 5, 25, 175);
            }

        }

        if (key == KeyEvent.VK_UP) {
            if (y2 > 0) {
                y2 = y2 - 5;
                player2Panel.setBounds(880, y2, 25, 175);
            }

        }

        if (key == KeyEvent.VK_DOWN) {
            if (y2 < 440) {
                y2 = y2 + 5;
                player2Panel.setBounds(880, y2, 25, 175);
            }

        }

    }

    public void actionPerformed(ActionEvent e) { // einfache Weiterleitung an die verschiedenen Fenster

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
