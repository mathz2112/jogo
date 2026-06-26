package controller;

import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.geometry.Orientation;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import model.Chefe;
import model.Estudante;
import model.Inimigo;
import util.Local;
import util.sistemaDialogo;
import model.Arma;
import model.Comida;
import util.tipoArma;
import util.tipoItem;
import model.Item;
import util.GameState;
import static util.Local.BLOCO_A;
import static util.Local.BLOCO_B;
import static util.Local.BLOCO_C;
import static util.Local.BLOCO_D_EXTERNO;
import static util.Local.BLOCO_D_HALL;
import static util.Local.BLOCO_D_SEGUNDO_ANDAR;
import static util.Local.BLOCO_E;
import static util.Local.BLOCO_F;
import static util.Local.CAMINHO_BLOCO_E;
import static util.Local.CANTINA;
import static util.Local.FLORESTA_AMORAS;
import static util.Local.QUADRA;

public class GameplayController {

    private sistemaDialogo dialogo;
    private Estudante jogador;
    private Inimigo queroQuero;
    private Inimigo coruja;
    private Chefe capi;
    private Inimigo inimigoAtual;
    private boolean emBatalha = false;
    private boolean inimigoDanoReduzido = false;

    @FXML private Label lblJogadorNome;
    @FXML private Label lblVidaVal;
    @FXML private Label lblXpVal;
    @FXML private Label lblDinheiro;
    @FXML private Label lblArmaEquipada;
    @FXML private Label lblDerrota;

    @FXML private Label lblLocalNome;
    @FXML private Label lblPersonagemNome;
    @FXML private Label lblTextoGameplay;
    @FXML private HBox paneCombateInimigo;
    @FXML private Label lblInimigoNome;
    @FXML private Label lblInimigoVidaVal;

    @FXML private HBox boxEscolhasNarrativas;
    @FXML private HBox boxEscolhasCombate;

    @FXML private HBox boxInventario;
    @FXML private ListView<String> listItens;
    @FXML private Label lblDescricaoItem;
    @FXML private ImageView imgBackground;
    @FXML private ImageView imgSprite;
    @FXML private ImageView imgItem;

    @FXML private Button btnInventario;
    @FXML private Button btnAtacar;
    @FXML private Button btnDefender;
    @FXML private Button btnUsarItemCombate;
    @FXML private Button btnUsarItem;
    @FXML private Button btnVoltarInventario;

    @FXML
    public void initialize() {
        dialogo = new sistemaDialogo();
                Estudante estAt = GameState.getInstance().getEstudanteAtual();
        if (estAt != null) {
            jogador = estAt;
        } else {
            jogador = new Estudante();
            jogador.setVida(100);
            jogador.setDano(10);
            jogador.setDinheiro(50);
            jogador.setXp(0);
            GameState.getInstance().setEstudanteAtual(jogador);
        }

        queroQuero = new Inimigo("Quero-Quero", 30, 5, 50);
        coruja = new Inimigo("Coruja", 50, 10, 50);
        capi = new Chefe("Capi", 100, 20, 100);

        listItens.setOrientation(Orientation.HORIZONTAL);
        listItens.getSelectionModel().selectedItemProperty().addListener((obs, antigo, novo) -> {
            if (novo != null) {
                exibirDetalhesItem(novo);
            }
        });

        if (btnInventario != null) util.EstiloUtils.aplicarBotaoAcao(btnInventario);
        if (btnAtacar != null) util.EstiloUtils.aplicarBotaoCombate(btnAtacar);
        if (btnDefender != null) util.EstiloUtils.aplicarBotaoSecundario(btnDefender);
        if (btnUsarItemCombate != null) util.EstiloUtils.aplicarBotaoAcao(btnUsarItemCombate);
        if (btnUsarItem != null) util.EstiloUtils.aplicarBotaoPrimario(btnUsarItem);
        if (btnVoltarInventario != null) util.EstiloUtils.aplicarBotaoSecundario(btnVoltarInventario);
        if (listItens != null) util.EstiloUtils.aplicarListView(listItens);

        atualizarTela();
    }

