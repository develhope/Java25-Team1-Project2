import java.util.Scanner;

public class GestoreMagazzino {
    public static void aggiungiDispositivoManuale(Magazzino magazzino) {
        Scanner scanner = new Scanner(System.in);

        // Richiesta per il tipo di dispositivo desiderato
        System.out.println("Inserisci il dispositivo desiderato (SMARTPHONE, NOTEBOOK, TABLET): ");
        String tipoDispositivoInput = scanner.nextLine();

        // Converte il tipo di dispositivo inserito dall'utente in TipoDispositivo
        TipoDispositivo tipoDispositivo = TipoDispositivo.valueOf(tipoDispositivoInput.toUpperCase());

        // Richiesta dei dettagli specifici del dispositivo
        System.out.println("Inserisci il produttore del dispositivo:");
        String produttore = scanner.nextLine();
        System.out.println("Inserisci il modello del dispositivo:");
        String modello = scanner.nextLine();
        System.out.println("Inserisci la dimensione del display del dispositivo (in pollici):");
        double display = scanner.nextDouble();
        System.out.println("Inserisci lo spazio di archiviazione del dispositivo (in GB):");
        int spazioArchiviazione = scanner.nextInt();
        System.out.println("Inserisci il prezzo di acquisto del dispositivo:");
        double prezzoAcquisto = scanner.nextDouble();
        System.out.println("Inserisci il prezzo di vendita del dispositivo:");
        double prezzoVendita = scanner.nextDouble();
        System.out.println("Inserisci il tipo di memoria di archiviazione del dispositivo (SSD/NVMe):");
        String tipoMemoria = scanner.next();

        // Converte il tipo di memoria inserito dall'utente in TipoMemoriaArchiviazione
        TipoMemoriaArchiviazione tipoMemoriaArchiviazione = TipoMemoriaArchiviazione.valueOf(tipoMemoria.toUpperCase());

        // Aggiunge il dispositivo al magazzino in base al tipo
        switch (tipoDispositivo) {
            case SMARTPHONE:
                Smartphone smartphone = new Smartphone(magazzino.getNextId(), produttore, modello, display, spazioArchiviazione, prezzoAcquisto, prezzoVendita, tipoMemoriaArchiviazione);
                magazzino.aggiungiProdotto(smartphone);
                break;
            case NOTEBOOK:
                Notebook notebook = new Notebook(magazzino.getNextId(), produttore, modello, display, spazioArchiviazione, prezzoAcquisto, prezzoVendita, tipoMemoriaArchiviazione);
                magazzino.aggiungiProdotto(notebook);
                break;
            case TABLET:
                Tablet tablet = new Tablet(magazzino.getNextId(), produttore, modello, display, spazioArchiviazione, prezzoAcquisto, prezzoVendita, tipoMemoriaArchiviazione);
                magazzino.aggiungiProdotto(tablet);
                break;
            default:
                System.out.println("Tipo di dispositivo non valido.");
        }

        System.out.println("Dispositivo aggiunto al magazzino.");
    }
}