import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        System.out.println(listaProdottiMagazzino);
    }

    // TODO aggiungi metodo stampa duplicati , se trova due prodotti uguali stampa il prodotto una volta sola. Che venga aggiunga il numero di prodotti contenuti nel magazzino
    /*public void stampaDuplicati(listaProdottiMagazzino) {
       for(Prodotto prodotto : listaProdottiMagazzino){

        }
       */
}

