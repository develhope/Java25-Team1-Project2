import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Magazzino magazzino1 = new Magazzino();
        Magazzino magazzino2 = new Magazzino();
        Magazzino magazzino3 = new Magazzino();

        Carrello carrello = new Carrello();

        Smartphone smartphone1 = new Smartphone(TipoDispositivoEnum.SMARTPHONE, "Asus", "Rog Phone 7 Ultimate", 5.7,
                TipoMemoriaArchiviazioneEnum.NVMe, SpazioDiArchiviazioneEnum.CINQUECENTODODICI, 899.99, 1299.99,
                UUID.randomUUID());

        Smartphone smartphone2 = new Smartphone(TipoDispositivoEnum.SMARTPHONE, "Apple", "Iphone X", 4.5,
                TipoMemoriaArchiviazioneEnum.NVMe, SpazioDiArchiviazioneEnum.CENTOVENTOTTO, 799.99, 1399.99,
                UUID.randomUUID());

        Notebook notebook1 = new Notebook(TipoDispositivoEnum.NOTEBOOK, "Apple", "MacBook Air 13", 15.0,
                TipoMemoriaArchiviazioneEnum.SSD, SpazioDiArchiviazioneEnum.CINQUECENTODODICI, 999.99, 1699.99,
                UUID.randomUUID());

        Notebook notebook2 = new Notebook(TipoDispositivoEnum.NOTEBOOK, "Acer", "Predator Helios 16", 16.0,
                TipoMemoriaArchiviazioneEnum.SSD, SpazioDiArchiviazioneEnum.DUEMILAQUARANTADUE, 999.99, 1599.99,
                UUID.randomUUID());

        Tablet tablet1 = new Tablet(TipoDispositivoEnum.TABLET, "Samsung", "Galaxy Tab a7", 10.4,
                TipoMemoriaArchiviazioneEnum.SSD, SpazioDiArchiviazioneEnum.TRENTADUE, 599.99, 799.99,
                UUID.randomUUID());

        Tablet tablet2 = new Tablet(TipoDispositivoEnum.TABLET, "Samsung", "Galaxy Tab a9+", 12.0,
                TipoMemoriaArchiviazioneEnum.SSD, SpazioDiArchiviazioneEnum.SESSANTAQUATTRO, 999.99, 1599.99,
                UUID.randomUUID());

        magazzino1.aggiungiProdotto(smartphone1);
        magazzino1.aggiungiProdotto(smartphone2);
        magazzino2.aggiungiProdotto(notebook1);
        magazzino2.aggiungiProdotto(notebook2);
        magazzino3.aggiungiProdotto(tablet1);
        magazzino3.aggiungiProdotto(tablet2);

        System.out.println("Magazzino 1:");
        magazzino1.getMagazzino().forEach(System.out::println);
        System.out.println("Magazzino 2:");
        magazzino2.getMagazzino().forEach(System.out::println);
        System.out.println("Magazzino 3:");
        magazzino3.getMagazzino().forEach(System.out::println);
    }


    // Metodo generico per la ricerca di dispositivi
    public static ArrayList<Prodotto> cercaDispositivi(Magazzino magazzino, Predicate<Prodotto> condition, String message) {
        List<Prodotto> dispositiviRicercati = magazzino.getMagazzino().stream()
                .filter(condition)
                .toList();

        return new ArrayList<>(dispositiviRicercati);
    }

    // Metodo per fare la ricerca per tipo di dispositivo
    public static void cercaDispositiviPerTipo(Magazzino magazzino, String tipoDispositivoStr) {
        TipoDispositivoEnum tipoDispositivo = null;
        try {
            tipoDispositivo = TipoDispositivoEnum.valueOf(tipoDispositivoStr.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo di dispositivo non valido.");
            return;
        }

        TipoDispositivoEnum finalTipoDispositivo = tipoDispositivo;
        ArrayList<Prodotto> dispositiviTrovati = cercaDispositivi(magazzino,
                dispositivo -> dispositivo.getTipoDispositivo() == finalTipoDispositivo,
                "di tipo " + tipoDispositivo);

        if (dispositiviTrovati.isEmpty()) {
            System.out.println("Dispositivo non trovato.");
            System.out.println("Dispositivi già presenti nel magazzino:");
            for (Prodotto dispositivo : magazzino.getMagazzino()) {
                System.out.println(dispositivo);
            }
        } else {
            for (Prodotto dispositivo : dispositiviTrovati) {
                System.out.println(dispositivo);
            }
        }
    }

    // Metodo per fare la ricerca per produttore
    public static void cercaDispositiviPerProduttore(Magazzino magazzino, String produttore) {
        ArrayList<Prodotto> dispositiviTrovati = new ArrayList<>();

        for (Prodotto dispositivo : magazzino.getMagazzino()) {
            if (dispositivo.getProduttore().equalsIgnoreCase(produttore.trim().toUpperCase())) {
                dispositiviTrovati.add(dispositivo);
            }
        }

        if (dispositiviTrovati.isEmpty()) {
            System.out.println("Produttore non trovato.");
            System.out.println("Produttori già presenti nel magazzino:");
            for (Prodotto dispositivo : magazzino.getMagazzino()) {
                System.out.println(dispositivo.getProduttore());
            }
        } else {
            for (Prodotto dispositivo : dispositiviTrovati) {
                System.out.println(dispositivo);
            }
        }
    }

    // Metodo per fare la ricerca per modello
    public static void cercaDispositiviPerModello(Magazzino magazzino, String modello) {
        String modelloLowerCase = modello.trim().toLowerCase();
        ArrayList<Prodotto> dispositiviTrovati = cercaDispositivi(magazzino,
                dispositivo -> dispositivo.getModello().toLowerCase().contains(modelloLowerCase),
                "con il modello " + modello);

        if (dispositiviTrovati.isEmpty()) {
            System.out.println("Modello non trovato.");
            System.out.println("Modelli già presenti nel magazzino:");
            for (Prodotto dispositivo : magazzino.getMagazzino()) {
                System.out.println(dispositivo.getModello());
            }
        } else {
            for (Prodotto dispositivo : dispositiviTrovati) {
                System.out.println(dispositivo);
            }
        }
    }

    // Metodo per fare la ricerca per prezzo di acquisto
    public void ricercaPerPrezzoAcquisto(Magazzino magazzino, String inputPrezzo) {
        try {
            inputPrezzo = inputPrezzo.replace(",", ".");
            BigDecimal prezzoAcquisto = new BigDecimal(inputPrezzo);

            double prezzoAcquistoDouble = prezzoAcquisto.doubleValue();
            double rangeMinimo = prezzoAcquistoDouble - 150;
            double rangeMassimo = prezzoAcquistoDouble + 150;

            ArrayList<Prodotto> dispositiviTrovati = new ArrayList<>();
            for (Prodotto dispositivo : magazzino.getMagazzino()) {
                if (dispositivo.getPrezzoAcquisto() >= rangeMinimo && dispositivo.getPrezzoAcquisto() <= rangeMassimo) {
                    dispositiviTrovati.add(dispositivo);
                }
            }

            if (dispositiviTrovati.isEmpty()) {
                System.out.println("Nessun dispositivo trovato con un prezzo di acquisto entro " + rangeMinimo + " e " + rangeMassimo + " €.");
            } else {
                for (Prodotto dispositivo : dispositiviTrovati) {
                    System.out.println(dispositivo);
                }
            }
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println("Input non valido. Assicurati di inserire un numero valido.");
        }
    }

    // Metodo per fare la ricerca per prezzo di vendita
    public void ricercaPerPrezzoVendita(Magazzino magazzino, String inputPrezzo) {
        try {
            inputPrezzo = inputPrezzo.replace(",", ".");
            BigDecimal prezzoVendita = new BigDecimal(inputPrezzo);

            double prezzoVenditaDouble = prezzoVendita.doubleValue();
            double rangeMinimo = prezzoVenditaDouble - 150;
            double rangeMassimo = prezzoVenditaDouble + 150;

            ArrayList<Prodotto> dispositiviTrovati = new ArrayList<>();
            for (Prodotto dispositivo : magazzino.getMagazzino()) {
                if (dispositivo.getPrezzoVendita() >= rangeMinimo && dispositivo.getPrezzoVendita() <= rangeMassimo) {
                    dispositiviTrovati.add(dispositivo);
                }
            }

            if (dispositiviTrovati.isEmpty()) {
                System.out.println("Nessun dispositivo trovato con un prezzo di vendita entro " + rangeMinimo + " e " + rangeMassimo + " €.");
            } else {
                for (Prodotto dispositivo : dispositiviTrovati) {
                    System.out.println(dispositivo);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Input non valido. Assicurati di inserire un numero valido.");
        }
    }

    //TODO Correggere metodo commentato sotto
    // Metodo che cerca e stampa i dispositivi presenti in un determinato Range di prezzo

   /* public List<Prodotto> cercaPerRangePrezzo(double prezzoMinimo, double prezzoMassimo) {
        List<Prodotto> result = new ArrayList<>();

        for (Prodotto dispositivo : magazzino) {
            if (dispositivo.getPrezzoVendita() >= prezzoMinimo &&
                    dispositivo.getPrezzoVendita() <= prezzoMassimo) {
                result.add(dispositivo);
                System.out.println(dispositivo);
            }
        }

        if (result.isEmpty()) {
            System.out.println("Nessun dispositivo trovato nel range di prezzo specificato.");
        }

        return result;
    }

    */

}