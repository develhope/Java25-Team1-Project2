import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;

//TODO aggiungere quantità del prodotto in modo tale che non venga più eliminato il prodotto dal magazzino e dia un messaggiodi errore se è terminato


public class MenuPrincipale {
    private Magazzino magazzino;
    private Carrello carrello;
    private Scanner scanner;
    private Metodi metodi;

    public MenuPrincipale() {
        this.magazzino = new Magazzino();
        this.carrello = new Carrello(magazzino);
        this.scanner = new Scanner(System.in);
        this.metodi = new Metodi();
    }

    public void mostraMenu() {
        int scelta;

        do {
            System.out.println("\nCosa vuoi fare?");
            System.out.println("1. Accedi al magazzino");
            System.out.println("2. Accedi al carrello");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");

            scelta = scanner.nextInt();

            switch (scelta) {
                case 0:
                    System.out.println("Arrivederci!");
                    break;
                case 1:
                    menuMagazzino();
                    break;
                case 2:
                    menuCarrello();
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        } while (scelta != 0);
        scanner.close();
    }

    // Metodo per gestire il menu del magazzino
    public void menuMagazzino() {
        System.out.println("Magazzino:");
        boolean continua = true;
        while (continua) {
            System.out.println("\nMenu:");
            System.out.println("1. Aggiungi Prodotto");
            System.out.println("2. Cerca Prodotto");
            System.out.println("3. Accedi al carrello");
            System.out.println("4. Visualizza Inventario");
            System.out.println("0. Torna al menu principale");
            System.out.print("Scelta: ");

            //visualizzaInventario();
            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    aggiungiAlMagazzino();
                    break;
                case 2:
                   menuRicerca();
                    break;
                case 3:
                    menuCarrello();
                    break;
                case 4:
                    visualizzaInventario();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Scelta non valida!");
                    break;
            }
        }
    }

