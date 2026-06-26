package controller;

import dao.PartidaDAO;
import model.Partida;
import util.GameState;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class RankingController {

    @FXML private ListView<String> listRanking;
    @FXML private javafx.scene.control.Button btnVoltar;

    private final PartidaDAO partidaDAO = new PartidaDAO();
    private List<Partida> rankingList;

    @FXML
    public void initialize() {
        rankingList = partidaDAO.buscarRanking();
        listRanking.getItems().clear();
        for (int i = 0; i < rankingList.size(); i++) {
            Partida p = rankingList.get(i);
            String chefe = p.isChefeDerrotado() ? "Sim" : "Nao";
            String dataStr = p.getDataPartida().toString().replace("T", " ");
            listRanking.getItems().add((i + 1) + ". " + p.getNomeEstudante() + " - " + p.getPontuacao() + " XP - Inimigos Derrotados: " + p.getInimigosDerrotados() + " - Chefe Derrotado: " + chefe + " - " + dataStr);
        }

        if (btnVoltar != null) {
            util.EstiloUtils.aplicarBotaoSecundario(btnVoltar);
        }
        if (listRanking != null) {
            util.EstiloUtils.aplicarListView(listRanking);
        }
    }

    @FXML
    public void voltar() {
        GameState.getInstance().mudarTela("menu");
    }
}
