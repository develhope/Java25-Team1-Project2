import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Metodi {

    // Metodo per stampare tutti i dispositivi presenti nel magazzino
    public static void stampaDispositiviMagazzino(Magazzino magazzino) {
        List<Prodotti> dispositivi = magazzino.getInventario();

        if (dispositivi.isEmpty()) {
            System.out.println("Nessun dispositivo presente in magazzino.");
        } else {
            System.out.println("Dispositivi in magazzino:");
            dispositivi.forEach(System.out::println);
        }
    }

    // Metodo generico per la ricerca di dispositivi
    public static ArrayList<Prodotti> cercaDispositivi(Magazzino magazzino, Predicate<Prodotti> condition, String message) {
        List<Prodotti> dispositiviRicercati = magazzino.getInventario().stream()
                .filter(condition)
                .toList();

        if (dispositiviRicercati.isEmpty()) {
            System.out.println("Nessun dispositivo " + message + " trovato.");
        } else {
            System.out.println("Dispositivi " + message + " trovati:");
            dispositiviRicercati.forEach(System.out::println);
        }

        return new ArrayList<>(dispositiviRicercati);
    }

    // Metodo per fare la ricerca per tipo di dispositivo
    public static ArrayList<Prodotti> cercaDispositiviPerTipo(Magazzino magazzino, TipoDispositivo tipoDispositivo) {
        return cercaDispositivi(magazzino, dispositivo -> dispositivo.getSetTipoDispositivo() == tipoDispositivo,
                "di tipo " + tipoDispositivo);
    }

    // Metodo per fare la ricerca per produttore
    public static ArrayList<Prodotti> cercaDispositiviPerProduttore(Magazzino magazzino, String produttore) {
        return cercaDispositivi(magazzino, dispositivo -> dispositivo.getProduttore().equalsIgnoreCase(produttore),
                "del produttore " + produttore);
    }

    // Metodo per fare la ricerca per modello
    public static ArrayList<Prodotti> cercaDispositiviPerModello(Magazzino magazzino, String modello) {
        return cercaDispositivi(magazzino, dispositivo -> dispositivo.getModello().equalsIgnoreCase(modello),
                "con il modello " + modello);
    }
}
