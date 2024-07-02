import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Carrello {
    private final List<Prodotto> listaProdottiCarrello;
    private BigDecimal totale;

    public Carrello() {
        this.listaProdottiCarrello = new ArrayList<>();
        this.totale = BigDecimal.ZERO;
    }

    public List<Prodotto> getListaProdottiCarrello() {
        return listaProdottiCarrello;
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        this.listaProdottiCarrello.add(prodotto);
        this.totale = this.totale.add(prodotto.getPrezzoVendita());
    }

    public void rimuoviProdotto(Prodotto prodotto) {
        this.listaProdottiCarrello.remove(prodotto);
        this.totale = this.totale.subtract(prodotto.getPrezzoVendita());
    }

    public BigDecimal getTotale() {
        return totale;
    }

    public void stampaProdottiCarrello() {
        System.out.println("Lista prodotti Carrello: ");
        for (Prodotto prodotto : listaProdottiCarrello) {
            prodotto.stampaDettagliProdotto();
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