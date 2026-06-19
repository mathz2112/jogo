
package model;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aluno
 */
public class Estudante {
    private int id;
    private int vida; //inicia 100
    private int dano; // inicial 10
    private int dinheiro; //inicjava ial 0
    private int xp; //inicial 0
    private List<Item> inventario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public List<Item> getInventario() {
        return inventario;
    }

    public void setInventario(List<Item> inventario) {
        this.inventario = inventario;
    }

    public Estudante(int id, int vida, int dano, int dinheiro, int xp, List<Item> inventario) {
        this.id = id;
        this.vida = vida;
        this.dano = dano;
        this.dinheiro = dinheiro;
        this.xp = xp;
        this.inventario = inventario;
    }

   public Estudante() {

    vida = 100;
    dano = 10;
    dinheiro = 50;
    xp = 0;

    inventario = new ArrayList<>();

        }
    
      public void adicionarItem(Item item){

    inventario.add(item);

    }

        public void removerItem(Item item){

    inventario.remove(item);

    }

   public boolean possuiItem(String nome){

    for(Item item : inventario){

        if(item.getNome().equalsIgnoreCase(nome)){

            return true;

        }

    }

    return false;

    }

    }



