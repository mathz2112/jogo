/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import model.Chefe;
import model.Estudante;
import model.Inimigo;
import model.Partida;

/**
 *
 * @author aluno
 */
public class CriarPartida {
   
   public void create(Partida partida){
       
       String sql = "INSERT INTO partida "
               + "(id,data,estudante_id,pontuacao,inimigos_derrotados,chefe_derrotado) VALUES (?,?,?,?,?,?)";
       
       ConnectionFactory conexao = new ConnectionFactory();
       
       try{
           Connection connection = conexao.getConnection();
           
           PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setInt(1, partida.getId());
           stmt.setTimestamp(2, Timestamp.from(Instant.now()));
           stmt.setInt(3, partida.getEstudanteId());
           stmt.setInt(4, partida.getPontuacao());
           stmt.setInt(5, partida.getInimigosDerrotados());
           stmt.setBoolean(6, partida.isChefeDerrotado());
           
           System.out.println("dfdfdf");
           
           int linhasAfetadas = stmt.executeUpdate();
           
           if(linhasAfetadas > 0){
               System.out.println("Partida inicializada!");
           }
           
       }catch(SQLException e){
           System.out.println(e);
       }
   }
}
