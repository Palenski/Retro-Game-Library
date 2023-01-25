package JavaFx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Canva extends Application {

    public static Ball ball;
    public static Thread t;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Canvas can = new Canvas();
        can.setHeight(650);
        can.setWidth(1000);
        GraphicsContext gc = can.getGraphicsContext2D();

        HBox box = new HBox();

        //Pane root = new Pane();

        Button button = new Button("Funktion 1");

        Button button2 = new Button("Funktion 2");

        Button button3 = new Button("Animieren");
        Button button4 = new Button("Stoppen");
        Button button5 = new Button("Löschen");

        box.getChildren().addAll(button, button2, button3, button4, button5);
        box.setSpacing(10);
        box.setPadding(new Insets(10));

        ball = new Ball(0, 100, gc, true);

        BorderPane pane = new BorderPane();
        pane.setTop(box);
        pane.setCenter(can);

     


        Scene scene = new Scene(pane);
        button.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                gc.setFill(Color.DARKBLUE);
                gc.fillRect(100, 100, 200, 200);
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                gc.clearRect(100, 100, 200, 200);
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

        stage.setTitle("Title");

        stage.setResizable(false);

        stage.setWidth(1000);
        stage.setHeight(650);

        stage.setScene(scene);

        stage.show();

    }

    private GraphicsContext getGraphicsContext2D() {
        return null;
    }

}
