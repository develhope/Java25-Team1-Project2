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

        return new ArrayList<>(dispositiviRicercati);
    }

    // Metodo per fare la ricerca per tipo di dispositivo
    public static void cercaDispositiviPerTipo(Magazzino magazzino) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il tipo di dispositivo (SMARTPHONE, NOTEBOOK, TABLET): ");
        String tipoDispositivoStr = scanner.nextLine().trim().toUpperCase();

        TipoDispositivo tipoDispositivo = null;
        try {
            tipoDispositivo = TipoDispositivo.valueOf(tipoDispositivoStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo di dispositivo non valido.");
            return;
        }

        TipoDispositivo finalTipoDispositivo = tipoDispositivo;
        ArrayList<Prodotto> dispositiviTrovati = cercaDispositivi(magazzino,
                dispositivo -> dispositivo.getTipoDispositivo() == finalTipoDispositivo,
                "di tipo " + tipoDispositivo);

        if (dispositiviTrovati.isEmpty()) {
            System.out.println("Dispositivo non trovato.");
            System.out.println("Dispositivi già presenti nel magazzino:");
            for (Prodotto dispositivo : magazzino.getInventario()) {
                System.out.println(dispositivo);
            }
        } else {
            for (Prodotto dispositivo : dispositiviTrovati) {
                System.out.println(dispositivo);
            }
        }
    }

    // Metodo per fare la ricerca per produttore
    public static void cercaDispositiviPerProduttore(Magazzino magazzino) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il produttore: ");
        String produttore = scanner.nextLine().trim().toUpperCase();

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
        } else {
            for (Prodotto dispositivo : dispositiviTrovati) {
                System.out.println(dispositivo);
            }
        }
    }

    // Metodo per fare la ricerca per modello
    public static void cercaDispositiviPerModello(Magazzino magazzino) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il modello: ");
        String modello = scanner.nextLine().trim().toLowerCase();

        String modelloLowerCase = modello.toLowerCase();
        ArrayList<Prodotto> dispositiviTrovati = cercaDispositivi(magazzino,
                dispositivo -> dispositivo.getModello().toLowerCase().contains(modelloLowerCase),
                "con il modello " + modello);

        if (dispositiviTrovati.isEmpty()) {
            System.out.println("Modello non trovato.");
            System.out.println("Modelli già presenti nel magazzino:");
            for (Prodotto dispositivo : magazzino.getInventario()) {
                System.out.println(dispositivo.getModello());
            }
        } else {
            for (Prodotto dispositivo : dispositiviTrovati) {
                System.out.println(dispositivo);
            }
        }
    }

    // Metodo per fare la ricerca per prezzo di acquisto
    public void ricercaPerPrezzoAcquisto(Magazzino magazzino) {
        Scanner scanner = new Scanner(System.in);
        boolean inputValido = false;
        boolean risultatiTrovati = false;

        while (!inputValido || !risultatiTrovati) {
            System.out.print("Inserisci il prezzo di acquisto: ");
            try {
                String inputPrezzo = scanner.next();
                inputPrezzo = inputPrezzo.replace(",", ".");

                BigDecimal prezzoAcquisto = new BigDecimal(inputPrezzo);

                double prezzoAcquistoDouble = prezzoAcquisto.doubleValue();
                double rangeMinimo = prezzoAcquistoDouble - 150;
                double rangeMassimo = prezzoAcquistoDouble + 150;

                ArrayList<Prodotto> dispositiviTrovati = new ArrayList<>();
                for (Prodotto dispositivo : magazzino.getInventario()) {
                    if (dispositivo.getPrezzoAcquisto() >= rangeMinimo && dispositivo.getPrezzoAcquisto() <= rangeMassimo) {
                        dispositiviTrovati.add(dispositivo);
                    }
                }

                if (dispositiviTrovati.isEmpty()) {
                    System.out.println("Nessun dispositivo trovato con un prezzo di acquisto entro " + rangeMinimo + " e " + rangeMassimo + " €.");
                    inputValido = true; // Il prezzo è valido, ma non ci sono risultati
                    risultatiTrovati = false; // Nessun risultato trovato
                } else {
                    for (Prodotto dispositivo : dispositiviTrovati) {
                        System.out.println(dispositivo);
                    }
                    inputValido = true;
                    risultatiTrovati = true;
                }
            } catch (NumberFormatException | ArithmeticException e) {
                System.out.println("Input non valido. Assicurati di inserire un numero valido.");
                inputValido = false; // Imposta come falso per richiedere nuovamente l'input
            }
        }
    }

    // Metodo per fare la ricerca per prezzo di vendita
    public void ricercaPerPrezzoVendita(Magazzino magazzino) {
        Scanner scanner = new Scanner(System.in);
        boolean inputValido = false;
        boolean risultatiTrovati = false;

        while (!inputValido || !risultatiTrovati) {
            System.out.print("Inserisci il prezzo di vendita: ");
            try {
                String inputPrezzo = scanner.next();
                inputPrezzo = inputPrezzo.replace(",", ".");

                BigDecimal prezzoVendita = new BigDecimal(inputPrezzo);

                double prezzoVenditaDouble = prezzoVendita.doubleValue();
                double rangeMinimo = prezzoVenditaDouble - 150;
                double rangeMassimo = prezzoVenditaDouble + 150;

                ArrayList<Prodotto> dispositiviTrovati = new ArrayList<>();
                for (Prodotto dispositivo : magazzino.getInventario()) {
                    if (dispositivo.getPrezzoVendita() >= rangeMinimo && dispositivo.getPrezzoVendita() <= rangeMassimo) {
                        dispositiviTrovati.add(dispositivo);
                    }
                }

                if (dispositiviTrovati.isEmpty()) {
                    System.out.println("Nessun dispositivo trovato con un prezzo di vendita entro " + rangeMinimo + " e " + rangeMassimo + " €.");
                    inputValido = true; // Il prezzo è valido, ma non ci sono risultati
                    risultatiTrovati = false; // Nessun risultato trovato
                } else {
                    for (Prodotto dispositivo : dispositiviTrovati) {
                        System.out.println(dispositivo);
                    }
                    inputValido = true;
                    risultatiTrovati = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input non valido. Assicurati di inserire un numero valido.");
                inputValido = false; // Imposta come falso per richiedere nuovamente l'input
            }
        }
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