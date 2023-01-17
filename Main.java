import Pong.PongWindow; 
import SpaceInvaders.SpaceInvader; 

public class Main {
    public static void main(String[] args) {

       //startingWindow();
       pong();
       //SpaceInvader();

    }



    public static void startingWindow(){
        StartingWindow startingWindow = new StartingWindow();
    }

    public static void pong(){
        PongWindow pong = new PongWindow();
    }

    public static void SpaceInvader(){
        SpaceInvader spaceInvader = new SpaceInvader();
    }
}