    // Metodo per gestire il menu del carrello
    public void menuCarrello() {
        System.out.println("Carrello:");
        boolean continua = true;
        while (continua) {
            System.out.println("\nMenu:");
            System.out.println("1. Aggiungi Prodotto al Carrello");
            System.out.println("2. Rimuovi Prodotto dal Carrello");
            System.out.println("3. Calcola Totale Carrello");
            System.out.println("4. Finalizza Acquisto");
            System.out.println("5. Accedi al Magazzino");
            System.out.println("6. Visualizza Carrello");
            System.out.println("0. Torna al menu principale");
            System.out.print("Scelta: ");

            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    aggiungiAlCarrello();
                    break;
                case 2:
                    rimuoviDalCarrello();
                    break;
                case 3:
                    calcolaTotaleCarrello();
                    break;
                case 4:
                    finalizzaAcquisto();
                    break;
                case 5:
                    menuMagazzino();
                    break;
                case 6:
                    visualizzaCarrello();
                    break;
                case 0:
                    continua = false;
                    mostraMenu();
                    break;
                default:
                    System.out.println("Scelta non valida!");
                    break;
            }
        }
    }

    // Metodo per gestire il menu ricerca del prodotto
    public void menuRicerca() {
        System.out.println("cerca:");
        boolean continua = true;
        ArrayList<Prodotti> prodottiTrovati = (ArrayList<Prodotti>) magazzino.getInventario();

        while (continua) {
            System.out.println("Scegli il tipo di ricerca:");
            System.out.println("1. Per tipo di dispositivo");
            System.out.println("2. Per range di prezzo");
            System.out.println("3. Per produttore");
            System.out.println("4. Per modello");
            System.out.println("5. Per prezzo di acquisto");
            System.out.println("6. Per prezzo di vendita");
            System.out.println("0. Torna al menu Magazzino");
            System.out.print("Scelta: ");
            int sceltaRicerca = scanner.nextInt();
            scanner.nextLine();

            switch (sceltaRicerca) {
                case 1:
                    System.out.print("Inserisci il tipo di dispositivo (SMARTPHONE, NOTEBOOK, TABLET): ");
                    String tipoDispositivoStr = scanner.next().toUpperCase();

                    try {
                        TipoDispositivo tipoDispositivo = TipoDispositivo.valueOf(tipoDispositivoStr);
                        prodottiTrovati = (ArrayList<Prodotti>) filtraProdotti(prodottiTrovati, prodotto -> prodotto.getTipoDispositivo().equals(tipoDispositivo));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Tipo di dispositivo non valido.");
                    }
                    break;
                case 2:
                    System.out.println("Inserisci prezzo minimo: ");
                    Double prezzoMinimo = scanner.nextDouble();
                    System.out.println("Inserisci prezzo massimo: ");
                    Double prezzoMassimo = scanner.nextDouble();
                    prodottiTrovati = (ArrayList<Prodotti>) filtraProdotti(prodottiTrovati, prodotto -> prodotto.getPrezzoVendita().compareTo(prezzoMinimo) >= 0 && prodotto.getPrezzoVendita().compareTo(prezzoMassimo) <= 0);
                    break;
                case 3:
                    System.out.print("Inserisci il produttore: ");
                    String produttore = scanner.next().toUpperCase();
                    prodottiTrovati = (ArrayList<Prodotti>) filtraProdotti(prodottiTrovati, prodotto -> prodotto.getProduttore().equalsIgnoreCase(produttore));
                    break;
                case 4:
                    System.out.print("Inserisci il modello: ");
                    String modello = scanner.next().toUpperCase();
                    prodottiTrovati = (ArrayList<Prodotti>) filtraProdotti(prodottiTrovati, prodotto -> prodotto.getModello().toUpperCase().contains(modello.toUpperCase()));
                    break;
                case 5:
                    try {
                        System.out.print("Inserisci il prezzo di acquisto: ");
                        String inputPrezzo = scanner.next();
                        inputPrezzo = inputPrezzo.replace(",", ".");

                        BigDecimal prezzoAcquistoInput = new BigDecimal(inputPrezzo);

                        prodottiTrovati = (ArrayList<Prodotti>) filtraProdotti(prodottiTrovati, prodotto -> false);
                    } catch (NumberFormatException e) {
                        System.out.println("Input non valido. Assicurati di inserire un numero valido.");
                    }
                    break;
                case 6:
                    try {
                        System.out.print("Inserisci il prezzo di vendita: ");
                        String inputPrezzo = scanner.next();

                        inputPrezzo = inputPrezzo.replace(",", ".");

                        BigDecimal prezzoVenditaInput = new BigDecimal(inputPrezzo);

                        prodottiTrovati = (ArrayList<Prodotti>) filtraProdotti(prodottiTrovati, prodotto -> false);
                    } catch (NumberFormatException e) {
                        System.out.println("Input non valido. Assicurati di inserire un numero valido.");
                    }
                    break;
                case 0:
                    continua = false;
                    menuMagazzino();
                    break;
                default:
                    System.out.println("Scelta non valida!");
                    break;
            }
            // Stampa i risultati di ricerca filtrati (se non vuoti)
            if (!prodottiTrovati.isEmpty()) {
                System.out.println("\nRisultati di ricerca:");
                for (Prodotti prodotto : prodottiTrovati) {
                    System.out.println(prodotto); // Stampa le informazioni di ciascun prodotto
                }
            } else {
                System.out.println("Nessun prodotto trovato con i criteri specificati.");
            }
        }
    }

    private void aggiungiAlMagazzino() {
        // Richiedi all'utente i dettagli del nuovo prodotto
        TipoDispositivo tipoDispositivo = null;
        while (tipoDispositivo == null) {
            try {
                System.out.println("Inserisci il tipo di dispositivo (smartphone, tablet o notebook): ");
                tipoDispositivo = TipoDispositivo.valueOf(scanner.next().toUpperCase());

            } catch (IllegalArgumentException e){
                System.out.println("Tipo di dispositivo non valido. Inserisci nuovamente: ");
            }

        }

        System.out.println("Inserisci il produttore: ");
        String produttore = scanner.next();

        System.out.println("Inserisci il modello: ");
        String modello = scanner.next();

        System.out.println("Inserisci una descrizione (opzionale): ");
        String descrizione = scanner.nextLine();

        System.out.println("Inserisci la dimensione del display: ");
        Double dimensioneDisplay = scanner.nextDouble();

        TipoMemoriaArchiviazione tipoMemoria = null;
        while (tipoMemoria == null) {
            try {
                System.out.println("Inserisci il tipo di memoria (HDD, SSD, NVMe): ");
                tipoMemoria = TipoMemoriaArchiviazione.valueOf(scanner.next().toUpperCase());
            } catch (IllegalArgumentException e){
                System.out.println("Tipo di memoria non valido. Inserisci nuovamente: ");
            }
        }

        SpazioDiArchiviazione dimensioneArchiviazione = null;
        while (dimensioneArchiviazione == null) {
            System.out.println("Inserisci la dimensione dello spazio di archiviazione: ");
            String input = scanner.next();
            try {
                Integer valore = Integer.parseInt(input);
                dimensioneArchiviazione = SpazioDiArchiviazione.fromInt(valore);
            } catch (NumberFormatException e) {
                System.out.println("Input non valido. Inserisci un numero.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Inserisci un numero valido.");
            }
        }

        System.out.println("Inserisci il prezzo di acquisto:");
        Double prezzoAcquisto = scanner.nextDouble();
        System.out.println("Inserisci il prezzo di vendita:");
        Double prezzoVendita = scanner.nextDouble();

        // Genera un ID casuale per il nuovo prodotto
        UUID id = UUID.randomUUID();

        // Aggiungi il nuovo prodotto all'inventario
        Prodotti nuovoProdotto = new Prodotti(
                tipoDispositivo,
                produttore,
                modello,
                descrizione,
                dimensioneDisplay,
                tipoMemoria,
                dimensioneArchiviazione,
                prezzoAcquisto,
                prezzoVendita,
                id
        );
        magazzino.aggiungiProdotto(nuovoProdotto);
        System.out.println("Prodotto aggiunto all'inventario.");
    }

    // Metodo per stampare tutti i dispositivi presenti nel magazzino
    private void visualizzaInventario() {
        System.out.println("Lista dell'inventario:");

        List<Prodotti> dispositivi = magazzino.getInventario();
        if (dispositivi.isEmpty()) {
            System.out.println("Nessun dispositivo presente in magazzino.");
        } else {
            System.out.println("Dispositivi in magazzino:");
            dispositivi.forEach(System.out::println);
        }
    }

    // Metodo per stampare tutti i dispositivi presenti nel carrello
    private void visualizzaCarrello() {
        System.out.println("Lista del carrello:");
        for (Prodotti prodotto : carrello.getProdotti()) {
            System.out.println(prodotto);
        }
    }

    private void aggiungiAlCarrello() {
            // Richiedi all'utente l'ID del prodotto da aggiungere al carrello
            System.out.println("Inserisci l'ID del prodotto da aggiungere al carrello:");
            String idString = scanner.next();
            try {
                UUID id = UUID.fromString(idString);
                // Trova il prodotto nell'inventario e aggiungilo al carrello
                Prodotti prodotto = magazzino.trovaProdottoPerId(id);
                if (prodotto != null) {
                    carrello.aggiungiProdotto(prodotto);
                    System.out.println("Prodotto aggiunto al carrello.");
                } else {
                    System.out.println("Prodotto non trovato nell'inventario.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("ID non valido.");
            }
        }

    private void rimuoviDalCarrello() {
        // Richiedi all'utente l'ID del prodotto da rimuovere dal carrello
        System.out.println("Inserisci l'ID del prodotto da rimuovere dal carrello:");
        String idString = scanner.next();
        try {
            UUID id = UUID.fromString(idString);
            // Rimuovi il prodotto dal carrello
            if (carrello.rimuoviProdotto(id)) {
                System.out.println("Prodotto rimosso dal carrello.");
            } else {
                System.out.println("Prodotto non trovato nel carrello.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("ID non valido.");
        }
    }

    private void calcolaTotaleCarrello() {
        System.out.println("Totale carrello: " + carrello.calcolaTotale() + " €");
    }

    private void finalizzaAcquisto() {
        carrello.finalizzaAcquisto();
    }

    // Metodo per filtrare i prodotti
    private List<Prodotti> filtraProdotti(List<Prodotti> prodotti, Predicate<Prodotti> predicate) {
        List<Prodotti> prodottiFiltrati = new ArrayList<>();
        for (Prodotti prodotto : prodotti) {
            if (predicate.test(prodotto)) {
                prodottiFiltrati.add(prodotto);
            }
        }
        return prodottiFiltrati;
    }
}
