package model;

import util.tipoItem;

public class Comida extends Item {
    private int cura;
    private int custo;

    public Comida(int cura, int custo, String nome, tipoItem tipo, String descricao) {
        super(nome, tipo, descricao);
        this.cura = cura;
        this.custo = custo;
    }

    public int getCura() { return cura; }
    public void setCura(int cura) { this.cura = cura; }

    public int getCusto() { return custo; }
    public void setCusto(int custo) { this.custo = custo; }
}
