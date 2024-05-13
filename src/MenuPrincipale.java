import java.util.Scanner;
import java.util.UUID;

public class MenuPrincipale {
    private Magazzino magazzino;
    private Carrello carrello;
    private Scanner scanner;

    public MenuPrincipale() {
        magazzino = new Magazzino();
        carrello = new Carrello();
        scanner = new Scanner(System.in);
    }

    public void mostraMenu() {
        int scelta = 0;

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
                    System.out.println("Inserisci prezzo minimo: ");
                    double prezzoMinimo = scanner.nextDouble();
                    System.out.println("Inserisci prezzo massimo: ");
                    double prezzoMassimo = scanner.nextDouble();
                    magazzino.cercaPerRangePrezzo(prezzoMinimo, prezzoMassimo);
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
        String descrizione = scanner.nextLine().trim();
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

    private void visualizzaInventario() {
        System.out.println("Lista dell'inventario:");
        for (Prodotti prodotto : magazzino.getInventario()) {
            System.out.println(prodotto);
        }
    }
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
        System.out.println("Totale carrello: " + carrello.calcolaTotale() + " euro");
    }
    private void finalizzaAcquisto() {
        carrello.finalizzaAcquisto();
    }
}
