package Main;

import Pong.GameFrame;
import RockPaperScissor.Game_Frame;
import SnakeGame.GameFrameS;
import TicTacToe.MainScreenTicTacToe;
import TicTacToe.TicTacToeGame;
import VierGewinnt.Vier_Gewinnt; 



import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

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

    
    static Vier_Gewinnt vierGewinnt;
    public static void vierGewinnt() {
        vierGewinnt = new Vier_Gewinnt();
    }

    public static void vierGewinntClose() {
        vierGewinnt.dispose();
    }


    static Game_Frame gameFrame;
    public static void RockPaperScissor(){
        gameFrame = new Game_Frame();
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

    public static void easterEgg() {
        try {
            Desktop.getDesktop().browse(new URL("https://www.youtube.com/watch?v=dQw4w9WgXcQ").toURI());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    
}