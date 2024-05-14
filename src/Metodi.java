import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Metodi {

    // Metodo generico per la ricerca di dispositivi
    public ArrayList<Prodotti> cercaDispositivi(Magazzino magazzino, Predicate<Prodotti> condition, String message) {
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
    public ArrayList<Prodotti> cercaDispositiviPerTipo(Magazzino magazzino, TipoDispositivo tipoDispositivo) {
        return cercaDispositivi(magazzino, dispositivo -> dispositivo.getTipoDispositivo() == tipoDispositivo,
                "di tipo " + tipoDispositivo);
    }

    // Metodo per fare la ricerca per produttore
    public ArrayList<Prodotti> cercaDispositiviPerProduttore(Magazzino magazzino, String produttore) {
        return cercaDispositivi(magazzino, dispositivo -> dispositivo.getProduttore().equalsIgnoreCase(produttore),
                "del produttore " + produttore);
    }

    // Metodo per fare la ricerca per modello
    public ArrayList<Prodotti> cercaDispositiviPerModello(Magazzino magazzino, String modello) {
        return cercaDispositivi(magazzino, dispositivo -> dispositivo.getModello().equalsIgnoreCase(modello),
                "con il modello " + modello);
    }

    public ArrayList<Prodotti> ricercaPrezzoVendita(Magazzino magazzino, double prezzoDaCercare) {
        return cercaDispositivi(magazzino, dispositivo -> dispositivo.getPrezzoVendita() == prezzoDaCercare,
                "Per prezzo vendita " + prezzoDaCercare + " €");
    }

    public ArrayList<Prodotti> ricercaPrezzoAcquisto(Magazzino magazzino, double prezzoDaCercare) {
        return cercaDispositivi(magazzino, dispositivo -> dispositivo.getPrezzoAcquisto() == prezzoDaCercare,
                "Per prezzo d' acquisto " + prezzoDaCercare + " €");
    }

}