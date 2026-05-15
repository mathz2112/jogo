package com.mycompany.jogo;

import java.io.IOException;
import javafx.fxml.FXML;

public class IntroducaoController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}