import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Magazzino {
    private List<Prodotti> inventario ;

    //costruttore
    public Magazzino() {
        inventario = new ArrayList<>();
        dispositivi();

    public List<Prodotti> aggiungiProdotto(Prodotti prodotto) {
        prodottiInMagazzino.add(prodotto);
        return prodottiInMagazzino;
    }

    public List<Prodotti> dispositivi() {
        Smartphone smartphone1 = new Smartphone(TipoDispositivo.SMARTPHONE, "Apple", "Iphone12", "Ciao", 5.5, TipoMemoriaArchiviazione.NVMe, 128, 899.99, 999.99, UUID.randomUUID());
        Smartphone smartphone2 = new Smartphone(TipoDispositivo.SMARTPHONE, "Samsung", "Galaxy A71", "è un buon telefono", 6.3, TipoMemoriaArchiviazione.NVMe, 512, 499.99, 799.99, UUID.randomUUID());
        Notebook notebook1 = new Notebook(TipoDispositivo.NOTEBOOK, "Intel", "Chuwi", "Ciao2", 15.4, TipoMemoriaArchiviazione.HDD, 512, 269.99, 599.99, UUID.randomUUID());
        Tablet tablet1 = new Tablet(TipoDispositivo.TABLET, "Samsung", "Galaxy S7", "è bello", 10.1, TipoMemoriaArchiviazione.SSD, 512, 249.99, 599.99, UUID.randomUUID());

        inventario.add(smartphone1);
        inventario.add(smartphone2);
        inventario.add(notebook1);
        inventario.add(tablet1);

        return inventario;
    }

    // Aggiungi un prodotto all'inventario
    public Boolean aggiungiProdotto(Prodotti prodotto) {
        return inventario.add(prodotto);
    }

    // Rimuovi un prodotto dall'inventario
    public Boolean rimuoviProdotto(UUID id) {
        return inventario.removeIf(p -> p.getId().equals(id));
    }

    // Restituisce l'inventario
    public List<Prodotti> getInventario() {
        return inventario;
    }

    // Trova un prodotto per id
    Prodotti trovaProdottoPerId(UUID id) {
        for (Prodotti prodotto : inventario) {
            if (prodotto.getId().equals(id)) {
                return prodotto;
            }
        }
        return null;
    }
}

