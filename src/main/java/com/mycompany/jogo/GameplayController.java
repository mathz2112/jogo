package com.mycompany.jogo;

import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import util.Local;
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
private VBox escolhasBox;

@FXML
private Label nomeLabel;

@FXML
private Label dialogoLabel;

private sistemaDialogo dialogo;

@FXML
public void initialize() {

    dialogo = new sistemaDialogo();

    atualizarTela();
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

    escolhasBox.getChildren().clear();

    if (!dialogo.terminouDialogo()) {

        criarBotaoContinuar();

    } else {

        criarBotoesDestino();
    }

    atualizarStatusJogador();

    atualizarCenario();
}

private void criarBotaoContinuar() {

    Button continuar = new Button("Continuar");

    continuar.setPrefWidth(300);

    continuar.setOnAction(event -> {

        dialogo.proximoDialogo();

        atualizarTela();
    });

    escolhasBox.getChildren().add(continuar);
}

    private void criarBotoesDestino() {

   List<Local> destinos = dialogo.getDestinos();

    for (Local destino : destinos) {

        Button botao = new Button(formatarNome(destino));

        botao.setPrefWidth(300);

        botao.setOnAction(event -> {

            dialogo.mudarLocal(destino);

            atualizarTela();
        });

        escolhasBox.getChildren().add(botao);
    }
}

private String formatarNome(Local local) {

    switch (local) {

        case BLOCO_A:
            return "Bloco A";

        case BLOCO_B:
            return "Bloco B";

        case BLOCO_C:
            return "Bloco C";

        case BLOCO_D_EXTERNO:
            return "Bloco D";

        case BLOCO_D_HALL:
            return "Entrar no Bloco D";

        case BLOCO_D_SEGUNDO_ANDAR:
            return "2º Andar";

        case CANTINA:
            return "Cantina";

        case CAMINHO_BLOCO_E:
            return "Caminho para E";

        case BLOCO_E:
            return "Bloco E";

        case BLOCO_F:
            return "Bloco F";

        case QUADRA:
            return "Quadra";

        case FLORESTA_AMORAS:
            return "Bosque das Amoras";

        default:
            return local.name();
    }
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

        case BLOCO_A:
            carregarImagem(...);
            break;
    }
    */
}

}