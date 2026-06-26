package model;

import java.time.LocalDateTime;

public class Partida {
    private int id;
    private int estudanteId;
    private String nomeEstudante;
    private int pontuacao;
    private int inimigosDerrotados;
    private boolean chefeDerrotado;
    private LocalDateTime dataPartida;

    public Partida() {
        this.dataPartida = LocalDateTime.now();
        this.nomeEstudante = "";
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getEstudanteId() { return estudanteId; }
    public void setEstudanteId(int estudanteId) { this.estudanteId = estudanteId; }

    public String getNomeEstudante() { return nomeEstudante; }
    public void setNomeEstudante(String nomeEstudante) { this.nomeEstudante = nomeEstudante; }

    public int getPontuacao() { return pontuacao; }
    public void setPontuacao(int pontuacao) { this.pontuacao = pontuacao; }

    public int getInimigosDerrotados() { return inimigosDerrotados; }
    public void setInimigosDerrotados(int inimigosDerrotados) { this.inimigosDerrotados = inimigosDerrotados; }

    private int posicao;

    public int getPosicao() { return posicao; }
    public void setPosicao(int posicao) { this.posicao = posicao; }

    public boolean isChefeDerrotado() { return chefeDerrotado; }
    public void setChefeDerrotado(boolean chefeDerrotado) { this.chefeDerrotado = chefeDerrotado; }

    public String getChefeDerrotadoTexto() {
        return chefeDerrotado ? "SIM" : "NÃO";
    }

    public LocalDateTime getDataPartida() { return dataPartida; }
    public void setDataPartida(LocalDateTime dataPartida) { this.dataPartida = dataPartida; }
}
