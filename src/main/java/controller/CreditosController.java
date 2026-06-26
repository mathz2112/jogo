package controller;

import util.GameState;
import javafx.fxml.FXML;

public class CreditosController {

    @FXML private javafx.scene.control.Button btnVoltar;

    @FXML
    public void initialize() {
        if (btnVoltar != null) {
            util.EstiloUtils.aplicarBotaoPrimario(btnVoltar);
        }
    }

    @FXML
    public void voltar() {
        GameState.getInstance().mudarTela("menu");
    }
}
