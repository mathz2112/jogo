/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Item;

/**
 *
 * @author aluno
 */
public class ItemDAO {
    
    public void itemDAO(Item item) {

        String sql = "INSERT INTO item (nome, descricao, tipo_item) VALUES (?, ?, ?)";

        try {

            Connection conn = ConnectionFactory.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getDescricao());
            stmt.setString(3, item.getTipoItem().toString());

            stmt.executeUpdate();

            System.out.println("Item salvo com sucesso!");

            stmt.close();
            conn.close();

        } catch (SQLException e) {

            System.out.println(e);

        }
    }
}
