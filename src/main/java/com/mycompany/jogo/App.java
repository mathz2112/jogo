package com.mycompany.jogo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import dao.ConnectionFactory;

import java.io.IOException;
import static javafx.application.Application.launch;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        
        ConnectionFactory.inicializarBanco();

        FXMLLoader loader = new FXMLLoader(App.class.getResource("/view/menu.fxml"));
        scene = new Scene(loader.load(), 980, 680);

        stage.setTitle("Beyond the Hallways: O Desaparecimento de Pintas");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/view/" + fxml + ".fxml"));
        scene.setRoot(loader.load());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
