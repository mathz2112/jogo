/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Chefe;

/**
 *
 * @author aluno
 */
public class ChefeDAO {
    public void chefeDAO(Chefe chefe, int inimigoId) {

        String sql = "INSERT INTO chefe (inimigo_id, habilidade_especial) VALUES (?, ?)";

        try {

            Connection conn = ConnectionFactory.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, inimigoId);
            stmt.setString(2, chefe.getHabilidadeEspecial());

            stmt.executeUpdate();

            System.out.println("Chefe salvo com sucesso!");

            stmt.close();
            conn.close();

        } catch (SQLException e) {

            System.out.println(e);

        }
    }
    
}
