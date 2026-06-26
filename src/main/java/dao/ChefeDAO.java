package dao;

import java.util.ArrayList;
import java.util.List;
import model.Chefe;

public class ChefeDAO {
    public List<Chefe> listarChefes() {
        List<Chefe> chefes = new ArrayList<>();
        chefes.add(new Chefe("Capi", 100, 20, 100));
        return chefes;
    }
}
