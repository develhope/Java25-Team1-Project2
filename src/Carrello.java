import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Carrello {
    private List<Prodotti> prodotti;
    private Magazzino magazzino;

    public Carrello(Magazzino magazzino) {
        this.prodotti = new ArrayList<>();
        this.magazzino = magazzino;
    }

    // Aggiungi un prodotto al carrello
    public Boolean aggiungiProdotto(Prodotti prodotto) {
        Boolean aggProdotto = prodotti.add(prodotto);
        if(aggProdotto){
            magazzino.rimuoviProdotto(prodotto.getId());
        }
        return aggProdotto;
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

    public Boolean rimuoviProdotto(UUID id) {
        for (Prodotti prodotto : prodotti) {
            if (prodotto.getId().equals(id)) {
                Boolean rimuoviProdotto = prodotti.remove(prodotto);
                if (rimuoviProdotto) {
                    magazzino.aggiungiProdotto(prodotto);
                }
                return rimuoviProdotto;
            }
        } return false;
    }



    // Rimuove un prodotto dal carrello tramite l'ID e aggiorna l'inventario nel magazzino
    public List<Prodotti> rimuoviProdottoDalCarrello(UUID id) {
        Prodotti prodottoDaRimuovere = null;
        for (Prodotti prodotto : prodotti) {
            if (prodotto.getId().equals(id)) {
                prodottoDaRimuovere = prodotto;
                break;
            }
        }
        if (prodottoDaRimuovere != null) {
            prodotti.remove(prodottoDaRimuovere);
            // Aggiorna l'inventario nel magazzino
            magazzino.aggiungiProdotto(prodottoDaRimuovere);
            System.out.println("Prodotto rimosso dal carrello e aggiunto nuovamente al magazzino.");
        } else {
            System.out.println("Prodotto non trovato nel carrello.");
        }
        return prodotti;
    }

    public void visualizzaCarrello() {
        System.out.println("Prodotti nel carrello:");
        for (Prodotti prodotto : prodotti) {
            System.out.println(prodotto);
        }
    }


    }
