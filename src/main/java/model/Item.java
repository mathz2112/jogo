/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import util.tipoItem;

/**
 *
 * @author aluno
 */
class Item {
    private String nome;
    private tipoItem tipoItem; // arma, consumível, chave [ENUM]
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public tipoItem getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(tipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Item(String nome, tipoItem tipoItem, String descricao) {
        this.nome = nome;
        this.tipoItem = tipoItem;
        this.descricao = descricao;
    } 

}
