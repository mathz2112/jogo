/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.time.Instant;

/**
 * 
 * @author aluno
 */
public class Partida {
    private int id;
    private Instant data; //bd => data
    private int estudanteId;
    private int pontuacao; //xp
    private int inimigosDerrotados;
    private boolean chefeDerrotado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public int getEstudanteId() {
        return estudanteId;
    }

    public void setEstudanteId(int estudanteId) {
        this.estudanteId = estudanteId;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getInimigosDerrotados() {
        return inimigosDerrotados;
    }

    public void setInimigosDerrotados(int inimigosDerrotados) {
        this.inimigosDerrotados = inimigosDerrotados;
    }

    public boolean isChefeDerrotado() {
        return chefeDerrotado;
    }

    public void setChefeDerrotado(boolean chefeDerrotado) {
        this.chefeDerrotado = chefeDerrotado;
    }

    public Partida(int id, Instant data, int estudanteId, int pontuacao, int inimigosDerrotados, boolean chefeDerrotado) {
        this.id = id;
        this.data = data;
        this.estudanteId = estudanteId;
        this.pontuacao = pontuacao;
        this.inimigosDerrotados = inimigosDerrotados;
        this.chefeDerrotado = chefeDerrotado;
    }
    
    


}

