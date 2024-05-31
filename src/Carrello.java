import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Carrello {
    private List<Prodotto> prodotti;

    public Carrello() {
        this.prodotti = new ArrayList<>();
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void aggiungiProdottoACarrello(Prodotto prodotto) {
        prodotti.add(prodotto);
    }

    public double calcolaTotaleCarrello() {
        double totale = 0;
        for (Prodotto prodotto : prodotti) {
            totale += prodotto.getPrezzoVendita();
        }
        return totale;
    }

    public void finalizzaAcquistoCarrello() {
        // Implementazione del metodo per finalizzare l'acquisto
    }

    public Prodotto trovaProdottoPerIdCarrello(UUID id) {
        for (Prodotto prodotto : prodotti) {
            if (prodotto.getId().equals(id)) {
                return prodotto;
            }
        }
        return null;
    }

    public void rimuoviProdottoDalCarrello(UUID id) {
        prodotti.removeIf(p -> p.getId().equals(id));
    }

    public void visualizzaCarrello() {
        for (Prodotto prodotto : prodotti) {
            System.out.println(prodotto);
        }
    }
}