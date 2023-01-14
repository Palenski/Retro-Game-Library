import Pong.PongWindow; 

public class Main {
    public static void main(String[] args) {

       //startingWindow();
       pong();
       System.out.print("Test");

    }



    public static void startingWindow(){
        StartingWindow startingWindow = new StartingWindow();
    }

    public static void pong(){
        PongWindow pong = new PongWindow();
    }
}