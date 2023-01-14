import Pong.Pong;
import SpaceInvaders.SpaceInvader; 

public class Main {
    public static void main(String[] args) {

       //startingWindow();
       //pong();
       SpaceInvader();

    }



    public static void startingWindow(){
        StartingWindow startingWindow = new StartingWindow();
    }

    public static void pong(){
        Pong pong = new Pong();
    }

    public static void SpaceInvader(){
        SpaceInvader spaceInvader = new SpaceInvader();
    }
}