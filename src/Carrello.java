import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carrello {
    private final Map<Prodotto, Integer> listaProdottiCarrello;
    private BigDecimal totale;
    private Integer quantita;

    public Carrello() {
        this.listaProdottiCarrello = new HashMap<>();
        this.totale = BigDecimal.ZERO;
    }

    public Map<Prodotto, Integer> getListaProdottiCarrello() {
        return listaProdottiCarrello;
    }
    public BigDecimal getTotale() {
        return totale;
    }


    public void aggiungiProdotto(Prodotto prodotto, Integer quantita) {
        listaProdottiCarrello.merge(prodotto, quantita, Integer::sum);
        this.totale = this.totale.add(prodotto.getPrezzoVendita().multiply(BigDecimal.valueOf(quantita)));
    }

    public void rimuoviProdotto(Prodotto prodotto, Integer quantita) {
        if (listaProdottiCarrello.containsKey(prodotto)) {
            int nuovaQuantita = listaProdottiCarrello.get(prodotto) - quantita;
            if (nuovaQuantita > 0) {
                listaProdottiCarrello.put(prodotto, nuovaQuantita);
            } else {
                listaProdottiCarrello.remove(prodotto);
            }
            this.totale = this.totale.subtract(prodotto.getPrezzoVendita().multiply(BigDecimal.valueOf(quantita)));
        }
    }
    public void svuotaCarrello() {
        listaProdottiCarrello.clear();
    }

    public void stampaProdottiCarrello() {
        System.out.println("Lista prodotti Carrello: ");
        for (Map.Entry<Prodotto, Integer> entry : listaProdottiCarrello.entrySet()) {
            Prodotto prodotto = entry.getKey();
            int quantita = entry.getValue();
            System.out.println(prodotto.getNomeProdotto() + " Prezzo: " + prodotto.getPrezzoVendita() + " € Quantità: " + quantita);
        }
    }

    public void effettuaPagamento() {
        if (listaProdottiCarrello.isEmpty()) {
            System.out.println("Il carrello è vuoto. Impossibile effettuare il pagamento.");
            return;
        }

        BigDecimal totaleCarrello = totale.setScale(2, RoundingMode.HALF_UP);
        System.out.println("Il totale da pagare è: " + totaleCarrello + " €");
        confermaAcquisto();

    }

    public void confermaAcquisto() {
        listaProdottiCarrello.clear();
        System.out.println("Acquisto confermato. Grazie per il tuo acquisto!");
        System.out.println("Il carrello è stato svuotato.");
        this.totale = BigDecimal.ZERO;
    }
}