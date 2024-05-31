import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Magazzino {
    private List<Prodotto> magazzino;

    //costruttore
    public Magazzino() {
        this.magazzino = new ArrayList<>();
    }

    // Rimuovi un prodotto dall'inventario
    public Boolean rimuoviProdotto(UUID id) {
        return magazzino.removeIf(p -> p.getId().equals(id));
    }

    // Trova un prodotto per id
    Prodotto trovaProdottoPerId(UUID id) {
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getId().equals(id)) {
                return prodotto;
            }
        }
        return null;
    }

    public List<Prodotto> getMagazzino() {
        return magazzino;
    }

    public void setMagazzino(List<Prodotto> magazzino) {
        this.magazzino = magazzino;
    }
}