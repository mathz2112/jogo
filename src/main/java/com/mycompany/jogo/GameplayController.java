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

        if (!dialogo.terminouDialogo()) {

            dialogo.proximoDialogo();

        } else {

            dialogo.escolha1();
        }

        atualizarTela();
    }

    @FXML
    private void escolha2() {

        if (dialogo.terminouDialogo()) {

            dialogo.escolha2();

            atualizarTela();
        }
    }

    @FXML
    private void abrirInventario() {

        // Implementar futuramente
    }

    private void atualizarTela() {

        String nome = dialogo.getNomeAtual();

        if (nome == null || nome.isEmpty()) {

            nomeLabel.setVisible(false);

        } else {

            nomeLabel.setVisible(true);
            nomeLabel.setText(nome);
        }

        dialogoLabel.setText(dialogo.getTextoAtual());

        if (!dialogo.terminouDialogo()) {

            botao1.setText("Continuar");

            botao2.setVisible(false);
            botao2.setManaged(false);

        } else {

            botao1.setText(dialogo.getOpcao1());

            String opcao2 = dialogo.getOpcao2();

            if (opcao2 == null || opcao2.isEmpty()) {

                botao2.setVisible(false);
                botao2.setManaged(false);

            } else {

                botao2.setVisible(true);
                botao2.setManaged(true);
                botao2.setText(opcao2);
            }
        }

        atualizarStatusJogador();

        atualizarCenario();
    }

    private void atualizarStatusJogador() {

        /*
         PENDENTE:

         vidaBar.setProgress(...);

         xpBar.setProgress(...);

         dinheiroLabel.setText(...);
        */
    }

    private void atualizarCenario() {

        /*
         PENDENTE:

         switch(dialogo.getLocalAtual()) {

             case ENTRADA:
                 carregarImagem("entrada.png");
                 break;

             case BLOCO_A:
                 carregarImagem("bloco_a.png");
                 break;
         }
        */
    }
}

