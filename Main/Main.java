package Main;

import Pong.GameFrame;
<<<<<<< HEAD
import RockPaperScissor.Game_Frame;
=======
import RockPaperScissor.GameScreen;
>>>>>>> dc913f85afb78040671127610fb31b0025905acb
import SnakeGame.GameFrameS;
import SnakeGame.GamePanelS;

import TicTacToe.MainScreenTicTacToe;
import TicTacToe.TicTacToeGame;
import TypingGame.TypingGame;
import ConnectFour.ConnectFour; 

public class Main {

    
    public static void main(String[] args) {        //Main Klasse, mit der alles startet
       startingWindow2();
    }



    public static void startingWindow2(){       //Weiterleitung an das Startfenster
        StartingWindow2 startingWindow2 = new StartingWindow2();
    }


    static GameFrame pong1;
    public static void pong(){      //Konstruktion um in dem Fall Pong zu öffnen
       pong1 = new GameFrame();
    }

    public static void pongclose(){     //Und später Pong auch wieder schließen zu können
        pong1.dispose();
    }

    
    static ConnectFour connectFour;
    public static void connectFour() {
        connectFour = new ConnectFour();
    }

    public static void connectFourClose() {
        connectFour.dispose();
    }


    static Game_Frame gameFrame;
    public static void RockPaperScissor(){
        gameFrame = new Game_Frame();
    }

    public static void rockPaperScissor(){
        GameScreen frame = new GameScreen();
    }
    
    public static void RockPaperScissorClose() {
        gameFrame.dispose();
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