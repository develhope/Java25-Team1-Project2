import java.math.BigDecimal;
import java.util.*;

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
            System.out.println("7. Calcola Spesa Media");
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
                case 7:
                    BigDecimal mediaSpesaTotale = carrello.calcolaSpesaMedia();
                    System.out.println("La spesa media dell'aquisto è: " + mediaSpesaTotale + "€");
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

    // Metodo per gestire il menu del carrello
    public void menuRicerca() {
        System.out.println("cerca:");
        boolean continua = true;
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
            scanner.nextLine(); // Consume newline char

            switch (sceltaRicerca) {
                case 0:
                    menuMagazzino();
                case 1:
                    //TODO
                    System.out.print("Inserisci il tipo di dispositivo (SMARTPHONE, NOTEBOOK, TABLET): ");
                    String tipoDispositivoStr = scanner.next().toUpperCase();

                    try {
                        TipoDispositivo tipoDispositivo = TipoDispositivo.valueOf(tipoDispositivoStr);
                        ArrayList<Prodotto> dispositiviTrovati = Metodi.cercaDispositiviPerTipo(magazzino, tipoDispositivo);

                        for (Prodotto dispositivo : dispositiviTrovati) {
                            System.out.println(dispositivo);
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Tipo di dispositivo non valido.");
                    }
                    break;
                case 2:
                    metodi.cercaPerRangePrezzo();
                    break;

                case 3:
                    System.out.print("Inserisci il produttore: ");
                    String produttore = scanner.next().toUpperCase();
                    ArrayList<Prodotto> dispositiviTrovati1 = Metodi.cercaDispositiviPerProduttore(magazzino, produttore);

                    for (Prodotto dispositivo : dispositiviTrovati1) {
                        System.out.println(dispositivo);
                    }
                    break;
                case 4:
                    System.out.print("Inserisci il modello: ");
                    String modello = scanner.next().toUpperCase();
                    ArrayList<Prodotto> dispositiviTrovati2 = Metodi.cercaDispositiviPerModello(magazzino, modello);

                    for (Prodotto dispositivo : dispositiviTrovati2) {
                        System.out.println(dispositivo);
                    }
                    break;
                case 5:
                    metodi.ricercaPerPrezzoAcquisto(magazzino);
                    break;
                case 6:
                    metodi.ricercaPerPrezzoVendita(magazzino);
                    break;

                default:
                    System.out.println("Scelta non valida!");
                    break;
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
        Prodotto nuovoProdotto = new Prodotto(
                tipoDispositivo,
                produttore,
                modello,
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

        List<Prodotto> dispositivi = magazzino.getInventario();
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
        for (Prodotto prodotto : carrello.getProdotti()) {
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
                Prodotto prodotto = magazzino.trovaProdottoPerId(id);
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
}
