import java.util.ArrayList;
import java.util.List;

public class Carrello {
    private List<Prodotto> listaProdottiCarrello;

    public Carrello() {
        this.listaProdottiCarrello = new ArrayList<>();
    }

    public List<Prodotto> getListaProdottiCarrello() {
        return listaProdottiCarrello;
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        listaProdottiCarrello.add(prodotto);
    }

    public void rimuoviProdotto(Prodotto prodotto) {
        listaProdottiCarrello.remove(prodotto);
    }

    public void stampaProdottiCarrello() {
        System.out.println("Lista prodotti Carrello: ");
        for (Prodotto prodotto : listaProdottiCarrello) {
            System.out.println(prodotto);
        }
    }

    public double calcolaTotaleCarrello() {
        double totale = 0.0;
        for (Prodotto prodotto : listaProdottiCarrello) {
            totale += prodotto.getPrezzoVendita();
        }
        return totale;
    }


    public boolean effettuaPagamento() {
        // fingo che sto vendendo effettivamente un prodotto.
        if (listaProdottiCarrello.isEmpty()) {
            System.out.println("Il carrello è vuoto. Impossibile effettuare il pagamento.");
            return false;
        }
        double totaleCarrello = calcolaTotaleCarrello();
        System.out.println("Il totale da pagare è: " + totaleCarrello + " €");
        confermaAcquisto();
        return true;
    }


    public void confermaAcquisto(){
        //per refreshare la lista carrello in fase di acquisto.
        listaProdottiCarrello.clear();
        System.out.println("Acquisto confermato. Grazie per il tuo acquisto!");
        System.out.println("Il carrello è stato svuotato.");
    }
}