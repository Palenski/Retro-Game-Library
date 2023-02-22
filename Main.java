import SpaceInvaders.SpaceInvader;
import Pong.GameFrame;
import TicTacToe.MainScreenTicTacToe;

import TypingGame.TypingGame; 

public class Main {

    
    public static void main(String[] args) {

        
       //startingWindow();
       //pong();
       //SpaceInvader();
       //TypingGame();
       //TicTacToe();
       startingWindow2();

    }



    public static void startingWindow(){
        StartingWindow startingWindow = new StartingWindow();
    }

    public static void startingWindow2(){
        StartingWindow2 startingWindow2 = new StartingWindow2();
    }

    public static void pong(){
        GameFrame frame = new GameFrame();
        
    }

    public static void SpaceInvader(){
        SpaceInvader spaceInvader = new SpaceInvader();
    }

    public static void TypingGame(){
        TypingGame typingGame = new TypingGame();
    }

    public static void TicTacToe() {
        MainScreenTicTacToe frame = new MainScreenTicTacToe();
    }
}