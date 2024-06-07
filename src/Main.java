import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        Magazzino magazzinoEuronics = new Magazzino();
        Magazzino magazzinoEsselunga = new Magazzino();
        Magazzino magazzinoArmani = new Magazzino();

        Carrello carrello = new Carrello();

        Smartphone smartphone1 = new Smartphone(UUID.randomUUID(),TipologiaProdottoEnum.ELETTRONICA,TipoDispositivoEnum.SMARTPHONE,);

        Smartphone smartphone2 = new Smartphone();

        Notebook notebook1 = new Notebook();

        Notebook notebook2 = new Notebook();

        Tablet tablet1 = new Tablet();

        Tablet tablet2 = new Tablet();

        magazzinoEuronics.aggiungiProdotto(smartphone1);
        magazzinoEuronics.aggiungiProdotto(smartphone2);
        magazzinoEuronics.aggiungiProdotto(notebook1);
        magazzinoEuronics.aggiungiProdotto(notebook2);
        magazzinoEuronics.aggiungiProdotto(tablet1);
        magazzinoEuronics.aggiungiProdotto(tablet2);
    }


    // TODO togliere le lambda function (stream) e usare il for each - e spostare i metodi nelle relative classi
    // Metodo generico per la ricerca di dispositivi
    public static ArrayList<Prodotto> cercaDispositivi(Magazzino magazzino, String categoria, String message) {
        List<Prodotto> dispositiviRicercati = new ArrayList<>();
        for(Prodotto prodotto : magazzino.getListaProdottiMagazzino()){
            if(prodotto.test(prodotto)){
                dispositiviRicercati.add(prodotto);
            }
        }
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
            for (Prodotto dispositivo : magazzino.getListaProdottiMagazzino()) {
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

        for (Prodotto dispositivo : magazzino.getListaProdottiMagazzino()) {
            if (dispositivo.getProduttore().equalsIgnoreCase(produttore.trim().toUpperCase())) {
                dispositiviTrovati.add(dispositivo);
            }
        }

        if (dispositiviTrovati.isEmpty()) {
            System.out.println("Produttore non trovato.");
            System.out.println("Produttori già presenti nel magazzino:");
            for (Prodotto dispositivo : magazzino.getListaProdottiMagazzino()) {
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
            for (Prodotto dispositivo : magazzino.getListaProdottiMagazzino()) {
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
            for (Prodotto dispositivo : magazzino.getListaProdottiMagazzino()) {
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
            for (Prodotto dispositivo : magazzino.getListaProdottiMagazzino()) {
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