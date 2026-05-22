package com.mycompany.jogo;

import dao.CriarPartida;
import java.io.IOException;
import javafx.fxml.FXML;
import model.Partida;

public class MenuController {

    @FXML
    private void jogar() throws IOException {
        App.setRoot("introducao");
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
    
    @FXML 
    private void teste() throws IOException {
         Partida partida = new Partida(0,null,0,0,0,true);
        CriarPartida teste = new CriarPartida();
        teste.create(partida);
    }
}
