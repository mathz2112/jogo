/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author aluno
 */
public class Jogador {
    private int id;
    private int vida;
    private int dano;
    private int dinheiro;
    private int xp;
    private int nivel;
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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public List<Item> getInventario() {
        return inventario;
    }

    public void setInventario(List<Item> inventario) {
        this.inventario = inventario;
    }

    public Jogador(int id, int vida, int dano, int dinheiro, int xp, int nivel, List<Item> inventario) {
        this.id = id;
        this.vida = vida;
        this.dano = dano;
        this.dinheiro = dinheiro;
        this.xp = xp;
        this.nivel = nivel;
        this.inventario = inventario;
    }
    
    
}