    private void exibirDetalhesItem(String nomeItem) {
        String itemImageName = null;
        for (Item item : jogador.getInventario()) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                lblDescricaoItem.setText(item.getDescricao());
                String lowerName = item.getNome().toLowerCase();
                if (lowerName.contains("livro")) {
                    itemImageName = "livro.png";
                } else if (lowerName.contains("extintor")) {
                    itemImageName = "extintor.png";
                } else if (lowerName.contains("corda")) {
                    itemImageName = "corda.png";
                } else if (lowerName.contains("rede")) {
                    itemImageName = "redevolei.png";
                } else if (lowerName.contains("brownie")) {
                    itemImageName = "brownie.png";
                } else if (lowerName.contains("pastel")) {
                    itemImageName = "pastel.png";
                }
                break;
            }
        }
        if (itemImageName == null) {
            lblDescricaoItem.setText("");
        }
        setImagem(imgItem, itemImageName, 40, 40, true);
    }

    @FXML
    public void abrirInventario() {
        paneCombateInimigo.setVisible(false);
        paneCombateInimigo.setManaged(false);
        boxEscolhasCombate.setVisible(false);
        boxEscolhasCombate.setManaged(false);
        boxEscolhasNarrativas.setVisible(false);
        boxEscolhasNarrativas.setManaged(false);
        
        boxInventario.setVisible(true);
        boxInventario.setManaged(true);
        
        recarregarInventario();
    }

    private void recarregarInventario() {
        listItens.getItems().clear();
        for (Item item : jogador.getInventario()) {
            listItens.getItems().add(item.getNome());
        }
        lblDescricaoItem.setText("Selecione um item");
    }

    @FXML
    public void voltarInventario() {
        boxInventario.setVisible(false);
        boxInventario.setManaged(false);
        
        atualizarTela();
    }

    @FXML
    public void usarItem() {
        String selecionado = listItens.getSelectionModel().getSelectedItem();
        if (selecionado == null) return;
        
        Item itemUsado = null;
        for (Item item : jogador.getInventario()) {
            if (item.getNome().equalsIgnoreCase(selecionado)) {
                itemUsado = item;
                break;
            }
        }
        
        if (itemUsado != null) {
            if (itemUsado instanceof Comida) {
                Comida comida = (Comida) itemUsado;
                int cura = comida.getCura();
                if (comida.getNome().equalsIgnoreCase("Pastel do Tio")) {
                    cura = jogador.getVidaMaxima() - jogador.getVida();
                }
                jogador.setVida(jogador.getVida() + cura);
                if (jogador.getVida() > jogador.getVidaMaxima()) {
                    jogador.setVida(jogador.getVidaMaxima());
                }
                jogador.removerItem(itemUsado);
                
                String msg = "Você consumiu " + itemUsado.getNome() + " e recuperou " + cura + " de vida.";
                
                if (emBatalha) {
                    int danoSofrido = inimigoAtual.getDano();
                    if (inimigoDanoReduzido) {
                        danoSofrido = Math.max(1, danoSofrido / 2);
                    }
                    jogador.setVida(jogador.getVida() - danoSofrido);
                    if (jogador.getVida() < 0) {
                        jogador.setVida(0);
                    }
                    msg = msg + "\n" + inimigoAtual.getNome() + " atacou você e causou " + danoSofrido + " de dano!";
                    
                    if (jogador.getVida() <= 0) {
                        boxInventario.setVisible(false);
                        boxInventario.setManaged(false);
                        atualizarTelaSemSobrescreverTexto(msg + "\n\nVocê foi derrotado!");
                        return;
                    }
                }
                
                recarregarInventario();
                atualizarStatusJogador();
                lblTextoGameplay.setText(msg);
            } else if (itemUsedSpecialRede(itemUsado)) {
                if (!emBatalha) {
                    lblDescricaoItem.setText("A Rede de Vôlei só pode ser usada em combate.");
                    return;
                }
                inimigoDanoReduzido = true;
                jogador.removerItem(itemUsado);
                
                String msg = "Você arremessou a Rede de Vôlei no oponente! Seu dano foi reduzido pela metade nesta batalha.";
                
                int danoSofrido = Math.max(1, inimigoAtual.getDano() / 2);
                jogador.setVida(jogador.getVida() - danoSofrido);
                if (jogador.getVida() < 0) {
                    jogador.setVida(0);
                }
                msg = msg + "\n" + inimigoAtual.getNome() + " atacou você e causou " + danoSofrido + " de dano!";
                
                if (jogador.getVida() <= 0) {
                    boxInventario.setVisible(false);
                    boxInventario.setManaged(false);
                    atualizarTelaSemSobrescreverTexto(msg + "\n\nVocê foi derrotado!");
                    return;
                }
                
                recarregarInventario();
                atualizarStatusJogador();
                lblTextoGameplay.setText(msg);
            } else if (itemUsado instanceof Arma) {
                Arma arma = (Arma) itemUsado;
                jogador.setArmaEquipada(arma);
                
                String msg = "Você equipou " + arma.getNome() + "! Seu dano aumentou em +" + arma.getDanoBonus() + ".";
                
                if (emBatalha) {
                    int danoSofrido = inimigoAtual.getDano();
                    if (inimigoDanoReduzido) {
                        danoSofrido = Math.max(1, danoSofrido / 2);
                    }
                    jogador.setVida(jogador.getVida() - danoSofrido);
                    if (jogador.getVida() < 0) {
                        jogador.setVida(0);
                    }
                    msg = msg + "\n" + inimigoAtual.getNome() + " atacou você e causou " + danoSofrido + " de dano!";
                    
                    if (jogador.getVida() <= 0) {
                        boxInventario.setVisible(false);
                        boxInventario.setManaged(false);
                        atualizarTelaSemSobrescreverTexto(msg + "\n\nVocê foi derrotado!");
                        return;
                    }
                }
                
                recarregarInventario();
                atualizarStatusJogador();
                lblTextoGameplay.setText(msg);
            }
        }
    }

    private boolean itemUsedSpecialRede(Item item) {
        return item != null && item.getNome().equalsIgnoreCase("Rede de Vôlei");
    }

    private void reiniciarJogo() {
        jogador.setVida(100);
        jogador.setXp(0);
        jogador.setNivel(1);
        jogador.setDinheiro(50);
        jogador.setArmaEquipada(null);
        jogador.getInventario().clear();
        dialogo = new sistemaDialogo();
        emBatalha = false;
        inimigoDanoReduzido = false;
        if (lblDerrota != null) {
            lblDerrota.setVisible(false);
            lblDerrota.setManaged(false);
        }
        if (imgSprite != null) {
            imgSprite.setVisible(true);
        }
        atualizarTela();
    }

    private void atualizarTela() {
        atualizarTelaSemSobrescreverTexto(dialogo.getTextoAtual());
    }

    private void atualizarTelaSemSobrescreverTexto(String texto) {
        atualizarImagens();
        String nome = dialogo.getNomeAtual();
        if (nome == null || nome.isEmpty()) {
            lblPersonagemNome.setVisible(false);
        } else {
            lblPersonagemNome.setVisible(true);
            lblPersonagemNome.setText(nome);
        }

        lblTextoGameplay.setText(texto);
        boxEscolhasNarrativas.getChildren().clear();

        if (jogador.getVida() <= 0) {
            paneCombateInimigo.setVisible(false);
            paneCombateInimigo.setManaged(false);
            boxEscolhasCombate.setVisible(false);
            boxEscolhasCombate.setManaged(false);
            boxEscolhasNarrativas.setVisible(true);
            boxEscolhasNarrativas.setManaged(true);
            boxInventario.setVisible(false);
            boxInventario.setManaged(false);

            if (lblDerrota != null) {
                lblDerrota.setVisible(true);
                lblDerrota.setManaged(true);
            }
            if (imgSprite != null) {
                imgSprite.setVisible(false);
            }

            Button reiniciar = new Button("Reiniciar Jogo");
            reiniciar.setPrefWidth(300);
            util.EstiloUtils.aplicarBotaoPrimario(reiniciar);
            reiniciar.setOnAction(event -> reiniciarJogo());
            boxEscolhasNarrativas.getChildren().add(reiniciar);
        } else {
            if (lblDerrota != null) {
                lblDerrota.setVisible(false);
                lblDerrota.setManaged(false);
            }
            if (imgSprite != null) {
                imgSprite.setVisible(true);
            }

            if (emBatalha) {
                paneCombateInimigo.setVisible(true);
                paneCombateInimigo.setManaged(true);
                boxEscolhasCombate.setVisible(true);
                boxEscolhasCombate.setManaged(true);
                boxEscolhasNarrativas.setVisible(false);
                boxEscolhasNarrativas.setManaged(false);
                boxInventario.setVisible(false);
                boxInventario.setManaged(false);

                lblInimigoNome.setText(inimigoAtual.getNome());
                int vidaMax = 50;
                if (inimigoAtual instanceof Chefe) {
                    vidaMax = 100;
                } else if (inimigoAtual.getNome().equals("Quero-Quero")) {
                    vidaMax = 30;
                }
                lblInimigoVidaVal.setText(inimigoAtual.getVida() + "/" + vidaMax);
            } else {
                paneCombateInimigo.setVisible(false);
                paneCombateInimigo.setManaged(false);
                boxEscolhasCombate.setVisible(false);
                boxEscolhasCombate.setManaged(false);
                boxEscolhasNarrativas.setVisible(true);
                boxEscolhasNarrativas.setManaged(true);
                boxInventario.setVisible(false);
                boxInventario.setManaged(false);

                if (!dialogo.terminouDialogo()) {
                    criarBotaoContinuar();
                } else {
                    criarBotoesDestino();
                    if (dialogo.getLocalAtual() == Local.CANTINA) {
                        Button comprarBrownie = new Button("Comprar Brownie (R$ 10)");
                        comprarBrownie.setPrefWidth(300);
                        util.EstiloUtils.aplicarBotaoPrimario(comprarBrownie);
                        comprarBrownie.setOnAction(event -> {
                            if (jogador.getDinheiro() >= 10) {
                                jogador.setDinheiro(jogador.getDinheiro() - 10);
                                Comida brownie = new Comida(20, 10, "Brownie", tipoItem.COMIDA, "Recupera +20 de vida.");
                                jogador.adicionarItem(brownie);
                                atualizarStatusJogador();
                                lblTextoGameplay.setText("Você comprou um Brownie das gêmeas Lo e Ja!");
                            } else {
                                lblTextoGameplay.setText("Dinheiro insuficiente (Brownie custa R$ 10).");
                            }
                        });
                        boxEscolhasNarrativas.getChildren().add(0, comprarBrownie);
                    }
                }
            }
        }

        lblLocalNome.setText(formatarNome(dialogo.getLocalAtual()));
        verificarItens();
        atualizarStatusJogador();
    }
    
    private void verificarItens() {
        switch (dialogo.getLocalAtual()) {
            case BLOCO_A:
                if (!jogador.possuiItem("Livro do Governo")) {
                    Arma livro = new Arma(tipoArma.LIVRO_GOVERNO, 5, "Livro do Governo", tipoItem.ARMA, "Arma: aumenta o dano de ataque em +5.");
                    jogador.adicionarItem(livro);
                }
                break;
            case BLOCO_D_SEGUNDO_ANDAR:
                if (!jogador.possuiItem("Extintor")) {
                    Arma extintor = new Arma(tipoArma.EXTINTOR, 10, "Extintor", tipoItem.ARMA, "Arma: aumenta o dano de ataque em +10.");
                    jogador.adicionarItem(extintor);
                }
                break;
            case QUADRA:
                if (!jogador.possuiItem("Corda") && !jogador.possuiItem("Rede de Vôlei")) {
                    Arma corda = new Arma(tipoArma.CORDA, 15, "Corda", tipoItem.ARMA, "Arma: aumenta o dano de ataque em +15.");
                    Arma rede = new Arma(tipoArma.REDE_VOLEI, 0, "Rede de Vôlei", tipoItem.ARMA, "Uso único em combate: reduz o dano do oponente pela metade.");
                    jogador.adicionarItem(corda);
                    jogador.adicionarItem(rede);
                }
                break;
            case BLOCO_F:
                if (!jogador.possuiItem("Pastel do Tio")) {
                    Comida pastel = new Comida(999, 0, "Pastel do Tio", tipoItem.COMIDA, "Comida: recupera 100% de sua vida total.");
                    jogador.adicionarItem(pastel);
                }
                break;
        }
    }

    private void criarBotaoContinuar() {
        Button continuar = new Button("Continuar");
        continuar.setPrefWidth(300);
        util.EstiloUtils.aplicarBotaoPrimario(continuar);
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
        boxEscolhasNarrativas.getChildren().add(continuar);
    }

    private void criarBotoesDestino() {
        List<Local> destinos = dialogo.getDestinos();
        for (Local destino : destinos) {
            Button botao = new Button(formatarNome(destino));
            botao.setPrefWidth(300);
            util.EstiloUtils.aplicarBotaoPrimario(botao);
            botao.setOnAction(event -> {
                dialogo.mudarLocal(destino);
                atualizarTela();
            });
            boxEscolhasNarrativas.getChildren().add(botao);
        }
    }

    private String formatarNome(Local local) {
        switch (local) {
            case BLOCO_A: return "Bloco A";
            case BLOCO_B: return "Bloco B";
            case BLOCO_C: return "Bloco C";
            case BLOCO_D_EXTERNO: return "Bloco D";
            case BLOCO_D_HALL: return "Entrar no Bloco D";
            case BLOCO_D_SEGUNDO_ANDAR: return "2º Andar";
            case CANTINA: return "Cantina";
            case CAMINHO_BLOCO_E: return "Caminho para o Bloco E";
            case BLOCO_E: return "Bloco E";
            case BLOCO_F: return "Bloco F";
            case QUADRA: return "Quadra";
            case FLORESTA_AMORAS: return "Bosque das Amoras";
            default: return local.name();
        }
    }

    public void atualizarStatusJogador() {
        lblJogadorNome.setText(jogador.getNome());
        lblVidaVal.setText(jogador.getVida() + "/" + jogador.getVidaMaxima());
        
        int xpProximoNivel = 100 * (1 + jogador.getXp() / 100);
        lblXpVal.setText(jogador.getXp() + "/" + xpProximoNivel);
        
        lblDinheiro.setText("R$ " + jogador.getDinheiro() + ",00");
        
        String nomeArma = jogador.getArmaEquipada() != null ? jogador.getArmaEquipada().getNome() : "Nenhuma";
        lblArmaEquipada.setText(nomeArma);
    }

    private void iniciarBatalha() {
        emBatalha = true;
        inimigoDanoReduzido = false;
        if (dialogo.getLocalAtual() == Local.BLOCO_C) {
            inimigoAtual = queroQuero;
        } else {
            inimigoAtual = coruja;
        }
        inimigoAtual.setVida(inimigoAtual.getNome().equals("Quero-Quero") ? 30 : 50);
        atualizarTela();
    }

    private void atacarInimigo() {
        int danoArma = jogador.getArmaEquipada() != null ? jogador.getArmaEquipada().getDanoBonus() : 0;
        int danoDado = jogador.getDano() + danoArma;
        inimigoAtual.setVida(inimigoAtual.getVida() - danoDado);
        if (inimigoAtual.getVida() < 0) {
            inimigoAtual.setVida(0);
        }
        
        String nomeArma = jogador.getArmaEquipada() != null ? jogador.getArmaEquipada().getNome() : "mãos vazias";
        String feedback = "Você atacou " + inimigoAtual.getNome() + " usando " + nomeArma + " e causou " + danoDado + " de dano!\n";

        if (inimigoAtual.getVida() <= 0) {
            feedback = feedback + "Você derrotou o " + inimigoAtual.getNome() + "!\n";
            jogador.setXp(jogador.getXp() + inimigoAtual.getXpConcedido());
            emBatalha = false;
            
            if (inimigoAtual instanceof Chefe) {
                feedback = feedback + "Você derrotou o Capi e salvou a Pintas!";
                GameState.getInstance().setQueroQueroDerrotado(true);
            } else if (inimigoAtual == queroQuero) {
                GameState.getInstance().setQueroQueroDerrotado(true);
            } else {
                GameState.getInstance().setCorujaDerrotada(true);
            }
            
            dialogo.proximoDialogo();
            atualizarTelaSemSobrescreverTexto(feedback);
            return;
        }

        
        if (Math.random() < 0.3) {
            feedback = feedback + inimigoAtual.getNome() + " tentou atacar você, mas errou!";
        } else {
            int danoSofrido = inimigoAtual.getDano();
            if (inimigoDanoReduzido) {
                danoSofrido = Math.max(1, danoSofrido / 2);
            }
            jogador.setVida(jogador.getVida() - danoSofrido);
            if (jogador.getVida() < 0) {
                jogador.setVida(0);
            }
            feedback = feedback + inimigoAtual.getNome() + " atacou você e causou " + danoSofrido + " de dano!";
        }

        if (jogador.getVida() <= 0) {
            atualizarTelaSemSobrescreverTexto(feedback + "\n\nVocê foi derrotado!");
            return;
        }

        atualizarTelaSemSobrescreverTexto(feedback);
    }

    private void iniciarBatalhaFinal() {
        emBatalha = true;
        inimigoDanoReduzido = false;
        inimigoAtual = capi;
        inimigoAtual.setVida(100);
        atualizarTela();
    }

    private void fimDoJogo() {
        lblPersonagemNome.setText("Fim");
        lblTextoGameplay.setText("Parabéns! Você resgatou a Pintas.");
        
        boxEscolhasNarrativas.getChildren().clear();
        Button voltarMenu = new Button("Voltar ao menu");
        voltarMenu.setPrefWidth(300);
        util.EstiloUtils.aplicarBotaoSecundario(voltarMenu);
        voltarMenu.setOnAction(event -> {
            try {
                
                new dao.EstudanteDAO().atualizar(jogador);
                
                
                model.Partida partida = new model.Partida();
                partida.setEstudanteId(jogador.getId());
                partida.setPontuacao(jogador.getXp());
                partida.setInimigosDerrotados(2);
                partida.setChefeDerrotado(true);
                new dao.PartidaDAO().salvar(partida);
                
                GameState.getInstance().mudarTela("menu");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        boxEscolhasNarrativas.getChildren().add(voltarMenu);
    }

    @FXML
    public void atacar() {
        atacarInimigo();
    }

    @FXML
    public void defender() {
        if (!emBatalha) return;
        
        String feedback = "Você se defendeu e preparou sua guarda!\n";
        
        
        if (Math.random() < 0.5) {
            feedback = feedback + "Você bloqueou completamente o ataque de " + inimigoAtual.getNome() + "!";
        } else {
            int danoSofrido = inimigoAtual.getDano();
            if (inimigoDanoReduzido) {
                danoSofrido = Math.max(1, danoSofrido / 2);
            }
            danoSofrido = Math.max(1, danoSofrido / 2);
            jogador.setVida(jogador.getVida() - danoSofrido);
            if (jogador.getVida() < 0) {
                jogador.setVida(0);
            }
            feedback = feedback + inimigoAtual.getNome() + " atacou você e causou " + danoSofrido + " de dano (reduzido pela defesa)!";
        }
        
        if (jogador.getVida() <= 0) {
            atualizarTelaSemSobrescreverTexto(feedback + "\n\nVocê foi derrotado!");
            return;
        }
        
        atualizarTelaSemSobrescreverTexto(feedback);
    }

    @FXML
    public void usarItemCombate() {
        abrirInventario();
    }

    private void atualizarImagens() {
        
        String bgName = "menu.png";
        if (dialogo != null && dialogo.getLocalAtual() != null) {
            if (dialogo.getLocalAtual() == Local.ENTRADA) {
                if (dialogo.getIndice() == 0) {
                    bgName = "pintasjornal.png";
                } else {
                    bgName = "menu.png";
                }
            } else {
                switch (dialogo.getLocalAtual()) {
                    case BLOCO_A: bgName = "blocoA.png"; break;
                    case BLOCO_B: bgName = "blocoB.png"; break;
                    case BLOCO_C: bgName = "blocoC.png"; break;
                    case BLOCO_D_EXTERNO:
                    case BLOCO_D_HALL: bgName = "blocoD.png"; break;
                    case BLOCO_D_SEGUNDO_ANDAR: bgName = "2andarD.png"; break;
                    case CANTINA: bgName = "cantina.png"; break;
                    case CAMINHO_BLOCO_E:
                    case BLOCO_E: bgName = "blocoE.png"; break;
                    case QUADRA: bgName = "quadra.png"; break;
                    case BLOCO_F: bgName = "blocoF.png"; break;
                    case FLORESTA_AMORAS: bgName = "bosque.png"; break;
                    default: bgName = "menu.png"; break;
                }
            }
        }
        setImagem(imgBackground, bgName, 980, 680, false);

        String charName = null;
        if (emBatalha) {
            if (inimigoAtual != null) {
                charName = inimigoAtual.getNome();
            }
        } else {
            if (dialogo != null) {
                charName = dialogo.getNomeAtual();
            }
        }
        if (imgSprite != null) {
            if (charName != null && charName.equalsIgnoreCase("Estudante")) {
                imgSprite.setLayoutX(680.0);
                imgSprite.setLayoutY(140.0);
            } else {
                imgSprite.setLayoutX(40.0);
                imgSprite.setLayoutY(140.0);
            }
        }

        
        String spriteName = null;
        if (emBatalha) {
            if (inimigoAtual != null) {
                String enemyName = inimigoAtual.getNome();
                if (enemyName.equalsIgnoreCase("Quero-Quero")) {
                    spriteName = "queroquero.png";
                } else if (enemyName.equalsIgnoreCase("Coruja")) {
                    spriteName = "coruja.png";
                } else if (enemyName.equalsIgnoreCase("Capi")) {
                    spriteName = "capi.png";
                }
            }
        } else {
            if (dialogo != null) {
                String text = dialogo.getTextoAtual();
                if (charName != null && !charName.isEmpty() && !charName.startsWith("[")) {
                    if (charName.equalsIgnoreCase("Estudante")) {
                        spriteName = "estudante.png";
                    } else if (charName.equalsIgnoreCase("Lo e Ja")) {
                        spriteName = "LOeJA.png";
                    } else if (charName.equalsIgnoreCase("Tio do Pastel")) {
                        spriteName = "tio.png";
                    } else if (charName.equalsIgnoreCase("Pintas")) {
                        if (text != null && text.contains("Muitíssimo obrigado")) {
                            spriteName = "pintasfeliz.png";
                        } else {
                            spriteName = "pintas.png";
                        }
                    } else if (charName.equalsIgnoreCase("Capi")) {
                        spriteName = "capi.png";
                    }
                }
            }
        }
        setImagem(imgSprite, spriteName, 260, 420, true);
    }

    private void setImagem(ImageView iv, String filename, double reqWidth, double reqHeight, boolean preserveRatio) {
        if (iv == null) return;
        if (filename == null || filename.isEmpty()) {
            iv.setImage(null);
            return;
        }
        try {
            String path = "/view/images/" + filename;
            java.io.InputStream is = getClass().getResourceAsStream(path);
            if (is != null) {
                Image img = new Image(is, reqWidth, reqHeight, preserveRatio, true);
                iv.setImage(img);
                is.close();
            } else {
                iv.setImage(null);
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar imagem " + filename + ": " + e);
            iv.setImage(null);
        }
    }
}
