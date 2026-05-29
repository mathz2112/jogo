/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Estudante;
import model.Inimigo;
import model.Partida;

/**
 *
 * @author aluno
 */
public class TESTEBD {
    //-------------------------------
   
   public void testeBD() {

        Estudante estudante = new Estudante();

        estudante.setVida(100);
        estudante.setDano(10);
        estudante.setDinheiro(50);
        estudante.setXp(0);

        EstudanteDAO estudanteDAO = new EstudanteDAO();

        estudanteDAO.estudanteDAO(estudante);

        Inimigo inimigo = new Inimigo();

        inimigo.setNome("Quero-Quero");
        inimigo.setVida(40);
        inimigo.setDano(5);
        inimigo.setXpConcedido(15);

        InimigoDAO inimigoDAO = new InimigoDAO();

        inimigoDAO.inimigoDAO(inimigo);

        Partida partida = new Partida();

        partida.setEstudanteId(1);
        partida.setPontuacao(0);
        partida.setInimigosDerrotados(0);
        partida.setChefeDerrotado(false);

        PartidaDAO partidaDAO = new PartidaDAO();

        partidaDAO.partidaDAO(partida);
    }
    
}
