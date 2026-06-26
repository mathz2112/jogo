package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Estudante;
import util.GameState;

public class EstudanteDAO {

    public Estudante buscarOuCriar(String nome) {
        if (!GameState.getInstance().isDbConectado()) {
            Estudante mock = new Estudante(nome);
            mock.setId(1);
            return mock;
        }

        String sqlSelect = "SELECT * FROM estudante WHERE nome = ?";
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlSelect);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Estudante estudante = new Estudante(nome);
                estudante.setId(rs.getInt("id"));
                estudante.setVida(rs.getInt("vida"));
                estudante.setDano(rs.getInt("dano"));
                estudante.setDinheiro(rs.getInt("dinheiro"));
                estudante.setXp(rs.getInt("xp"));
                estudante.setNivel(rs.getInt("nivel"));
                estudante.setUpgradeVida(rs.getInt("upgrade_vida"));
                estudante.setUpgradeDano(rs.getInt("upgrade_dano"));
                estudante.setUpgradeDinheiro(rs.getInt("upgrade_dinheiro"));

                rs.close();
                stmt.close();
                conn.close();
                return estudante;
            }

            rs.close();
            stmt.close();
            conn.close();

            Estudante novo = new Estudante(nome);
            salvar(novo);
            return buscar(nome);

        } catch (SQLException e) {
            System.out.println("Erro ao buscar estudante: " + e);
            Estudante mock = new Estudante(nome);
            mock.setId(999);
            return mock;
        }
    }

    private Estudante buscar(String nome) {
        String sql = "SELECT * FROM estudante WHERE nome = ?";
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Estudante estudante = new Estudante(nome);
                estudante.setId(rs.getInt("id"));
                estudante.setVida(rs.getInt("vida"));
                estudante.setDano(rs.getInt("dano"));
                estudante.setDinheiro(rs.getInt("dinheiro"));
                estudante.setXp(rs.getInt("xp"));
                estudante.setNivel(rs.getInt("nivel"));
                estudante.setUpgradeVida(rs.getInt("upgrade_vida"));
                estudante.setUpgradeDano(rs.getInt("upgrade_dano"));
                estudante.setUpgradeDinheiro(rs.getInt("upgrade_dinheiro"));
                
                rs.close();
                stmt.close();
                conn.close();
                return estudante;
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void salvar(Estudante estudante) {
        String sql = "INSERT INTO estudante(nome, vida, dano, dinheiro, xp, nivel, upgrade_vida, upgrade_dano, upgrade_dinheiro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, estudante.getNome());
            stmt.setInt(2, estudante.getVida());
            stmt.setInt(3, estudante.getDano());
            stmt.setInt(4, estudante.getDinheiro());
            stmt.setInt(5, estudante.getXp());
            stmt.setInt(6, estudante.getNivel());
            stmt.setInt(7, estudante.getUpgradeVida());
            stmt.setInt(8, estudante.getUpgradeDano());
            stmt.setInt(9, estudante.getUpgradeDinheiro());

            stmt.executeUpdate();
            System.out.println("Estudante salvo com sucesso!");

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar estudante: " + e);
        }
    }

    public void atualizar(Estudante estudante) {
        if (!GameState.getInstance().isDbConectado() || estudante == null) {
            return;
        }

        String sql = "UPDATE estudante SET vida = ?, dano = ?, dinheiro = ?, xp = ?, nivel = ?, upgrade_vida = ?, upgrade_dano = ?, upgrade_dinheiro = ? WHERE id = ?";
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, estudante.getVida());
            stmt.setInt(2, estudante.getDano());
            stmt.setInt(3, estudante.getDinheiro());
            stmt.setInt(4, estudante.getXp());
            stmt.setInt(5, estudante.getNivel());
            stmt.setInt(6, estudante.getUpgradeVida());
            stmt.setInt(7, estudante.getUpgradeDano());
            stmt.setInt(8, estudante.getUpgradeDinheiro());
            stmt.setInt(9, estudante.getId());

            stmt.executeUpdate();
            System.out.println("Estudante atualizado com sucesso!");

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar estudante: " + e);
        }
    }
}
