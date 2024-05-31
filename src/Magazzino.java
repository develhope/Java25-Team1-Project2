import java.util.ArrayList;
import java.util.List;

public class Magazzino {
    private List<Prodotto> magazzino;

    //costruttore
    public Magazzino() {
        this.magazzino = new ArrayList<>();
    }

    public List<Prodotto> getMagazzino() {
        return magazzino;
    }

    public void setmagazzino(List<Prodotto> magazzino) {
        this.magazzino = magazzino;
    }

}