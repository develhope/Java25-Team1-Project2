import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Magazzino {
    private List<Prodotti> inventario ;
    private List<Prodotti> carrello;

    //costruttore
    public Magazzino() {
        inventario = new ArrayList<>();
        carrello = new ArrayList<>();
        dispositivi();
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
    // Aggiungi un prodotto al carrello
    public void aggiungiAlCarrello(UUID id) {
        Prodotti prodotto = trovaProdottoPerId(id, inventario);
        if (prodotto != null) {
            inventario.remove(prodotto);
            carrello.add(prodotto);
        } else {
            System.out.println("Prodotto non trovato.");
        }
    }
    // Rimuovi un prodotto dal carrello
    public void rimuoviDalCarrello(UUID id) {
        Prodotti prodotto = trovaProdottoPerId(id, carrello);
        if (prodotto != null) {
            carrello.remove(prodotto);
            inventario.add(prodotto);
        } else {
            System.out.println("Prodotto non trovato nel carrello.");
        }
    }
    // Calcola il totale del carrello
    public double calcolaTotaleCarrello() {
        double totale = 0;
        for (Prodotti prodotto : carrello) {
            totale += prodotto.prezzoVendita;
        }
        return totale;
    }
    // Finalizza l'operazione di vendita
    public void finalizzaVendita() {
        inventario.removeAll(carrello);
        carrello.clear();
        System.out.println("Vendita conclusa. Carrello svuotato.");
    }
    // Trova un prodotto per id
    private Prodotti trovaProdottoPerId(UUID id, List<Prodotti> lista) {
        for (Prodotti prodotto : lista) {
            if (prodotto.getId().equals(id)) {
                return prodotto;
            }
        }
        return null;
    }

    // Restituisce l'inventario
    public List<Prodotti> getInventario() {
        return inventario;
    }
    public void stampaCarrello() {
        System.out.println(carrello);
    }

}

