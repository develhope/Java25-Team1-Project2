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

    public void stampaProdottoPerId(UUID id) {
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getId().equals(id)) {
                System.out.println(prodotto);
            }
        }
        System.out.println(" Prodotto non trovato.");
    }

    // TODO aggiungi metodo stampa prodotti

    // TODO aggiungi metodo stampa duplicati
}
