package dao;

import java.util.ArrayList;
import java.util.List;
import model.Item;
import util.tipoItem;

public class ItemDAO {
    public List<Item> listarItens() {
        List<Item> lista = new ArrayList<>();
        lista.add(new Item("Chave do Laboratório", tipoItem.CHAVE, "Abre a sala final"));
        return lista;
    }
}
