import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Metodi {

    private Magazzino articoli;
    private Scanner scanner = new Scanner(System.in);
    private Carrello prodotti;

    public Metodi() {
        this.articoli = new Magazzino();
        this.prodotti = new Carrello(articoli);

    }

    // Metodo generico per la ricerca di dispositivi
    public static ArrayList<Prodotto> cercaDispositivi(Magazzino magazzino, Predicate<Prodotto> condition, String message) {
        List<Prodotto> dispositiviRicercati = magazzino.getInventario().stream()
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
    public static ArrayList<Prodotto> cercaDispositiviPerTipo(Magazzino magazzino, TipoDispositivo tipoDispositivo) {
        ArrayList<Prodotto> dispositiviTrovati = cercaDispositivi(magazzino, dispositivo -> dispositivo.getTipoDispositivo() == tipoDispositivo,
                "di tipo " + tipoDispositivo);

        if (dispositiviTrovati.isEmpty()) {
            System.out.println("Dispositivo non trovato.");
            System.out.println("Dispositivi già presenti nel magazzino:");
            for (Prodotto dispositivo : magazzino.getInventario()) {
                System.out.println(dispositivo);
            }
        }
        return dispositiviTrovati;
    }

    // Metodo per fare la ricerca per produttore
    public static ArrayList<Prodotto> cercaDispositiviPerProduttore(Magazzino magazzino, String produttore) {
        ArrayList<Prodotto> dispositiviTrovati = new ArrayList<>();

        for (Prodotto dispositivo : magazzino.getInventario()) {
            if (dispositivo.getProduttore().equalsIgnoreCase(produttore)) {
                dispositiviTrovati.add(dispositivo);
            }
        }

        if (dispositiviTrovati.isEmpty()) {
            System.out.println("Produttore non trovato.");
            System.out.println("Produttori già presenti nel magazzino:");
            for (Prodotto dispositivo : magazzino.getInventario()) {
                System.out.println(dispositivo.getProduttore());
            }
        }
        return dispositiviTrovati;
    }

    // Metodo per fare la ricerca per modello
    public static ArrayList<Prodotto> cercaDispositiviPerModello(Magazzino magazzino, String modello) {
        ArrayList<Prodotto> dispositiviTrovati = cercaDispositivi(magazzino, dispositivo -> dispositivo.getModello().toLowerCase().equalsIgnoreCase(modello),
                "con il modello " + modello);

        if (dispositiviTrovati.isEmpty()) {
            System.out.println("Modello non trovato.");
            System.out.println("Modelli già presenti nel magazzino:");
            for (Prodotto dispositivo : magazzino.getInventario()) {
                System.out.println(dispositivo.getModello());
            }
        }
        return dispositiviTrovati;
    }

    // Metodo per fare la ricerca per prezzo di acquisto
    public Prodotto ricercaPerPrezzoAcquisto(Magazzino magazzino, BigDecimal prezzoDaCercare) {
        for (Prodotto dispositivo : magazzino.getInventario()) {
            if (dispositivo.getPrezzoAcquisto() == prezzoDaCercare.doubleValue()) {
                return dispositivo;
            }
        }
        return null;
    }

    // Metodo per fare la ricerca per prezzo di vendita
    public Prodotto ricercaPerPrezzoVendita(Magazzino magazzino, BigDecimal prezzoDaCercare) {
        for (Prodotto dispositivo : magazzino.getInventario()) {
            if (dispositivo.getPrezzoVendita() == prezzoDaCercare.doubleValue()) {
                return dispositivo;
            }
        }
        return null;
    }

    // Metodo che cerca e stampa i dispositivi presenti in un determinato Range di prezzo
    public List<Prodotto> cercaPerRangePrezzo() {
        List<Prodotto> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean rangeValido = false;
        Double prezzoMinimo = null;
        Double prezzoMassimo = null;

        while (!rangeValido) {
            boolean inputValido = false;
            while (!inputValido) {
                try {
                    System.out.println("Inserisci il prezzo minimo: ");
                    prezzoMinimo = scanner.nextDouble();
                    System.out.println("Inserisci il prezzo massimo: ");
                    prezzoMassimo = scanner.nextDouble();
                    inputValido = true;
                } catch (InputMismatchException e) {
                    System.out.println("Inserimento non valido. Per favore inserisci un numero.");
                    scanner.next(); // Pulisci l'input non valido
                }
            }

            rangeValido = true;
            result.clear(); // Pulisce i risultati della ricerca precedente
            for (Prodotto dispositivo : articoli.getInventario()) {
                if (dispositivo.getPrezzoVendita() >= prezzoMinimo &&
                        dispositivo.getPrezzoVendita() <= prezzoMassimo) {
                    result.add(dispositivo);
                    System.out.println(dispositivo);
                }
            }

            if (result.isEmpty()) {
                rangeValido = false;
                System.out.println("Nessun dispositivo trovato nel range di prezzo specificato.");
            }
        }
        return result;
    }
}