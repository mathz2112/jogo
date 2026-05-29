/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Partida;

/**
 *
 * @author aluno
 */
public class PartidaDAO {
     public void partidaDAO(Partida partida) {

        String sql = "INSERT INTO partida (data, estudante_id, pontuacao, inimigos_derrotados, chefe_derrotado) VALUES (?, ?, ?, ?, ?)";

        try {

            Connection conn = ConnectionFactory.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setTimestamp(1, java.sql.Timestamp.from(partida.getData()));
            stmt.setInt(2, partida.getEstudanteId());
            stmt.setInt(3, partida.getPontuacao());
            stmt.setInt(4, partida.getInimigosDerrotados());
            stmt.setBoolean(5, partida.isChefeDerrotado());

            stmt.executeUpdate();

            System.out.println("Partida salva com sucesso!");

            stmt.close();
            conn.close();

        } catch (SQLException e) {

            System.out.println(e);

        }
    }
}
