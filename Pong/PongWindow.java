package Pong;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class PongWindow extends Application {

    public static int screenX = 1000;
    public static int screenY = 650;

    public static Paddle1 paddle1;
    public static Paddle2 paddle2;
    public static Ball ball;
    public static Thread t;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Group root = new Group();
        Scene scene = new Scene(root, screenX, screenY, Color.BLACK);

        Canvas can = new Canvas(screenX, screenY);

        GraphicsContext gc = can.getGraphicsContext2D();
        gc.setFill(Color.WHITE);

        paddle1 = new Paddle1(0, 0, gc, true);
        paddle2 = new Paddle2(0, 0, gc, true);
        ball = new Ball(0, 0, gc, true);
    
        paddle1.draw(50, 200);
        paddle2.draw(915, 200);
        ball.draw(465, 300);

        gc.setFill(Color.RED);

        gc.fillRect(0, 0, 10, 650);
        gc.fillRect(975, 0, 10, 650);

        gc.setFill(Color.WHITE);
        
        root.getChildren().add(can);

        Button button = new Button("Funktion 1");

        Button button2 = new Button("Funktion 2");

        Button button3 = new Button("Animieren");
        Button button4 = new Button("Stoppen");
        Button button5 = new Button("Löschen");

        stage.setTitle("Title");

        stage.setResizable(false);

        stage.setWidth(screenX);
        stage.setHeight(screenY);

        stage.setScene(scene);

        stage.show();


        
    
        root.addEventFilter(MouseEvent.MOUSE_CLICKED, e ->{
            t = new Thread(paddle1);
            System.out.println("TEst");
            t.start();
        });

     

      


        button.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                gc.setFill(Color.DARKBLUE);
                gc.fillRect(100, 100, 200, 200);
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                t = new Thread(paddle1);
                t.start();
            }
        });

        button3.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                ball.running = true;
                t = new Thread(ball);
                t.start();

            }
        });

        button4.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                ball.running = false;
            }
        });

        button5.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                ball.clear();
                ball.x = 0;
                ball.y = 100;

            }
        });

    }

    private GraphicsContext getGraphicsContext2D() {
        return null;
    }

}
