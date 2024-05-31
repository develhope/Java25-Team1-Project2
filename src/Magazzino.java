import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Magazzino {
    private List<Prodotto> magazzino;

    public Magazzino() {
        this.magazzino = new ArrayList<>();
    }

    public List<Prodotto> getMagazzino() {
        return magazzino;
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        magazzino.add(prodotto);
    }

    public void rimuoviProdotto(UUID id) {
        magazzino.removeIf(p -> p.getId().equals(id));
    }

    public Prodotto trovaProdottoPerId(UUID id) {
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getId().equals(id)) {
                return prodotto;
            }
        }
        return null;
    }
}
