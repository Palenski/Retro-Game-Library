package Main;

import Pong.GameFrame;
import SnakeGame.GameFrameS;
import SnakeGame.GamePanelS;

import SnakeGame.SnakeGame;

import TicTacToe.MainScreenTicTacToe;

import TypingGame.TypingGame; 

public class Main {

    
    public static void main(String[] args) {

        
       //pong();
       //SpaceInvader();
       //TypingGame();
       //TicTacToe();
       startingWindow2();
       //Snake();


    }

    public static void startingWindow2(){
        StartingWindow2 startingWindow2 = new StartingWindow2();
    }


    static GameFrame pong1;
    public static void pong(){
       pong1 = new GameFrame();
    }

    public static void pongclose(){
        pong1.dispose();
    }

    public static void TypingGame(){
        TypingGame typingGame = new TypingGame();
    }
    
    static MainScreenTicTacToe ticTacToe1;
    public static void TicTacToe() {
        ticTacToe1 = new MainScreenTicTacToe();
    }

    public static void TicTacToeClose(){
        ticTacToe1.dispose();
    }

    public static void Snake() {
        GameFrameS snake = new GameFrameS();
    }

    
}