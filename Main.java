<<<<<<< HEAD
import Pong.PongWindow; 
=======
import Pong.Pong;
import SpaceInvaders.SpaceInvader; 
>>>>>>> 086c381ce23a896372dff66839a233ad02d2c340

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
        PongWindow pong = new PongWindow();
    }

    public static void SpaceInvader(){
        SpaceInvader spaceInvader = new SpaceInvader();
    }
}