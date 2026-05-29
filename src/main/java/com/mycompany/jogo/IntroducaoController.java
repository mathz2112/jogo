package com.mycompany.jogo;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class IntroducaoController {
    
    @FXML
private Label entrada;

@FXML
private Button irEntrada;

    @FXML
    private void irEntrada() throws IOException {
        App.setRoot("entrada");
    }
}