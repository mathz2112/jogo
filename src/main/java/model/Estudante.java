/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 * @author aluno
 */
public class Estudante {
    private int id;
    private int vida; //inicia 100
    private int dano; // inicial 10
    private int dinheiro; //inicial 0
    private int xp; //inicial 0
    private List<Item> inventario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public List<Item> getInventario() {
        return inventario;
    }

    public void setInventario(List<Item> inventario) {
        this.inventario = inventario;
    }

    public Estudante(int id, int vida, int dano, int dinheiro, int xp, List<Item> inventario) {
        this.id = id;
        this.vida = vida;
        this.dano = dano;
        this.dinheiro = dinheiro;
        this.xp = xp;
        this.inventario = inventario;
    }
    
    
}
