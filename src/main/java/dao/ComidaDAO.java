/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Comida;

/**
 *
 * @author aluno
 */
public class ComidaDAO {
    public void comidaDAO(Comida comida, int itemId) {

        String sql = "INSERT INTO comida (item_id, cura, preco) VALUES (?, ?, ?)";

        try {

            Connection conn = ConnectionFactory.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, itemId);
            stmt.setInt(2, comida.getCura());
            stmt.setInt(3, comida.getPreco());

            stmt.executeUpdate();

            System.out.println("Comida salva com sucesso!");

            stmt.close();
            conn.close();

        } catch (SQLException e) {

            System.out.println(e);

        }
    }
}
