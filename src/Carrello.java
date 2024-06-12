import java.util.ArrayList;
import java.util.List;

public class Carrello {
    private List<Prodotto> listaProdottiCarrello;
    //public Magazzino magazzino = new Magazzino();

    public Carrello() {
        this.listaProdottiCarrello = new ArrayList<>();
    }

    public List<Prodotto> getListaProdottiCarrello() {
        return listaProdottiCarrello;
    }

    public void aggiungiProdottoACarrello(Prodotto prodotto) {
        // Aggiunta del prodotto al carrello con rimozione dal magazzino.
        listaProdottiCarrello.add(prodotto);
        magazzino.getListaProdottiMagazzino().remove(prodotto);
        // Visualizzazione del totale provvisorio del carrello, numero di articoli presenti nel carrello e la visualizzazione della lista completa del carrello.
        System.out.println("Totale provvisorio carrello: " + calcolaTotaleCarrello());
        System.out.println("Prodotti nel carrello: " + listaProdottiCarrello.size());
        System.out.println(listaProdottiCarrello);
    }

    public double calcolaTotaleCarrello() {
        double totale = 0;
        for (Prodotto prodotto : listaProdottiCarrello) {
            totale += prodotto.getPrezzoVendita();
        }
        return totale;
    }

    // TODO completare metodo finalizzaAcquistoCarrello
    public void finalizzaAcquistoCarrello() {
        // Implementazione del metodo per finalizzare l'acquisto
    }

    public void rimuoviProdottoDalCarrello(Prodotto prodotto) {
        listaProdottiCarrello.remove(prodotto);
        magazzino.getListaProdottiMagazzino().add(prodotto);
    }

    public void visualizzaCarrello() {
        for (Prodotto prodotto : listaProdottiCarrello) {
            System.out.println(prodotto);
        }
    }
}