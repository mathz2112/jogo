/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.jogo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * 
 * @author aluno
 */
public class GameplayController {
@FXML
    private Label nomeLabel;

    @FXML
    private Label dialogoLabel;

    @FXML
    private Button botao1;

    @FXML
    private Button botao2;

    @FXML
    public void escolha1() {
        dialogoLabel.setText("Você escolheu a primeira opção.");
    }

    @FXML
    public void escolha2() {
        dialogoLabel.setText("Você escolheu a segunda opção.");
    }

}

