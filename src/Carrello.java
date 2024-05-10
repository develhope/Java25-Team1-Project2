import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Carrello {
    private List<Prodotti> prodotti;

    public Carrello() {
        this.prodotti = new ArrayList<>();
    }

    // Aggiungi un prodotto al carrello
    public Boolean aggiungiProdotto(Prodotti prodotto) {
        return prodotti.add(prodotto);
    }

    // Rimuovi un prodotto dal carrello
    public Boolean rimuoviProdotto(UUID id) {
        for (Prodotti prodotto : prodotti) {
            if (prodotto.getId().equals(id)) {
                prodotti.remove(prodotto);
                return true;
            }
        }
        return false;
    }

    // Calcola il totale del carrello
    public double calcolaTotale() {
        double totale = 0;
        for (Prodotti prodotto : prodotti) {
            totale += prodotto.getPrezzoVendita();
        }
        return totale;
    }

    // Finalizza l'operazione di acquisto
    public void finalizzaAcquisto() {
        prodotti.clear();
        System.out.println("Acquisto concluso. Carrello svuotato.");
    }

    // Trova un prodotto nel carrello per id
    private Prodotti trovaProdottoPerId(UUID id) {
        for (Prodotti prodotto : prodotti) {
            if (prodotto.getId().equals(id)) {
                return prodotto;
            }
        }
        return null;
    }

    // Restituisce i prodotti nel carrello
    public List<Prodotti> getProdotti() {
        return prodotti;
    }
}