import java.util.ArrayList;
import java.util.List;

public class Carrello {
    private List<Prodotto> listaProdottiCarrello;
    public Magazzino magazzino = new Magazzino();

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
        double totaleAcquisto = calcolaTotaleCarrello();
        // Effettuare il pagamento
        boolean pagamentoEffettuato = effettuaPagamento(totaleAcquisto);

        if (pagamentoEffettuato) {
            confermaAcquisto();
            // Svuota il carrello dopo l'acquisto
            listaProdottiCarrello.clear();
        } else {
            System.out.println("Pagamento non riuscito. Riprovare.");
        }
    }
    private boolean effettuaPagamento(double totaleAcquisto) {
        // fingo che sto vendendo effettivamente un prodotto.
        boolean pagamentoRiuscito = simulaPagamento();
        if (!pagamentoRiuscito) {
            System.out.println("Pagamento non riuscito. Riprovare.");
        }
        return pagamentoRiuscito;
    }

    private boolean simulaPagamento() {
        return true;
    }


    public void confermaAcquisto(){
        //per refreshare la lista carrello in fase di acquisto.
        listaProdottiCarrello.clear();
        System.out.println("Acquisto confermato. Grazie per il tuo acquisto!");

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