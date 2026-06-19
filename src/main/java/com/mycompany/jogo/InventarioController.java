package com.mycompany.jogo;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class InventarioController {

    @FXML
    private ListView<String> listaItens;

    public void adicionarItem(String item){

        listaItens.getItems().add(item);

    }

    @FXML
    private void fecharJanela(){

        Stage stage =
                (Stage) listaItens.getScene().getWindow();

        stage.close();

    }

}
