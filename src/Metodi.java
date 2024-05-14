import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Metodi {

    private Magazzino articoli;

    public Metodi(){
        articoli = new Magazzino();

    }

    // Metodo generico per la ricerca di dispositivi
    public ArrayList<Prodotti> cercaDispositivi(Magazzino magazzino, Predicate<Prodotti> condition, String message) {
        List<Prodotti> dispositiviRicercati = magazzino.getInventario().stream()
                .filter(condition)
                .toList();

        if (dispositiviRicercati.isEmpty()) {
            System.out.println("Nessun dispositivo " + message + " trovato.");
        } else {
            System.out.println("Dispositivi " + message + " trovati:");
            dispositiviRicercati.forEach(System.out::println);
        }

        return new ArrayList<>(dispositiviRicercati);
    }

    // Metodo per fare la ricerca per tipo di dispositivo
    public ArrayList<Prodotti> cercaDispositiviPerTipo(Magazzino magazzino, TipoDispositivo tipoDispositivo) {
        return cercaDispositivi(magazzino, dispositivo -> dispositivo.getTipoDispositivo() == tipoDispositivo,
                "di tipo " + tipoDispositivo);
    }

    // Metodo per fare la ricerca per produttore
    public static ArrayList<Prodotti> cercaDispositiviPerProduttore(Magazzino magazzino, String produttore) {
        ArrayList<Prodotti> dispositiviTrovati = new ArrayList<>();

        for (Prodotti dispositivo : magazzino.getInventario()) {
            if (dispositivo.getProduttore().equalsIgnoreCase(produttore)) {
                dispositiviTrovati.add(dispositivo);
            }
        }

        if (dispositiviTrovati.isEmpty()) {
            System.out.println("Produttore non trovato.");

            // Visualizza i produttori già presenti nel magazzino
            System.out.println("Produttori già presenti nel magazzino:");
            for (Prodotti dispositivo : magazzino.getInventario()) {
                System.out.println(dispositivo.getProduttore());
            }
        }
        return dispositiviTrovati;
    }

    // Metodo per fare la ricerca per modello
    public ArrayList<Prodotti> cercaDispositiviPerModello(Magazzino magazzino, String modello) {
        return cercaDispositivi(magazzino, dispositivo -> dispositivo.getModello().toLowerCase().equalsIgnoreCase(modello),
                "con il modello " + modello);
    }
 
  // Metodo per fare la ricerca per prezzo di vendita
  public ArrayList<Prodotti> ricercaPerPrezzoVendita(Magazzino magazzino, BigDecimal prezzoDaCercare) {
      return cercaDispositivi(magazzino, dispositivo -> dispositivo.getPrezzoVendita().doubleValue() == prezzoDaCercare.doubleValue(),
              "con prezzo di vendita " + prezzoDaCercare + " €");
  }
  
    // Metodo per fare la ricerca per prezzo di acquisto
  public ArrayList<Prodotti> ricercaPerPrezzoAcquisto(Magazzino magazzino, BigDecimal prezzoDaCercare) {
      return cercaDispositivi(magazzino, dispositivo -> dispositivo.getPrezzoAcquisto().doubleValue() == prezzoDaCercare.doubleValue(),
              "con prezzo di acquisto " + prezzoDaCercare + " €");
  }

    // Cerca e stampa i dispositivi presenti in un determinato Range di prezzo
    public List<Prodotti> cercaPerRangePrezzo(BigDecimal prezzoMinimo, BigDecimal prezzoMassimo) {
        List<Prodotti> result = new ArrayList<>();

        boolean rangeValido = false;
        while (!rangeValido) {
            rangeValido = true; // Assume the range is valid initially
            for (Prodotti dispositivo : articoli.getInventario()) {
                // Cast esplicito di BigDecimal in double per il confronto
                if (dispositivo.getPrezzoVendita().doubleValue() >= prezzoMinimo.doubleValue() &&
                        dispositivo.getPrezzoVendita().doubleValue() <= prezzoMassimo.doubleValue()) {
                    result.add(dispositivo);
                    System.out.println(dispositivo);
                }
            }
            if (result.isEmpty()) {
                rangeValido = false;
                System.out.println("Nessun dispositivo trovato nel range di prezzo specificato.");
                // Richiedere nuovi parametri
                Scanner scanner = new Scanner(System.in);
                System.out.println("Inserisci nuovamente il prezzo minimo: ");
                prezzoMinimo = scanner.nextBigDecimal();
                System.out.println("Inserisci nuovamente il prezzo massimo: ");
                prezzoMassimo = scanner.nextBigDecimal();
                scanner.close(); // Chiudere lo scanner dopo l'uso
            }
        }
        return result;
    }
}