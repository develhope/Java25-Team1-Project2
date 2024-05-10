import java.util.ArrayList;
import java.util.List;

public class Metodo6 {
    //TODO metodo ricerca per prezzo di acquisto , da inserire in magazzino.
    public static void main(String[] args) {
        public List<Prodotti> ricercaPerPrezzoAcquisto(double prezzoDaCercare) {
            List<Prodotti> dispositiviTrovati = new ArrayList<>();

            // Scorrere tutti i prodotti nel magazzino
            for (Prodotti prodotto : prodottiInMagazzino) {
                // Verificare se il prezzo di acquisto corrente corrisponde al prezzo cercato
                if (prodotto.leggiPrezzoAcquisto() == prezzoDaCercare) {
                    dispositiviTrovati.add(prodotto);
                }
            }

            // Verificare se sono stati trovati dispositivi corrispondenti
            if (dispositiviTrovati.isEmpty()) {
                System.out.println("Nessun dispositivo trovato con il prezzo di acquisto di " + prezzoDaCercare + " €.");
            }

            return dispositiviTrovati;
        }
    }
    }
}
