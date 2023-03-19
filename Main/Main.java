package Main;

import Pong.GameFrame;
import SnakeGame.GameFrameS;
import SnakeGame.GamePanelS;

import TicTacToe.MainScreenTicTacToe;
import TicTacToe.TicTacToeGame;
import TypingGame.TypingGame;
import ConnectFour.ConnectFour; 

public class Main {

    
    public static void main(String[] args) {
       startingWindow2();
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

    
    static ConnectFour connectFour;
    public static void connectFour() {
        connectFour = new ConnectFour();
    }

    public static void connectFourClose() {
        connectFour.dispose();
    }



    public static void RockPaperScissor(){
        
    }
    
    static MainScreenTicTacToe ticTacToe;
    public static void TicTacToe() {
        ticTacToe = new MainScreenTicTacToe();
    }

    static TicTacToeGame ticTacToe2;
    public static void TicTacToe2() {
        ticTacToe2 = new TicTacToeGame();
    }


    static GameFrameS snake;
    public static void Snake() {
        snake = new GameFrameS();
    }
    
    public static void SnakeClose() {
        snake.dispose();
    }

    
}