import java.util.ArrayList;
import java.util.List;

public class Magazzino {
     ArrayList<Prodotti> prodottiInMagazzino = new ArrayList<>();
     ArrayList<Prodotti> prodottiInCarrello = new ArrayList<>();
     int idCounter = 1;

    public List<Prodotti> aggiungiProdotto(Prodotti prodotto) {
        prodottiInMagazzino.add(prodotto);
        return prodottiInMagazzino;
    }

    public void aggiungiDispositivi(int quantita, TipoDispositivo tipo) {
        for (int i = 0; i < quantita; i++) {
            switch (tipo) {
                case TABLET:
                    Tablet tablet = new Tablet(getNextId(), "Samsung", "Galaxy Tab S9 Series", 14.6, 160, 1100.99, 1299.99, TipoMemoriaArchiviazione.NVMe);
                    prodottiInMagazzino.add(tablet);
                    break;
                case SMARTPHONE:
                    Smartphone smartphone = new Smartphone(getNextId(), "Asus", "Rog Phone 7 Ultimate", 6.78, 512, 1499.00, 1599.00, TipoMemoriaArchiviazione.NVMe);
                    prodottiInMagazzino.add(smartphone);
                    break;
                case NOTEBOOK:
                    Notebook notebook = new Notebook(getNextId(), "Apple", "Macbook Pro", 16.0, 512, 2650.00, 3099.00, TipoMemoriaArchiviazione.SSD);
                    prodottiInMagazzino.add(notebook);
                    break;
                default:
                    System.out.println("Tipo di dispositivo non valido.");
            }
        }
        System.out.println(quantita + " dispositivi " + tipo + " aggiunti al magazzino.");
    }

    public int getNextId() {
        return idCounter++;
    }

    public void stampaMagazzino() { //rinomina in elencoProdotti?
        System.out.println("Prodotti in magazzino:");
        for (Prodotti prodotto : prodottiInMagazzino) {
            System.out.println("ID: " + prodotto.leggiId() + ", Tipo: " + prodotto.leggiTipoDispositivo() + ", Produttore: " + prodotto.leggiProduttore() + ", Modello: " + prodotto.leggiModello());
        }
    }
 }
