import java.util.ArrayList;
import java.util.List;

public class Metodo5 {

    //TODO da inserire in magazzino , il metodo funziona correttamente.
    public static void main(String[] args) {
        public List<Prodotti> ricercaPerPrezzoVendita(double prezzoDaCercare) {
            List<Prodotti> dispositiviTrovati = new ArrayList<>();
            // Scorrere tutti i prodotti nel magazzino
            for (Prodotti prodotto : prodottiInMagazzino) {
                // Verificare se il prezzo di vendita corrente corrisponde al prezzo cercato
                if (prodotto.leggiPrezzoVendita() == prezzoDaCercare) {
                    dispositiviTrovati.add(prodotto);
                }
            }

            // Verificare se sono stati trovati dispositivi corrispondenti
            if (dispositiviTrovati.isEmpty()) {
                System.out.println("Nessun dispositivo trovato con il prezzo di vendita di " + prezzoDaCercare + " €.");
            }

            return dispositiviTrovati;
        }

    }
}
