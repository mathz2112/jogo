package dao;

import java.util.ArrayList;
import java.util.List;
import model.Inimigo;

public class InimigoDAO {
    public List<Inimigo> listarInimigos() {
        List<Inimigo> lista = new ArrayList<>();
        lista.add(new Inimigo("Quero-Quero", 30, 5, 50));
        lista.add(new Inimigo("Coruja", 50, 10, 50));
        return lista;
    }
}
