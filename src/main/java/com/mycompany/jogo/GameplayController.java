package com.mycompany.jogo;

import dao.CriarPartida;
import dao.EstudanteDAO;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.Chefe;
import model.Estudante;
import model.Inimigo;
import util.Local;
import util.sistemaDialogo;
import model.Arma;
import model.Comida;
import model.Partida;
import util.tipoArma;
import util.tipoItem;

public class GameplayController {

    private sistemaDialogo dialogo;

    private Estudante jogador;

    private Inimigo queroQuero;

    private Inimigo coruja;

    private Chefe capi;
    
    private Inimigo inimigoAtual;

    private boolean emBatalha = false;

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

    @FXML
    private Label dinheiroLabel;

    @FXML
    public void initialize() {

        dialogo = new sistemaDialogo();

        jogador = new Estudante();

        jogador.setVida(100);
        jogador.setDano(10);
        jogador.setDinheiro(50);
        jogador.setXp(0);

        queroQuero = new Inimigo(
                "Quero-Quero",
                30,
                5,
                50
        );

        coruja = new Inimigo(
                "Coruja",
                50,
                10,
                50
        );

        capi = new Chefe(
                "Inveja da Pintas",
                "Capi",
                100,
                20,
                100
        );

        atualizarTela();
    }

    @FXML
    private void abrirInventario() {

        // Implementar depois

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
        
        verificarItens();
        
        atualizarStatusJogador();

        atualizarCenario();

    }
    
    
    private void verificarItens() {

    switch (dialogo.getLocalAtual()) {

        case BLOCO_A:

            if (!jogador.possuiItem("Livro do Governo")) {

                Arma livro = new Arma(
                        tipoArma.LIVRO_GOVERNO,
                        5,
                        "Livro do Governo",
                        tipoItem.ARMA,
                        "Aumenta o dano em +5"
                );

                jogador.adicionarItem(livro);

                jogador.setDano(
                        jogador.getDano() + 5
                );
            }

            break;

        case BLOCO_D_SEGUNDO_ANDAR:

            if (!jogador.possuiItem("Extintor")) {

                Arma extintor = new Arma(
                        tipoArma.EXTINTOR,
                        10,
                        "Extintor",
                        tipoItem.ARMA,
                        "Aumenta o dano em +10"
                );

                jogador.adicionarItem(extintor);

                jogador.setDano(
                        jogador.getDano() + 10
                );
            }

            break;

        case QUADRA:

            if (!jogador.possuiItem("Corda")) {

                Arma corda = new Arma(
                        tipoArma.CORDA,
                        15,
                        "Corda",
                        tipoItem.ARMA,
                        "Aumenta o dano em +15"
                );

                jogador.adicionarItem(corda);

                jogador.setDano(
                        jogador.getDano() + 15
                );
            }

            break;

    }

}
    
    

    private void criarBotaoContinuar() {

        Button continuar = new Button("Continuar");

        continuar.setPrefWidth(300);

        continuar.setOnAction(event -> {

            String textoAtual = dialogo.getTextoAtual();

            if (textoAtual.equals("[INICIAR BATALHA]")) {

                iniciarBatalha();

                return;

            }

            if (textoAtual.equals("[BATALHA FINAL]")) {

                iniciarBatalhaFinal();

                return;

            }

            if (textoAtual.equals("[FIM DE JOGO]")) {

                fimDoJogo();

                return;

            }

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
                return "Caminho para o Bloco E";

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

        vidaBar.setProgress(jogador.getVida() / 100.0);

        xpBar.setProgress(jogador.getXp() / 200.0);

        dinheiroLabel.setText("R$ " + jogador.getDinheiro());

    }

    private void atualizarCenario() {

        // Implementaremos depois

    }

        private void iniciarBatalha() {

    emBatalha = true;

    if (dialogo.getLocalAtual() == Local.BLOCO_C) {

        inimigoAtual = queroQuero;

    } else {

        inimigoAtual = coruja;

    }

    mostrarTelaBatalha();
}

private void mostrarTelaBatalha() {

    nomeLabel.setVisible(true);
    nomeLabel.setText(inimigoAtual.getNome());

    dialogoLabel.setText(
            "Vida do inimigo: " + inimigoAtual.getVida()
    );

    escolhasBox.getChildren().clear();

    Button atacar = new Button("Atacar");

    atacar.setPrefWidth(300);

    atacar.setOnAction(event -> atacarInimigo());

    escolhasBox.getChildren().add(atacar);

}

private void atacarInimigo() {

    // Jogador ataca
    inimigoAtual.setVida(
            inimigoAtual.getVida() - jogador.getDano()
    );

    // Inimigo derrotado
    if (inimigoAtual.getVida() <= 0) {

        jogador.setXp(
                jogador.getXp() + inimigoAtual.getXpConcedido()
        );

        emBatalha = false;

        // Vitória final contra o Capi
        if (inimigoAtual == capi) {

            EstudanteDAO estudanteDAO = new EstudanteDAO();
            estudanteDAO.estudanteDAO(jogador);

            Partida partida = new Partida();

            int idEstudante = estudanteDAO.estudanteDAO(jogador);
            partida.setEstudanteId(idEstudante);
            partida.setPontuacao(jogador.getXp());
            partida.setInimigosDerrotados(3);
            partida.setChefeDerrotado(true);

            CriarPartida criarPartida = new CriarPartida();
            criarPartida.create(partida);
        }

        dialogo.proximoDialogo();

        atualizarTela();

        return;
    }

    // Inimigo ataca
    jogador.setVida(
            Math.max(
                    jogador.getVida() - inimigoAtual.getDano(),
                    0
            )
    );

    atualizarStatusJogador();

    // Jogador morreu
    if (jogador.getVida() <= 0) {

        EstudanteDAO estudanteDAO = new EstudanteDAO();
        estudanteDAO.estudanteDAO(jogador);

        Partida partida = new Partida();

        int idEstudante = estudanteDAO.estudanteDAO(jogador);
        partida.setEstudanteId(idEstudante);
        partida.setPontuacao(jogador.getXp());
        partida.setInimigosDerrotados(0);
        partida.setChefeDerrotado(false);

        CriarPartida criarPartida = new CriarPartida();
        criarPartida.create(partida);

        nomeLabel.setText("DERROTA");

        dialogoLabel.setText(
                "Você foi derrotado."
        );

        escolhasBox.getChildren().clear();

        Button reiniciar = new Button("Reiniciar");

        reiniciar.setPrefWidth(300);

        reiniciar.setOnAction(event -> {

            jogador.setVida(100);
            jogador.setXp(0);
            jogador.setDinheiro(50);

            dialogo = new sistemaDialogo();

            atualizarTela();

        });

        escolhasBox.getChildren().add(reiniciar);

        return;
    }

    mostrarTelaBatalha();

}

private void iniciarBatalhaFinal() {

    emBatalha = true;

    inimigoAtual = capi;

    mostrarTelaBatalha();

}

private void fimDoJogo() {

    nomeLabel.setText("Fim");

    dialogoLabel.setText(
            "Parabéns! Você resgatou a Pintas."
    );

    escolhasBox.getChildren().clear();

    Button voltarMenu = new Button("Voltar ao menu");

    voltarMenu.setPrefWidth(300);

    escolhasBox.getChildren().add(voltarMenu);

}

}