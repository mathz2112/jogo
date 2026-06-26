package model;

import util.tipoArma;
import util.tipoItem;

public class Arma extends Item {
    private tipoArma tipoArma;
    private int danoBonus;

    public Arma(tipoArma tipoArma, int danoBonus, String nome, tipoItem tipo, String descricao) {
        super(nome, tipo, descricao);
        this.tipoArma = tipoArma;
        this.danoBonus = danoBonus;
    }

    public tipoArma getTipoArma() { return tipoArma; }
    public void setTipoArma(tipoArma tipoArma) { this.tipoArma = tipoArma; }

    public int getDanoBonus() { return danoBonus; }
    public void setDanoBonus(int danoBonus) { this.danoBonus = danoBonus; }
}
