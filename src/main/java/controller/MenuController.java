package controller;

import dao.EstudanteDAO;
import model.Estudante;
import util.GameState;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MenuController {

    @FXML private Label lblStatusBanco;
    @FXML private TextField txtNomeEstudante;
    
    @FXML private javafx.scene.control.Button btnJogar;
    @FXML private javafx.scene.control.Button btnRanking;
    @FXML private javafx.scene.control.Button btnCreditos;
    @FXML private javafx.scene.control.Button btnEncerrar;
    
    @FXML private javafx.scene.control.Button btnAvancar;
    @FXML private javafx.scene.control.Button btnVoltar;

    private final EstudanteDAO estudanteDAO = new EstudanteDAO();

    @FXML
    public void initialize() {
        if (GameState.getInstance().isDbConectado()) {
            lblStatusBanco.setText("Banco de Dados: Conectado (PostgreSQL)");
        } else {
            lblStatusBanco.setText("Banco de Dados: Offline (Jogando localmente sem salvar)");
        }

        if (btnJogar != null) util.EstiloUtils.aplicarBotaoPrimario(btnJogar);
        if (btnRanking != null) util.EstiloUtils.aplicarBotaoSecundario(btnRanking);
        if (btnCreditos != null) util.EstiloUtils.aplicarBotaoSecundario(btnCreditos);
        if (btnEncerrar != null) util.EstiloUtils.aplicarBotaoSecundario(btnEncerrar);
        if (btnAvancar != null) util.EstiloUtils.aplicarBotaoPrimario(btnAvancar);
        if (btnVoltar != null) util.EstiloUtils.aplicarBotaoSecundario(btnVoltar);
        if (txtNomeEstudante != null) util.EstiloUtils.aplicarCampoTexto(txtNomeEstudante);
    }

    @FXML
    public void jogarTela() {
        GameState.getInstance().mudarTela("nome");
    }

    @FXML
    public void voltarMenu() {
        GameState.getInstance().mudarTela("menu");
    }

    @FXML
    public void jogar() {
        try {
            String nome = txtNomeEstudante.getText();
            if (nome != null) {
                String nomeLimpo = nome.trim();
                if (!nomeLimpo.isEmpty()) {
                    Estudante estudante = estudanteDAO.buscarOuCriar(nomeLimpo);
                    GameState.getInstance().setEstudanteAtual(estudante);
                    GameState.getInstance().iniciarNovaRun();
                    GameState.getInstance().mudarTela("gameplay");
                } else {
                    txtNomeEstudante.setPromptText("Digite seu nome!");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao inicializar partida: " + e);
        }
    }

    @FXML
    public void ranking() {
        GameState.getInstance().mudarTela("ranking");
    }

    @FXML
    public void creditos() {
        GameState.getInstance().mudarTela("creditos");
    }

    @FXML
    public void encerrar() {
        Platform.exit();
    }
}
