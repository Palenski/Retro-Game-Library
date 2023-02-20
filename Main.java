import SpaceInvaders.SpaceInvader;
import Pong.GameFrame;
import TicTacToe.MainScreenTicTacToe;
import TicTacToe.MainTicTacToe;
import TicTacToe.TicTacToe;
import TypingGame.TypingGame; 

public class Main {

    
    public static void main(String[] args) {

        
       //startingWindow();
       pong();
       //SpaceInvader();
       //TypingGame();
       //TicTacToe();

    }



    public static void startingWindow(){
        StartingWindow startingWindow = new StartingWindow();
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
        MainTicTacToe mainTicTacToe = new MainTicTacToe();
    }
}