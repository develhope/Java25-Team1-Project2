import java.util.List;
import java.util.Scanner;
import java.util.UUID;

//TODO aggiungere quantità del prodotto in modo tale che non venga più eliminato il prodotto dal magazzino e dia un messaggiodi errore se è terminato


public class MenuPrincipale {
    private Magazzino magazzino;
    private Carrello carrello;
    private Scanner scanner;
    private  Metodi metodi;

    public MenuPrincipale() {
        magazzino = new Magazzino();
        carrello = new Carrello(magazzino);
        scanner = new Scanner(System.in);
        metodi = new Metodi();
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
            System.out.println("0. Torna al menu principale");
            System.out.print("Scelta: ");

            visualizzaInventario();

            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    aggiungiAlMagazzino();
                    break;
                case 2:
                   menuRicerca();
                    break;
                case 0:
                    continua = false;
                    break;
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
            System.out.println("0. Torna al menu principale");
            System.out.print("Scelta: ");

            visualizzaCarrello();

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
                case 0:
                    continua = false;
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
            System.out.println("5. Per prezzo di vendita");
            System.out.println("6. Per prezzo di acquisto");
            System.out.println("0. Torna al menu Magazzino");
            System.out.print("Scelta: ");
            int sceltaRicerca = scanner.nextInt();
            scanner.nextLine(); // Consume newline char

            switch (sceltaRicerca) {
                case 0:
                    menuMagazzino();
                case 1:
                    System.out.print("Inserisci il tipo di dispositivo: ");
                    String tipoDispositivo = scanner.next();
                    metodi.cercaDispositiviPerTipo(magazzino, TipoDispositivo.valueOf(tipoDispositivo));
                    break;
                case 2:
                    System.out.println("Inserisci prezzo minimo: ");
                    double prezzoMinimo = scanner.nextDouble();
                    System.out.println("Inserisci prezzo massimo: ");
                    double prezzoMassimo = scanner.nextDouble();
                    magazzino.cercaPerRangePrezzo(prezzoMinimo, prezzoMassimo);
                    break;
                case 3:
                    System.out.print("Inserisci il produttore: ");
                    String produttore = scanner.next();
                    metodi.cercaDispositiviPerProduttore(magazzino, produttore);
                    break;
                case 4:
                    System.out.print("Inserisci il modello: ");
                    String modello = scanner.next();
                    metodi.cercaDispositiviPerModello(magazzino, modello);
                    break;
                case 5:
                    System.out.print("Inserisci il prezzo vendita: ");
                    Double prezzoVendita = scanner.nextDouble();
                    metodi.ricercaPrezzoVendita(magazzino, prezzoVendita);
                    break;
                case 6:
                    System.out.print("Inserisci il prezzo acquisto: ");
                    Double prezzoAcquisto = scanner.nextDouble();
                    metodi.ricercaPrezzoAcquisto(magazzino, prezzoAcquisto);

                default:
                    System.out.println("Scelta non valida!");
                    break;
            }
        }
    }
    private void aggiungiAlMagazzino() {
        // Richiedi all'utente i dettagli del nuovo prodotto
        TipoDispositivo tipoDispositivo = null;
        while (tipoDispositivo == null){
            try{
                System.out.println("Inserisci il tipo di dispositivo (smartphone, tablet o notebook): ");
                tipoDispositivo = TipoDispositivo.valueOf(scanner.next().toUpperCase());
            }catch (IllegalArgumentException e){
                System.out.println("Tipo di dispositivo non valido. Inserisci nuovamente: ");
            }

        }

        System.out.println("Inserisci il produttore: ");
        String produttore = scanner.next();
        System.out.println("Inserisci il modello: ");
        String modello = scanner.next();
        System.out.println("Inserisci una descrizione (opzionale): ");
        String descrizione = scanner.next();
        System.out.println("Inserisci la dimensione del display: ");
        Double dimensioneDisplay = scanner.nextDouble();

        TipoMemoriaArchiviazione tipoMemoria = null;
        while(tipoMemoria == null){
            try{
                System.out.println("Inserisci il tipo di memoria (HDD, SSD, NVMe): ");
                tipoMemoria = TipoMemoriaArchiviazione.valueOf(scanner.next().toUpperCase());
            }catch (IllegalArgumentException e){
                System.out.println("Tipo di memoria non valido. Inserisci nuovamente: ");
            }
        }
        System.out.println("Inserisci la dimensione dello spazio di archiviazione: ");
        Integer dimensioneArchiviazione = scanner.nextInt();
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
}
