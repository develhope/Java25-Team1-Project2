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
    public static ArrayList<Prodotti> cercaDispositivi(Magazzino magazzino, Predicate<Prodotti> condition, String message) {
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
    public static ArrayList<Prodotti> cercaDispositiviPerTipo(Magazzino magazzino, TipoDispositivo tipoDispositivo) {
        ArrayList<Prodotti> dispositiviTrovati = cercaDispositivi(magazzino, dispositivo -> dispositivo.getTipoDispositivo() == tipoDispositivo,
                "di tipo " + tipoDispositivo);

        if (dispositiviTrovati.isEmpty()) {
            System.out.println("Dispositivo non trovato.");
            System.out.println("Dispositivi già presenti nel magazzino:");
            for (Prodotti dispositivo : magazzino.getInventario()) {
                System.out.println(dispositivo);
            }
        }
        return dispositiviTrovati;
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
            System.out.println("Produttori già presenti nel magazzino:");
            for (Prodotti dispositivo : magazzino.getInventario()) {
                System.out.println(dispositivo.getProduttore());
            }
        }
        return dispositiviTrovati;
    }

    // Metodo per fare la ricerca per modello
    public static ArrayList<Prodotti> cercaDispositiviPerModello(Magazzino magazzino, String modello) {
        ArrayList<Prodotti> dispositiviTrovati = cercaDispositivi(magazzino, dispositivo -> dispositivo.getModello().toLowerCase().equalsIgnoreCase(modello),
                "con il modello " + modello);

        if (dispositiviTrovati.isEmpty()) {
            System.out.println("Modello non trovato.");
            System.out.println("Modelli già presenti nel magazzino:");
            for (Prodotti dispositivo : magazzino.getInventario()) {
                System.out.println(dispositivo.getModello());
            }
        }
        return dispositiviTrovati;
    }

    // Metodo per fare la ricerca per prezzo di acquisto
    public Prodotti ricercaPerPrezzoAcquisto(Magazzino magazzino, BigDecimal prezzoDaCercare) {
        for (Prodotti dispositivo : magazzino.getInventario()) {
            if (dispositivo.getPrezzoAcquisto().doubleValue() == prezzoDaCercare.doubleValue()) {
                return dispositivo;
            }
        }
        return null;
    }

  // Metodo per fare la ricerca per prezzo di vendita
  public Prodotti ricercaPerPrezzoVendita(Magazzino magazzino, BigDecimal prezzoDaCercare) {
      for (Prodotti dispositivo : magazzino.getInventario()) {
          if (dispositivo.getPrezzoVendita().doubleValue() == prezzoDaCercare.doubleValue()) {
              return dispositivo;
          }
      }
      return null;
  }


  // Cerca e stampa i dispositivi presenti in un determinato Range di prezzo
  public List<Prodotti> cercaPerRangePrezzo(Double prezzoMinimo, Double prezzoMassimo) {
       List<Prodotti> result = new ArrayList<>();

       boolean rangeValido = false;
       while (!rangeValido) {
            rangeValido = true; // Assume the range is valid initially
            for (Prodotti dispositivo : articoli.getInventario()) {

                if (dispositivo.getPrezzoVendita() >= prezzoMinimo &&
                        dispositivo.getPrezzoVendita() <= prezzoMassimo) {
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
                prezzoMinimo = scanner.nextDouble();
                System.out.println("Inserisci nuovamente il prezzo massimo: ");
                prezzoMassimo = scanner.nextDouble();
                scanner.close(); // Chiudere lo scanner dopo l'uso
            }
       }
       return result;
    }
}