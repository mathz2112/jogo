package model;

public class Inimigo {
    private String nome;
    private int vida;
    private int dano;
    private int xpConcedido;

    public Inimigo(String nome, int vida, int dano, int xpConcedido) {
        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
        this.xpConcedido = xpConcedido;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = vida; }

    public int getDano() { return dano; }
    public void setDano(int dano) { this.dano = dano; }

    public int getXpConcedido() { return xpConcedido; }
    public void setXpConcedido(int xpConcedido) { this.xpConcedido = xpConcedido; }
}
