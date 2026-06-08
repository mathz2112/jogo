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

    }

    @FXML
    private void escolha2() {

    }

    @FXML
    private void abrirInventario() {

    }

    private void atualizarTela() {

    }

}

