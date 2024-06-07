import java.util.*;

class Magazzino {
    private List<Prodotto> listaProdottiMagazzino;

    public Magazzino() {
        this.listaProdottiMagazzino = new ArrayList<>();
    }

    public List<Prodotto> getListaProdottiMagazzino() {
        return listaProdottiMagazzino;
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        listaProdottiMagazzino.add(prodotto);
    }

    // TODO deve lavorare su oggetto della lista
    public void rimuoviProdotto(UUID id) {
        listaProdottiMagazzino.remove(listaProdottiMagazzino);
    }

    public void stampaProdottoPerId(UUID id) {
        for (Prodotto prodotto : listaProdottiMagazzino) {
            if (prodotto.getId().equals(id)) {
                System.out.println(prodotto);
            }
        }
        System.out.println(" Prodotto non trovato.");
    }

    // TODO aggiungi metodo stampa prodotti

    public void stampaProdotti() {
        for (Prodotto prodotto : listaProdottiMagazzino) {
            System.out.println(prodotto);
        }
    }

    // TODO aggiungi metodo stampa duplicati , se trova due prodotti uguali stampa il prodotto una volta sola. Che venga aggiunga il numero di prodotti contenuti nel magazzino
    public void stampaDuplicati() {
        Map<Prodotto, Integer> prodottoCount = new HashMap<>();
        for (Prodotto prodotto : listaProdottiMagazzino) {
            prodottoCount.put(prodotto, prodottoCount.getOrDefault(prodotto, 0) + 1);
        }

        for (Map.Entry<Prodotto, Integer> entry : prodottoCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " - Quantità: " + entry.getValue());
            }
        }
    }
}

