package com.mycompany.jogo;

import dao.CriarPartida;
import dao.EstudanteDAO;
import dao.InimigoDAO;
import dao.PartidaDAO;
import java.io.IOException;
import javafx.fxml.FXML;
import model.Estudante;
import model.Inimigo;
import model.Partida;

public class MenuController {

    @FXML
    private void jogar() throws IOException {
        App.setRoot("gameplay");
    }
    
    @FXML 
    private void ranking() throws IOException {
        App.setRoot("ranking");
    }
    
    @FXML 
    private void creditos() throws IOException {
        App.setRoot("creditos");
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
