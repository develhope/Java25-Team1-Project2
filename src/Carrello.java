import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// TODO aggiungi nome, quantità e con add di prodotto va aggiornata quantità e prezzo

public class Carrello {
    private List<Prodotto> listaProdottiCarrello;

    public Carrello() {
        this.listaProdottiCarrello = new ArrayList<>();
    }

    public List<Prodotto> getListaProdottiCarrello() {
        return listaProdottiCarrello;
    }

    public void aggiungiProdottoACarrello(Prodotto prodotto) {
        listaProdottiCarrello.add(prodotto);
    }

    public double calcolaTotaleCarrello() {
        double totale = 0;
        for (Prodotto prodotto : listaProdottiCarrello) {
            totale += prodotto.getPrezzoVendita();
        }
        return totale;
    }

    public void finalizzaAcquistoCarrello() {
        // Implementazione del metodo per finalizzare l'acquisto
    }

    public void  trovaProdottoPerIdCarrello(UUID id) {
        for (Prodotto prodotto : listaProdottiCarrello) {
            if (prodotto.getId().equals(id)) {
                System.out.println(prodotto);
            }
        }
        System.out.println(" nessun prodotto trovato.");

    }

    public void rimuoviProdottoDalCarrello(UUID id) {
        listaProdottiCarrello.removeIf(p -> p.getId().equals(id));
    }

    public void visualizzaCarrello() {
        for (Prodotto prodotto : listaProdottiCarrello) {
            System.out.println(prodotto);
        }
    }
}