/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo;

/**
 *
 * @author aluno
 */
import dao.CriarPartida;
import dao.EstudanteDAO;
import model.Estudante;
import model.Partida;

public class TesteBD {

    public static void main(String[] args) {
/*
        Estudante estudante = new Estudante();

        estudante.setVida(100);
        estudante.setDano(10);
        estudante.setDinheiro(50);
        estudante.setXp(0);

        EstudanteDAO dao = new EstudanteDAO();

        dao.estudanteDAO(estudante);

    }
 */

    Partida partida = new Partida();

    partida.setEstudanteId(1); // use um id que exista no banco
    partida.setPontuacao(100);
    partida.setInimigosDerrotados(2);
    partida.setChefeDerrotado(false);

    CriarPartida criarPartida = new CriarPartida();

    criarPartida.create(partida);

}

}
