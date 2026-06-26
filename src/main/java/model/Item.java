package model;

import util.tipoItem;

public class Item {
    private String nome;
    private tipoItem tipo;
    private String descricao;

    public Item(String nome, tipoItem tipo, String descricao) {
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public tipoItem getTipo() { return tipo; }
    public void setTipo(tipoItem tipo) { this.tipo = tipo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    @Override
    public String toString() {
        return nome;
    }
}
