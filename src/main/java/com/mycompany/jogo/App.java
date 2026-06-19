package com.mycompany.jogo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

 @Override
public void start(Stage stage) throws IOException {

    scene = new Scene(loadFXML("menu"));

    stage.setTitle("Beyond the Hallways");
    stage.setScene(scene);

    stage.setResizable(true);

    stage.show();
    
    /*
    scene = new Scene(loadFXML("menu"), 1920, 1080);
        stage.setTitle("Beyond the Hallways");

    stage.setScene(scene);

    stage.setWidth(1920);
    stage.setHeight(1080);

    stage.setResizable(false);

    stage.show(); */
    
}

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}