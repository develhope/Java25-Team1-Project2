import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Magazzino {
    // TODO rifattorizzare nome con lista prodotti
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

    // TODO deve lavorare su oggetto della lista
    public void rimuoviProdotto(UUID id) {
        magazzino.remove();
    }

    // TODO metodo non può restituire null - diventa void e stampa direttamente oggetto
    public void Prodotto stampaProdottoPerId(UUID id) {
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getId().equals(id)) {
                return prodotto;
            }
        }
        return null;
    }

    // TODO aggiungi metodo stampa prodotti
    // TODO aggiungi metodo stampa duplicati
}
