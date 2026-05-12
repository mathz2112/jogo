/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 * 
 * @author aluno
 */
public class Comida extends Item{
    private int cura;
    private int preco;

    public int getCura() {
        return cura;
    }

    public void setCura(int cura) {
        this.cura = cura;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public Comida(int cura, int preco, String nome, util.tipoItem tipoItem, String descricao) {
        super(nome, tipoItem, descricao);
        this.cura = cura;
        this.preco = preco;
    }
    
    

}

