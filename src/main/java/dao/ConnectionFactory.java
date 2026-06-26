    package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import util.GameState;

public class ConnectionFactory {
    private static String url = "jdbc:postgresql://localhost:5432/jogo";
    private static String usuario = "postgres";
    private static String senha = "postgresql";
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return DriverManager.getConnection(url, usuario, senha);
    }

    public static void inicializarBanco() {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            
            String sqlEstudante = "CREATE TABLE IF NOT EXISTS estudante (" +
                    "id SERIAL PRIMARY KEY," +
                    "nome VARCHAR(100) NOT NULL UNIQUE," +
                    "vida INT NOT NULL DEFAULT 100," +
                    "dano INT NOT NULL DEFAULT 10," +
                    "dinheiro INT NOT NULL DEFAULT 50," +
                    "xp INT NOT NULL DEFAULT 0," +
                    "nivel INT NOT NULL DEFAULT 1," +
                    "upgrade_vida INT NOT NULL DEFAULT 0," +
                    "upgrade_dano INT NOT NULL DEFAULT 0," +
                    "upgrade_dinheiro INT NOT NULL DEFAULT 0" +
                    ")";
            stmt.execute(sqlEstudante);

            String sqlPartida = "CREATE TABLE IF NOT EXISTS partida (" +
                    "id SERIAL PRIMARY KEY," +
                    "data TIMESTAMP NOT NULL," +
                    "estudante_id INT NOT NULL REFERENCES estudante(id) ON DELETE CASCADE," +
                    "pontuacao INT NOT NULL DEFAULT 0," +
                    "inimigos_derrotados INT NOT NULL DEFAULT 0," +
                    "chefe_derrotado BOOLEAN NOT NULL DEFAULT FALSE" +
                    ")";
            stmt.execute(sqlPartida);

            stmt.close();
            conn.close();
            GameState.getInstance().setDbConectado(true);
            System.out.println("Banco de dados inicializado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inicializar banco (PostgreSQL offline): " + e.getMessage());
            GameState.getInstance().setDbConectado(false);
        }
    }
}


