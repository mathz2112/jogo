/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.jogo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import util.sistemaDialogo;


public class GameplayController {

    @FXML
    private ProgressBar vidaBar;

    @FXML
    private ProgressBar xpBar;

    @FXML
    private Button inventarioButton;

    @FXML
    private ImageView cenarioImage;

    @FXML
    private Label nomeLabel;

    @FXML
    private Label dialogoLabel;

    @FXML
    private Button botao1;

    @FXML
    private Button botao2;

    private sistemaDialogo dialogo;

    @FXML
    public void initialize() {

        dialogo = new sistemaDialogo();

        atualizarTela();
    }

    @FXML
private void escolha1() {

    if(!dialogo.terminouDialogo()) {

        dialogo.proximoDialogo();
        atualizarTela();
        return;
    }

    switch(dialogo.getLocalAtual()) {

        case ENTRADA:
            dialogo.mudarLocal(util.Local.BLOCO_A);
            break;

        case BLOCO_A:
            dialogo.mudarLocal(util.Local.BLOCO_D_HALL);
            break;
    }

    atualizarTela();
}

    @FXML
private void escolha2() {

    if(!dialogo.terminouDialogo()) {
        return;
    }

    switch(dialogo.getLocalAtual()) {

        case ENTRADA:
            dialogo.mudarLocal(util.Local.BLOCO_B);
            break;

        case BLOCO_A:
            dialogo.mudarLocal(util.Local.BLOCO_F);
            break;
    }

    atualizarTela();
}

    @FXML
    private void abrirInventario() {

    }

    private void atualizarTela() {

    nomeLabel.setText(dialogo.getNomeAtual());

    dialogoLabel.setText(dialogo.getTextoAtual());

    if(!dialogo.terminouDialogo()) {

        botao1.setText("Continuar");
        botao2.setVisible(false);

    } else {

        switch(dialogo.getLocalAtual()) {

            case ENTRADA:

                botao1.setText("Bloco A");
                botao2.setText("Bloco B");
                botao2.setVisible(true);
                break;

            case BLOCO_A:

                botao1.setText("Bloco D");
                botao2.setText("Bloco F");
                botao2.setVisible(true);
                break;
        }
    }
}

}

