import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Metodi {

    private Magazzino articoli;
    private Scanner scanner = new Scanner(System.in);

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
            if (dispositivo.getPrezzoAcquisto() == prezzoDaCercare.doubleValue()) {
                return dispositivo;
            }
        }
        return null;
    }

  // Metodo per fare la ricerca per prezzo di vendita
  public Prodotti ricercaPerPrezzoVendita(Magazzino magazzino, BigDecimal prezzoDaCercare) {
      BigDecimal prezzoInserito = null;
      boolean inputValido = false;

      while (!inputValido) {
          try {
              System.out.println("Inserisci il prezzo di vendita: ");
              String inputPrezzo = scanner.next().replace(",", ".");
              prezzoInserito = new BigDecimal(inputPrezzo);
              inputValido = true;
          } catch (NumberFormatException e) {
              System.out.println("Input non valido. Assicurati di inserire un numero valido.");
          }
      }
      for (Prodotti dispositivo : magazzino.getInventario()) {
          if (dispositivo.getPrezzoVendita() == prezzoDaCercare.doubleValue()) {
              return dispositivo;
          }
      }
      return null;
  }


  // Cerca e stampa i dispositivi presenti in un determinato Range di prezzo
  public List<Prodotti> cercaPerRangePrezzo(Scanner scanner, double prezzoMinimo, double prezzoMassimo) {
      List<Prodotti> result = new ArrayList<>();
      boolean trovati = false;

      try {
          // Controllo range valido
          if (prezzoMassimo < prezzoMinimo) {
              throw new IllegalArgumentException("Il prezzo massimo non può essere inferiore al prezzo minimo.");
          }

          // Ricerca prodotti nel range
          for (Prodotti dispositivo : articoli.getInventario()) {
              double prezzoVenditaDispositivo = dispositivo.getPrezzoVendita();
              if (prezzoVenditaDispositivo >= prezzoMinimo &&
                      prezzoVenditaDispositivo <= prezzoMassimo) {
                  result.add(dispositivo);
                  trovati = true; // Aggiorna flag se trovato un prodotto
              }
          }

          // Gestione lista vuota (solo se non siamo nel case 2)
          if (!trovati) {
              return result;
          }
      } catch (NumberFormatException e) {
          System.out.println("Formato prezzo non valido. Inserisci un numero decimale.");
      } catch (IllegalArgumentException e) {
          return result;
      }

      return result;
  }
}