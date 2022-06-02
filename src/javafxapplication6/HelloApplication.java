package javafxapplication6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage stg;
    @Override
    public void start(Stage stage) throws IOException {
        stg=stage;
        //DataB.connect();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    
    public void changeScene(String fxml) throws IOException{
        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource(fxml));
        stg.getScene().setRoot(fxmlLoader2.load());
    }

    public static void main(String[] args) {
        launch();
    }
}