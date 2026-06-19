/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Estudante;

public class EstudanteDAO {

    public int estudanteDAO(Estudante estudante) {

        String sql = "INSERT INTO estudante(vida,dano,dinheiro,xp) VALUES (?,?,?,?)";

        try {

            Connection conn = ConnectionFactory.getConnection();

            PreparedStatement stmt = conn.prepareStatement(
                    sql,
                    PreparedStatement.RETURN_GENERATED_KEYS
            );

            stmt.setInt(1, estudante.getVida());
            stmt.setInt(2, estudante.getDano());
            stmt.setInt(3, estudante.getDinheiro());
            stmt.setInt(4, estudante.getXp());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {

                int id = rs.getInt(1);

                estudante.setId(id);

                System.out.println("Estudante salvo com sucesso!");

                rs.close();
                stmt.close();
                conn.close();

                return id;
            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {

            System.out.println(e);
        }

        return -1;
    }
}