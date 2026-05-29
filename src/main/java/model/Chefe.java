/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 * @author aluno
 */
public class Chefe extends Inimigo{
    //Capi - encontrado na floresta de amoras
    private String habilidadeEspecial;

    public String getHabilidadeEspecial() {
        return habilidadeEspecial;
    }

    public void setHabilidadeEspecial(String habilidadeEspecial) {
        this.habilidadeEspecial = habilidadeEspecial;
    }

    public Chefe(String habilidadeEspecial, String nome, int vida, int dano, int xpConcedido) {
        super( nome, vida, dano, xpConcedido);
        this.habilidadeEspecial = habilidadeEspecial;
    }
 
}

