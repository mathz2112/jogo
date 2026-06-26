package model;

import java.util.ArrayList;
import java.util.List;

public class Estudante {
    private int id;
    private String nome;
    private int vida;
    private int dano;
    private int dinheiro;
    private int xp;
    private int nivel;

   
    private int upgradeVida;
    private int upgradeDano;
    private int upgradeDinheiro;

    private List<Item> inventario;

    public Estudante() {
        this.nome = "Estudante";
        this.vida = 100;
        this.dano = 10;
        this.dinheiro = 50;
        this.xp = 0;
        this.nivel = 1;
        this.upgradeVida = 0;
        this.upgradeDano = 0;
        this.upgradeDinheiro = 0;
        this.inventario = new ArrayList<>();
    }

    public Estudante(String nome) {
        this();
        this.nome = nome;
    }

    public void adicionarItem(Item item) {
        this.inventario.add(item);
    }

    public void removerItem(Item item) {
        this.inventario.remove(item);
    }

    public boolean possuiItem(String nomeItem) {
        for (Item item : this.inventario) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                return true;
            }
        }
        return false;
    }

    public int getVidaMaxima() {
        return 100 + (this.upgradeVida * 20);
    }

    public void recalcularAtributos() {
        this.vida = getVidaMaxima();
        this.dano = 10 + (this.upgradeDano * 5);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = vida; }

    public int getDano() { return dano; }
    public void setDano(int dano) { this.dano = dano; }

    public int getDinheiro() { return dinheiro; }
    public void setDinheiro(int dinheiro) { this.dinheiro = dinheiro; }

    public int getXp() { return xp; }
    public void setXp(int xp) { this.xp = xp; }

    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel; }

    public int getUpgradeVida() { return upgradeVida; }
    public void setUpgradeVida(int upgradeVida) { this.upgradeVida = upgradeVida; }

    public int getUpgradeDano() { return upgradeDano; }
    public void setUpgradeDano(int upgradeDano) { this.upgradeDano = upgradeDano; }

    public int getUpgradeDinheiro() { return upgradeDinheiro; }
    public void setUpgradeDinheiro(int upgradeDinheiro) { this.upgradeDinheiro = upgradeDinheiro; }

    public List<Item> getInventario() { return inventario; }
    public void setInventario(List<Item> inventario) { this.inventario = inventario; }

    private Arma armaEquipada;
    public Arma getArmaEquipada() { return armaEquipada; }
    public void setArmaEquipada(Arma armaEquipada) { this.armaEquipada = armaEquipada; }
}
