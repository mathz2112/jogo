/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RankingDAO {

public ArrayList<String> listarRanking() {

    ArrayList<String> ranking = new ArrayList<>();

    String sql = "SELECT * FROM partida ORDER BY pontuacao DESC";

    try {

        Connection conn =
                ConnectionFactory.getConnection();

        PreparedStatement stmt =
                conn.prepareStatement(sql);

        ResultSet rs =
                stmt.executeQuery();

        while (rs.next()) {

            String linha = "XP: " + rs.getInt("pontuacao") + " | Inimigos: " + rs.getInt("inimigos_derrotados") + " | Vitória: " + rs.getBoolean("chefe_derrotado");

            ranking.add(linha);

        }

        rs.close();
        stmt.close();
        conn.close();

    } catch (SQLException e) {

        System.out.println(e);

    }

    return ranking;

}

}
