/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import util.tipoArma;

/**
 * 
 * @author aluno
 */
public class Arma extends Item{
    private tipoArma tipoArma;
    private int danoBonus;

    public tipoArma getTipoArma() {
        return tipoArma;
    }

    public void setTipoArma(tipoArma tipoArma) {
        this.tipoArma = tipoArma;
    }

    public int getDanoBonus() {
        return danoBonus;
    }

    public void setDanoBonus(int danoBonus) {
        this.danoBonus = danoBonus;
    }

    public Arma(tipoArma tipoArma, int danoBonus, String nome, util.tipoItem tipoItem, String descricao) {
        super(nome, tipoItem, descricao);
        this.tipoArma = tipoArma;
        this.danoBonus = danoBonus;
    }
    
    

}

