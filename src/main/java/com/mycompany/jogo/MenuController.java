package com.mycompany.jogo;

import java.io.IOException;
import javafx.fxml.FXML;

public class MenuController {

    @FXML
    private void jogar() throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML 
    private void ranking() throws IOException {
    }
    
    @FXML 
    private void creditos() throws IOException {
    }
    
    @FXML 
    private void encerrar() throws IOException {
    }
}
