import java.util.ArrayList;

public class Metodi {

    // Metodo per stampare tutti i dispositivi presenti nel magazzino
    public ArrayList<Prodotti> stampaDispositiviMagazzino(Magazzino magazzino) {
        ArrayList<Prodotti> dispositivi = magazzino.getProdottiInMagazzino();

        if (dispositivi.isEmpty()) {
            System.out.println("Nessun dispositivo presente in magazzino.");
            return null;
        } else {
            System.out.println("Dispositivi in magazzino:");
            for (Prodotti dispositivo : dispositivi) {
                System.out.println(dispositivo);
            }
            return dispositivi;
        }
    }

    // Metodo per fare la ricerca per tipo di dispositivo
    public static ArrayList<Prodotti> cercaDispositiviPerTipo(Magazzino magazzino, TipoDispositivo tipoDispositivo) {
        ArrayList<Prodotti> dispositiviRicercati = new ArrayList<>();

        for (Prodotti dispositivo : magazzino.getProdottiInMagazzino()) {
            if (dispositivo.leggiTipoDispositivo() == tipoDispositivo) {
                dispositiviRicercati.add(dispositivo);
            }
        }

        if (dispositiviRicercati.isEmpty()) {
            System.out.println("Nessun dispositivo di tipo " + tipoDispositivo + " trovato.");
            return null;
        } else {
            System.out.println("Dispositivi di tipo " + tipoDispositivo + " trovati:");
            for (Prodotti dispositivo : dispositiviRicercati) {
                System.out.println(dispositivo);
            }
            return dispositiviRicercati;
        }
    }

    // Metodo per fare la ricerca per produttore
    public static ArrayList<Prodotti> cercaDispositiviPerProduttore(Magazzino magazzino, String produttore) {
        ArrayList<Prodotti> dispositiviRicercati = new ArrayList<>();

        for (Prodotti dispositivo : magazzino.getProdottiInMagazzino()) {
            if (dispositivo.leggiProduttore().equalsIgnoreCase(produttore)) {
                dispositiviRicercati.add(dispositivo);
            }
        }

        if (dispositiviRicercati.isEmpty()) {
            System.out.println("Nessun dispositivo del produttore " + produttore + " trovato.");
            return null;
        } else {
            System.out.println("Dispositivi del produttore " + produttore + " trovati:");
            for (Prodotti dispositivo : dispositiviRicercati) {
                System.out.println(dispositivo);
            }
            return dispositiviRicercati;
        }
    }

    // Metodo per fare la ricerca per modello
    public static ArrayList<Prodotti> cercaDispositiviPerModello(Magazzino magazzino, String modello) {
        ArrayList<Prodotti> dispositiviRicercati = new ArrayList<>();

        for (Prodotti dispositivo : magazzino.getProdottiInMagazzino()) {
            if (dispositivo.leggiModello().equalsIgnoreCase(modello)) {
                dispositiviRicercati.add(dispositivo);
            }
        }

        if (dispositiviRicercati.isEmpty()) {
            System.out.println("Nessun dispositivo con il modello " + modello + " trovato.");
            return null;
        } else {
            System.out.println("Dispositivi con il modello " + modello + " trovati:");
            for (Prodotti dispositivo : dispositiviRicercati) {
                System.out.println(dispositivo);
            }
            return dispositiviRicercati;
        }
    }
}
