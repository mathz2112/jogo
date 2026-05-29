/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Arma;

/**
 *
 * @author aluno
 */
public class ArmaDAO {
     public void armaDAO(Arma arma, int itemId) {

        String sql = "INSERT INTO arma (item_id, tipo_arma, bonus_dano) VALUES (?, ?, ?)";

        try {

            Connection conn = ConnectionFactory.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, itemId);
            stmt.setString(2, arma.getTipoArma().toString());
            stmt.setInt(3, arma.getDanoBonus());

            stmt.executeUpdate();

            System.out.println("Arma salva com sucesso!");

            stmt.close();
            conn.close();

        } catch (SQLException e) {

            System.out.println(e);

        }
    }
}
