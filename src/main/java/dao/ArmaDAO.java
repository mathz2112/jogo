package dao;

import java.util.ArrayList;
import java.util.List;
import model.Arma;
import util.tipoArma;
import util.tipoItem;

public class ArmaDAO {
    public List<Arma> listarArmas() {
        List<Arma> lista = new ArrayList<>();
        lista.add(new Arma(tipoArma.LIVRO_GOVERNO, 10, "Livro do Governo", tipoItem.ARMA, "Um livro pesado distribuído pelo governo. Dói só de olhar."));
        lista.add(new Arma(tipoArma.EXTINTOR, 20, "Extintor de Incêndio", tipoItem.ARMA, "Um extintor de CO2 vermelho brilhante."));
        lista.add(new Arma(tipoArma.CORDA, 12, "Corda", tipoItem.ARMA, "Uma corda de sisal grossa."));
        lista.add(new Arma(tipoArma.REDE_VOLEI, 0, "Rede de Vôlei", tipoItem.ARMA, "Pode ser usada apenas uma vez em combate para reduzir o dano do adversário."));
        return lista;
    }
}
