import java.util.List;

public class Main {

    public static void main(String[] args) {


        Magazzino magazzino = new Magazzino();

        // Aggiungi alcuni dispositivi al magazzino per testare la ricerca per prezzo di vendita
        magazzino.aggiungiDispositivi(3, TipoDispositivo.SMARTPHONE);
        magazzino.aggiungiDispositivi(2, TipoDispositivo.NOTEBOOK);
        magazzino.aggiungiDispositivi(4, TipoDispositivo.TABLET);

        // Esegui la ricerca per prezzo di vendita con un prezzo specifico
        double prezzoDaCercareVendita = 1000;
        List<Prodotti> dispositiviTrovatiVendita = GestoreMagazzino.ricercaPerPrezzoVendita(magazzino, prezzoDaCercareVendita);

        // Esegui la ricerca per prezzo di acquisto con un prezzo specifico
        double prezzoDaCercareAcquisto = 1200;
        List<Prodotti> dispositiviTrovatiAcquisto = magazzino.ricercaPerPrezzoAcquisto(prezzoDaCercareAcquisto);

        // Stampa i dispositivi trovati per prezzo di vendita
        System.out.println(!dispositiviTrovatiVendita.isEmpty()
                ? "Dispositivi trovati con prezzo di vendita di " + prezzoDaCercareVendita + " €:\n" + dispositiviTrovatiVendita
                : "Nessun dispositivo trovato con il prezzo di vendita di " + prezzoDaCercareVendita + " €.");

        // Stampa i dispositivi trovati per prezzo di acquisto
        System.out.println(!dispositiviTrovatiAcquisto.isEmpty()
                ? "Dispositivi trovati con prezzo di acquisto di " + prezzoDaCercareAcquisto + " €:\n" + dispositiviTrovatiAcquisto
                : "Nessun dispositivo trovato con il prezzo di acquisto di " + prezzoDaCercareAcquisto + " €.");
    }
}