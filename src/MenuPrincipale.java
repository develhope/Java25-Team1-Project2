import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class MenuPrincipale {
    private Magazzino magazzino;
    private Scanner scanner;

    public MenuPrincipale() {
        magazzino = new Magazzino();
        scanner = new Scanner(System.in);
    }

    public void mostraMenu() {
        int scelta = 0;

        do {
            System.out.println("\nCosa vuoi fare?");
            System.out.println("1. Accedi al magazzino");
            System.out.println("2. Creazione carrello");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");

            scelta = scanner.nextInt();



            switch (scelta) {
                case 0:
                    System.out.println("Arrivederci!");
                    break;
                case 1:
                    menuMagazzino(scanner);
                    break;
                case 2:
                    menuCarrello(scanner);
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }while (scelta != 0);
        scanner.close();
    }
    // Metodo per gestire il menu del magazzino
    public void menuMagazzino(Scanner scanner) {
        System.out.println("Magazzino:");
        boolean continua = true;
        while (continua) {
            System.out.println("\n Menu:");
            System.out.println("1. Aggiungi Prodotto");
            System.out.println("2. cerca prodotto");
            System.out.println("0. Torna al  menu principale ");
            System.out.print("Scelta: ");
            System.out.println("");

            visualizzaInventario();

            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    aggiungiAllInventario();
                    break;

                case 2:
                    //TODO implementare metodi di ricerca del prodotto
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
    public void menuCarrello(Scanner scanner) {
        System.out.println("Carrello:");
        boolean continua = true;
        while (continua) {
            System.out.println("\n Menu:");
            System.out.println("1. Aggiungi prodotto al carrello: ");
            System.out.println("2. Rimuovi prodotto al carrello:");
            System.out.println("3. Calcola TOT. carello:");
            System.out.println("4. Finalizza vendita:");
            System.out.println("0. Torna al  menu principale ");
            System.out.print("Scelta: ");
            System.out.println("");
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
                    finalizzaVendita();
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
    private void aggiungiAllInventario() {
        // Richiedi all'utente i dettagli del nuovo prodotto
        System.out.println("Inserisci il tipo di dispositivo (tablet, smartphone o notebook): ");
        TipoDispositivo setTipoDispositivo = TipoDispositivo.valueOf(scanner.next());

        System.out.println("Inserisci il produttore: ");
        String produttore = scanner.next();
        System.out.println("Inserisci il modello: ");
        String modello = scanner.next();
        System.out.println("Inserisci una descrizione (opzionale): ");
        String descrizione = scanner.next();
        System.out.println("Inserisci la dimensione del display: ");
        double dimensioneDisplay = scanner.nextDouble();
        System.out.println("Inserisci il tipo di memoria (HDD, SSD, NVMe,): ");
        TipoMemoriaArchiviazione setTipoMemoria = TipoMemoriaArchiviazione.valueOf(scanner.next());
        System.out.println("Inserisci la dimensione dello spazio di archiviazione: ");
        double dimensioneArchiviazione = scanner.nextDouble();
        System.out.println("Inserisci il prezzo di acquisto:");
        double prezzoAcquisto = scanner.nextDouble();
        System.out.println("Inserisci il prezzo di vendita:");
        double prezzoVendita = scanner.nextDouble();

        // Genera un ID casuale per il nuovo prodotto
        UUID id = UUID.randomUUID();

        // Aggiungi il nuovo prodotto all'inventario
        Prodotti nuovoProdotto = new Prodotti(setTipoDispositivo, produttore, modello, descrizione,
                dimensioneDisplay,setTipoMemoria, dimensioneArchiviazione, prezzoAcquisto, prezzoVendita, id);
        magazzino.aggiungiProdotto(nuovoProdotto);
        System.out.println("Prodotto aggiunto all'inventario.");
    }
    private void visualizzaInventario() {
        System.out.println("Lista dell'inventario:");
        List<Prodotti> inventario = magazzino.getInventario();
        for (Prodotti prodotto: inventario){
            System.out.println(prodotto);
        }
    }
    private void visualizzaCarrello() {
        System.out.println("Lista del carrello:");
        List<Prodotti> carrello = magazzino.getInventario();
        for (Prodotti prodotto: carrello){
            System.out.println("ID: " + prodotto.getId());
            System.out.println("Tipo dispositivo: " + prodotto.setTipoDispositivo);
            System.out.println("Produttore: " + prodotto.produttore);
            System.out.println("Modello: " + prodotto.modello);
            System.out.println("Dimensione memoria: " + prodotto.setTipoMemoria);
            System.out.println("Prezzo vendita: " + prodotto.prezzoVendita);
            System.out.println();
        }
    }
    private void aggiungiAlCarrello() {
        System.out.println("Inserisci l'ID del prodotto da aggiungere al carrello:");
        String idAggiuntaString = scanner.next();
        UUID idAggiunta = UUID.fromString(idAggiuntaString);
        magazzino.aggiungiAlCarrello(idAggiunta);
    }

    private void rimuoviDalCarrello() {
        System.out.println("Inserisci l'ID del prodotto da rimuovere dal carrello:");
        String idRimozioneString = scanner.next();
        UUID idRimozione = UUID.fromString(idRimozioneString);
        magazzino.rimuoviDalCarrello(idRimozione);
    }

    private void calcolaTotaleCarrello() {
        System.out.println("Totale carrello: " + magazzino.calcolaTotaleCarrello() + " euro");
    }

    private void finalizzaVendita() {
        magazzino.finalizzaVendita();
    }



}
