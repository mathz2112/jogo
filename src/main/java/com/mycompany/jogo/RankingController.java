/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo;
import dao.RankingDAO;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
/**
 *
 * @author aluno
 */
public class RankingController {

@FXML
private ListView<String> listaRanking;

@FXML
public void initialize() {

    RankingDAO dao = new RankingDAO();

    listaRanking.getItems().addAll(
            dao.listarRanking()
    );

}

@FXML
private void voltar() throws IOException {

    App.setRoot("menu");

}

}
