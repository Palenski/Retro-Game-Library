package SnakeGame;

import javax.swing.JFrame;

public class GameFrameS extends JFrame{

	public GameFrameS(){		//Erstellt den Hintergrund als JFrame
			
		this.add(new GamePanelS());
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
}