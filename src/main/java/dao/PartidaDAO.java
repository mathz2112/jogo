package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Partida;
import util.GameState;

public class PartidaDAO {
    private static final List<Partida> rankingMock = new ArrayList<>();

    static {
        Partida p1 = new Partida();
        p1.setEstudanteId(1);
        p1.setNomeEstudante("Estudante IFMS");
        p1.setPontuacao(1200);
        p1.setInimigosDerrotados(3);
        p1.setChefeDerrotado(true);
        rankingMock.add(p1);

        Partida p2 = new Partida();
        p2.setEstudanteId(2);
        p2.setNomeEstudante("Gamer Pro");
        p2.setPontuacao(800);
        p2.setInimigosDerrotados(2);
        p2.setChefeDerrotado(false);
        rankingMock.add(p2);
    }

    public void salvar(Partida partida) {
        if (!GameState.getInstance().isDbConectado() || partida == null) {
            if (partida != null) {
                if (GameState.getInstance().getEstudanteAtual() != null) {
                    partida.setNomeEstudante(GameState.getInstance().getEstudanteAtual().getNome());
                } else {
                    partida.setNomeEstudante("Desconhecido");
                }
                rankingMock.add(partida);
                rankingMock.sort((a, b) -> Integer.compare(b.getPontuacao(), a.getPontuacao()));
            }
            return;
        }

        String sql = "INSERT INTO partida(data, estudante_id, pontuacao, inimigos_derrotados, chefe_derrotado) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setTimestamp(1, Timestamp.valueOf(partida.getDataPartida()));
            stmt.setInt(2, partida.getEstudanteId());
            stmt.setInt(3, partida.getPontuacao());
            stmt.setInt(4, partida.getInimigosDerrotados());
            stmt.setBoolean(5, partida.isChefeDerrotado());

            stmt.executeUpdate();
            System.out.println("Partida salva com sucesso!");

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar partida: " + e);
        }
    }

    public List<Partida> buscarRanking() {
        if (!GameState.getInstance().isDbConectado()) {
            return rankingMock;
        }

        List<Partida> ranking = new ArrayList<>();
        String sql = "SELECT p.*, e.nome AS estudante_nome FROM partida p JOIN estudante e ON p.estudante_id = e.id ORDER BY p.pontuacao DESC, p.data DESC LIMIT 15";
        
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Partida p = new Partida();
                p.setId(rs.getInt("id"));
                p.setEstudanteId(rs.getInt("estudante_id"));
                p.setPontuacao(rs.getInt("pontuacao"));
                p.setInimigosDerrotados(rs.getInt("inimigos_derrotados"));
                p.setChefeDerrotado(rs.getBoolean("chefe_derrotado"));
                p.setDataPartida(rs.getTimestamp("data").toLocalDateTime());
                p.setNomeEstudante(rs.getString("estudante_nome"));
                ranking.add(p);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar ranking: " + e);
            return rankingMock;
        }

        return ranking;
    }
}
