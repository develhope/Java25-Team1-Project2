import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Magazzino {
    private List<Prodotto> inventario;
    private List<Prodotto> dispositivi;

    //costruttore
    public Magazzino() {
        this.inventario = new ArrayList<>();
        this.dispositivi = dispositivi();
    }

    public List<Prodotto> dispositivi() {
        //Prodotti per test funzionamento
        Smartphone smartphoneBuilder = new Smartphone();
        smartphoneBuilder.setTipoDispositivo(TipoDispositivo.SMARTPHONE);
        smartphoneBuilder.setProduttore("Asus");
        smartphoneBuilder.setModello("Rog Phone 7 Ultimate");
        smartphoneBuilder.setDimensioneDisplay(5.7);
        smartphoneBuilder.setTipoMemoria(TipoMemoriaArchiviazione.NVMe);
        smartphoneBuilder.setDimensioneArchiviazione(SpazioDiArchiviazione.CINQUECENTODODICI);
        smartphoneBuilder.setPrezzoAcquisto(899.99);
        smartphoneBuilder.setPrezzoVendita(1299.99);
        smartphoneBuilder.setId(UUID.randomUUID());
        Prodotto smartphone1 = smartphoneBuilder.smartphoneBiuld();

        Smartphone smartphoneBuilder2 = new Smartphone();
        smartphoneBuilder2.setTipoDispositivo(TipoDispositivo.SMARTPHONE);
        smartphoneBuilder2.setProduttore("Apple");
        smartphoneBuilder2.setModello("Iphone X");
        smartphoneBuilder2.setDimensioneDisplay(4.5);
        smartphoneBuilder2.setTipoMemoria(TipoMemoriaArchiviazione.NVMe);
        smartphoneBuilder2.setDimensioneArchiviazione(SpazioDiArchiviazione.CENTOVENTOTTO);
        smartphoneBuilder2.setPrezzoAcquisto(799.99);
        smartphoneBuilder2.setPrezzoVendita(1399.99);
        smartphoneBuilder2.setId(UUID.randomUUID());
        Prodotto smartphone2 = smartphoneBuilder2.smartphoneBiuld();

        Notebook notebookBuilder = new Notebook();
        notebookBuilder.setTipoDispositivo(TipoDispositivo.NOTEBOOK);
        notebookBuilder.setProduttore("Apple");
        notebookBuilder.setModello("MacBook Air 13");
        notebookBuilder.setDimensioneDisplay(15.0);
        notebookBuilder.setTipoMemoria(TipoMemoriaArchiviazione.SSD);
        notebookBuilder.setDimensioneArchiviazione(SpazioDiArchiviazione.CINQUECENTODODICI);
        notebookBuilder.setPrezzoAcquisto(999.99);
        notebookBuilder.setPrezzoVendita(1699.99);
        notebookBuilder.setId(UUID.randomUUID());
        Prodotto notebook1 = notebookBuilder.notebookBiuld();

        Notebook notebookBuilder1 = new Notebook();
        notebookBuilder1.setTipoDispositivo(TipoDispositivo.NOTEBOOK);
        notebookBuilder1.setProduttore("Acer");
        notebookBuilder1.setModello("Predator Helios 16");
        notebookBuilder1.setDimensioneDisplay(16.0);
        notebookBuilder1.setTipoMemoria(TipoMemoriaArchiviazione.SSD);
        notebookBuilder1.setDimensioneArchiviazione(SpazioDiArchiviazione.DUEMILAQUARANTADUE);
        notebookBuilder1.setPrezzoAcquisto(999.99);
        notebookBuilder1.setPrezzoVendita(1599.99);
        notebookBuilder1.setId(UUID.randomUUID());
        Prodotto notebook2 = notebookBuilder1.notebookBiuld();

        Tablet tabletBuilder1 = new Tablet();
        tabletBuilder1.setTipoDispositivo(TipoDispositivo.TABLET);
        tabletBuilder1.setProduttore("Samsung");
        tabletBuilder1.setModello("Galaxy Tab a7");
        tabletBuilder1.setDimensioneDisplay(10.4);
        tabletBuilder1.setTipoMemoria(TipoMemoriaArchiviazione.SSD);
        tabletBuilder1.setDimensioneArchiviazione(SpazioDiArchiviazione.TRENTADUE);
        tabletBuilder1.setPrezzoAcquisto(599.99);
        tabletBuilder1.setPrezzoVendita(799.99);
        tabletBuilder1.setId(UUID.randomUUID());
        Prodotto tablet1 = tabletBuilder1.tabletBiuld();

        Tablet tabletBuilder2 = new Tablet();
        tabletBuilder2.setTipoDispositivo(TipoDispositivo.TABLET);
        tabletBuilder2.setProduttore("Samsung");
        tabletBuilder2.setModello("Galaxy Tab a9+");
        tabletBuilder2.setDimensioneDisplay(12.0);
        tabletBuilder2.setTipoMemoria(TipoMemoriaArchiviazione.SSD);
        tabletBuilder2.setDimensioneArchiviazione(SpazioDiArchiviazione.SESSANTAQUATTRO);
        tabletBuilder2.setPrezzoAcquisto(999.99);
        tabletBuilder2.setPrezzoVendita(1599.99);
        tabletBuilder2.setId(UUID.randomUUID());
        Prodotto tablet2 = tabletBuilder2.tabletBiuld();

        inventario.add(smartphone1);
        inventario.add(smartphone2);
        inventario.add( notebook1);
        inventario.add(notebook2);
        inventario.add(tablet1);
        inventario.add(tablet2);

        return inventario;
    }

    // Aggiungi un prodotto all'inventario
    public Boolean aggiungiProdotto(Prodotto prodotto) {
        return inventario.add(prodotto);
    }

    // Rimuovi un prodotto dall'inventario
    public Boolean rimuoviProdotto(UUID id) {
        return inventario.removeIf(p -> p.getId().equals(id));
    }

    // Trova un prodotto per id
    Prodotto trovaProdottoPerId(UUID id) {
        for (Prodotto prodotto : inventario) {
            if (prodotto.getId().equals(id)) {
                return prodotto;
            }
        }
        return null;
    }

    public List<Prodotto> getInventario() {
        return inventario;
    }

    public void setInventario(List<Prodotto> inventario) {
        this.inventario = inventario;
    }

    public List<Prodotto> getDispositivi() {
        return dispositivi;
    }

    public void setDispositivi(List<Prodotto> dispositivi) {
        this.dispositivi = dispositivi;
    }

}
