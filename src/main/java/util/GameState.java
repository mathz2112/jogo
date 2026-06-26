package util;

import com.mycompany.jogo.App;
import model.Estudante;
import model.Inimigo;
import model.Partida;

public class GameState {
    private static GameState instance;

    private Estudante estudanteAtual;
    private Partida partidaAtual;
    private Local localAtual;
    private boolean dbConectado;

    private boolean livroGovernoAchado;
    private boolean extintorAchado;
    private boolean itensQuadraAchados;
    private boolean dinheiroBlocoBAchado;
    private boolean queroQueroDerrotado;
    private boolean corujaDerrotada;
    private int xpGanhoRun;

    private Inimigo inimigoCombate;
    private String emojiInimigo;

    private GameState() {
        this.dbConectado = false;
    }

    public static GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }

    public void iniciarNovaRun() {
        this.partidaAtual = new Partida();
        this.localAtual = Local.ENTRADA;
        this.xpGanhoRun = 0;
        
        this.livroGovernoAchado = false;
        this.extintorAchado = false;
        this.itensQuadraAchados = false;
        this.dinheiroBlocoBAchado = false;
        this.queroQueroDerrotado = false;
        this.corujaDerrotada = false;

        if (this.estudanteAtual != null) {
            this.estudanteAtual.recalcularAtributos();
            this.estudanteAtual.getInventario().clear();
            
            int dinheiroInicial = this.estudanteAtual.getUpgradeDinheiro() * 10;
            this.estudanteAtual.setDinheiro(dinheiroInicial);
            
            this.partidaAtual.setEstudanteId(this.estudanteAtual.getId());
        }
    }

    public void mudarTela(String fxmlName) {
        try {
            App.setRoot(fxmlName);
        } catch (Exception e) {
            System.out.println("Erro ao carregar FXML: " + fxmlName);
            System.out.println(e);
        }
    }

    public String getFxmlDoLocal(Local local) {
        switch (local) {
            case ENTRADA: return "entrada";
            case BLOCO_A: return "blocoA";
            case BLOCO_B: return "blocoB";
            case BLOCO_C: return "blocoC";
            case BLOCO_D_HALL: return "blocoD_hall";
            case CANTINA: return "cantina";
            case BLOCO_D_SEGUNDO_ANDAR: return "blocoD_2andar";
            case BLOCO_E: return "blocoE";
            case QUADRA: return "quadra";
            case CAMINHO_BLOCO_E: return "blocoE";
            case BLOCO_F: return "blocoF";
            case FLORESTA_AMORAS: return "gameplay";
            default: return "menu";
        }
    }

    public Estudante getEstudanteAtual() { return estudanteAtual; }
    public void setEstudanteAtual(Estudante estudanteAtual) { this.estudanteAtual = estudanteAtual; }

    public Partida getPartidaAtual() { return partidaAtual; }
    public void setPartidaAtual(Partida partidaAtual) { this.partidaAtual = partidaAtual; }

    public Local getLocalAtual() { return localAtual; }
    public void setLocalAtual(Local localAtual) { this.localAtual = localAtual; }

    public boolean isDbConectado() { return dbConectado; }
    public void setDbConectado(boolean dbConectado) { this.dbConectado = dbConectado; }

    public boolean isLivroGovernoAchado() { return livroGovernoAchado; }
    public void setLivroGovernoAchado(boolean livroGovernoAchado) { this.livroGovernoAchado = livroGovernoAchado; }

    public boolean isExtintorAchado() { return extintorAchado; }
    public void setExtintorAchado(boolean extintorAchado) { this.extintorAchado = extintorAchado; }

    public boolean isItensQuadraAchados() { return itensQuadraAchados; }
    public void setItensQuadraAchados(boolean itensQuadraAchados) { this.itensQuadraAchados = itensQuadraAchados; }

    public boolean isDinheiroBlocoBAchado() { return dinheiroBlocoBAchado; }
    public void setDinheiroBlocoBAchado(boolean dinheiroBlocoBAchado) { this.dinheiroBlocoBAchado = dinheiroBlocoBAchado; }

    public boolean isQueroQueroDerrotado() { return queroQueroDerrotado; }
    public void setQueroQueroDerrotado(boolean queroQueroDerrotado) { this.queroQueroDerrotado = queroQueroDerrotado; }

    public boolean isCorujaDerrotada() { return corujaDerrotada; }
    public void setCorujaDerrotada(boolean corujaDerrotada) { this.corujaDerrotada = corujaDerrotada; }

    public int getXpGanhoRun() { return xpGanhoRun; }
    public void setXpGanhoRun(int xpGanhoRun) { this.xpGanhoRun = xpGanhoRun; }
    public void adicionarXpRun(int valor) { this.xpGanhoRun += valor; }

    public Inimigo getInimigoCombate() { return inimigoCombate; }
    public void setInimigoCombate(Inimigo inimigoCombate) { this.inimigoCombate = inimigoCombate; }

    public String getEmojiInimigo() { return emojiInimigo; }
    public void setEmojiInimigo(String emojiInimigo) { this.emojiInimigo = emojiInimigo; }
}
