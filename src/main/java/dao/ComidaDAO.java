package dao;

import java.util.ArrayList;
import java.util.List;
import model.Comida;
import util.tipoItem;

public class ComidaDAO {
    public List<Comida> listarComidas() {
        List<Comida> lista = new ArrayList<>();
        lista.add(new Comida(20, 10, "Brownie das Gêmeas", tipoItem.COMIDA, "Recupera +20 de vida"));
        lista.add(new Comida(100, 20, "Pastel do Tio", tipoItem.COMIDA, "Recupera toda a vida"));
        return lista;
    }
}
