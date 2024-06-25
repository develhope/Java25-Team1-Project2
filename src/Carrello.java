import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Carrello {
    private List<Prodotto> listaProdottiCarrello;
    private BigDecimal totale;

    public Carrello() {
        this.listaProdottiCarrello = new ArrayList<>();
        this.totale = BigDecimal.ZERO;
    }

    public List<Prodotto> getListaProdottiCarrello() {
        return listaProdottiCarrello;
    }

    private void aggiungiProdotto(Prodotto prodotto) {
        this.listaProdottiCarrello.add(prodotto);
        this.totale = this.totale.add(prodotto.getPrezzoVendita());
    }

    private void rimuoviProdotto(Prodotto prodotto) {
        listaProdottiCarrello.remove(prodotto);
        this.totale = this.totale.subtract(prodotto.getPrezzoVendita());
    }

    // TODO correggere il metodo in modo che stampi l'oggetto e non l'hashcode
    public void stampaProdottiCarrello() {
        System.out.println("Lista prodotti Carrello: ");
        for (Prodotto prodotto : listaProdottiCarrello) {
            prodotto.stampaDettagliProdotto();
        }
    }

    public boolean effettuaPagamento() {
        if (listaProdottiCarrello.isEmpty()) {
            System.out.println("Il carrello è vuoto. Impossibile effettuare il pagamento.");
            return false;
        }
        BigDecimal totaleCarrello = totale.setScale(2, RoundingMode.HALF_UP);
        System.out.println("Il totale da pagare è: " + totaleCarrello + " €");
        confermaAcquisto();
        return true;
    }

    public void confermaAcquisto() {
        listaProdottiCarrello.clear();
        System.out.println("Acquisto confermato. Grazie per il tuo acquisto!");
        System.out.println("Il carrello è stato svuotato.");
    }

    public void getAggiungiProdottoCarrello(Prodotto prodotto) {
        aggiungiProdotto(prodotto);
    }

    public void getRimuoviProdottoCarrello(Prodotto prodotto) {
        rimuoviProdotto(prodotto);
    }
}