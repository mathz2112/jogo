/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Inimigo;

/**
 *
 * @author aluno
 */
public class InimigoDAO {
    
    public void inimigoDAO(Inimigo inimigo) {

        String sql = "INSERT INTO inimigo (nome, vida, dano, xp_concedido) VALUES (?, ?, ?, ?)";

        try {

            Connection conn = ConnectionFactory.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, inimigo.getNome());
            stmt.setInt(2, inimigo.getVida());
            stmt.setInt(3, inimigo.getDano());
            stmt.setInt(4, inimigo.getXpConcedido());

            stmt.executeUpdate();

            System.out.println("Inimigo salvo com sucesso!");

            stmt.close();
            conn.close();

        } catch (SQLException e) {

            System.out.println(e);

        }
    }
    
}
