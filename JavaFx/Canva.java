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
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Canva extends Application {

    static GraphicsContext gc;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Canvas can = new Canvas();
        can.setHeight(650);
        can.setWidth(1000);
        gc = can.getGraphicsContext2D();

        HBox box = new HBox();

        Button button = new Button("Funktion 1");
        Button button2 = new Button("Funktion 2");

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

        box.getChildren().addAll(button, button2);
        box.setSpacing(10);
        box.setPadding(new Insets(10));

        BorderPane pane = new BorderPane();
        pane.setTop(box);
        pane.setCenter(can);
   


        Scene scene = new Scene(pane);

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
