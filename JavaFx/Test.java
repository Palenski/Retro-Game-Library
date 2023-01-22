package JavaFx;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Test extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Group root = new Group();
        Scene scene = new Scene(root, Color.SKYBLUE);

        Text text = new Text("Der Punktestand ist: 0");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Verdana", 50));
        text.setFill(Color.RED);

        Line line = new Line();
        line.setStartX(200);
        line.setStartY(200);
        line.setEndX(400);
        line.setEndY(200);
        line.setFill(Color.BEIGE);
        line.setStrokeWidth(5);

        Rectangle rec = new Rectangle();
        rec.setX(300);
        rec.setY(50);
        rec.setWidth(25);
        rec.setHeight(200);
        rec.setFill(Color.AZURE);

        Circle ball = new Circle();
        ball.setCenterX(300);
        ball.setCenterY(300);
        ball.setRadius(25);
        ball.setFill(Color.RED);

        Image bg = new Image("JavaFx/Images/fantasy-space-wallpaper-preview.jpg");
        ImageView imageView = new ImageView(bg);
        imageView.setX(0);
        imageView.setY(0);

        root.getChildren().add(imageView);
        root.getChildren().add(text);
        root.getChildren().add(line);
        root.getChildren().add(rec);
        root.getChildren().add(ball);

        stage.setResizable(false);
        stage.setTitle("PONG");

        stage.setWidth(1000);
        stage.setHeight(650);

        stage.setScene(scene);

        stage.show();

    }

}
