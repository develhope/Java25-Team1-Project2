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
        Smartphone smartphoneBuilder = new Smartphone();
        smartphoneBuilder.setTipoDispositivo(TipoDispositivo.SMARTPHONE);
        smartphoneBuilder.setProduttore("Asus");
        smartphoneBuilder.setModello("Rog Phone 7 Ultimate");
        smartphoneBuilder.setDimensioneDisplay(5.7);
        smartphoneBuilder.setTipoMemoria(TipoMemoriaArchiviazione.NVMe);
        smartphoneBuilder.setDimensioneArchiviazione(SpazioDiArchiviazione.CINQUECENTODODICI);
        smartphoneBuilder.setPrezzoAcquisto(899.99);
        smartphoneBuilder.setPrezzoVendita(1299.99);
        smartphoneBuilder.getId(UUID.randomUUID());
        Prodotto smartphone1 = smartphoneBuilder.smartphoneBiuld();

        Smartphone smartphoneBuilde2 = new Smartphone();
        smartphoneBuilde2.setTipoDispositivo(TipoDispositivo.SMARTPHONE);
        smartphoneBuilde2.setProduttore("Apple");
        smartphoneBuilde2.setModello("Iphone X");
        smartphoneBuilde2.setDimensioneDisplay(4.5);
        smartphoneBuilde2.setTipoMemoria(TipoMemoriaArchiviazione.NVMe);
        smartphoneBuilde2.setDimensioneArchiviazione(SpazioDiArchiviazione.CENTOVENTOTTO);
        smartphoneBuilde2.setPrezzoAcquisto(799.99);
        smartphoneBuilde2.setPrezzoVendita(1399.99);
        smartphoneBuilde2.getId(UUID.randomUUID());
        Prodotto smartphone2 = smartphoneBuilder.smartphoneBiuld();


        Prodotto smartphone3 = new Prodotto(TipoDispositivo.SMARTPHONE,"", "",5.4,TipoMemoriaArchiviazione.NVMe,SpazioDiArchiviazione.CINQUECENTODODICI,399.99,599.99,UUID.randomUUID());

//        Smartphone smartphone2 = new Smartphone(TipoDispositivo.SMARTPHONE, "Samsung", "Galaxy A71",6.3, TipoMemoriaArchiviazione.NVMe, SpazioDiArchiviazione.DUECENTOCINQUANTASEI, 499.99, 799.99, UUID.randomUUID());
//        Notebook notebook1 = new Notebook(TipoDispositivo.NOTEBOOK, "Intel", "Chuwi",15.4, TipoMemoriaArchiviazione.HDD, SpazioDiArchiviazione.CINQUECENTODODICI, 269.99, 599.99, UUID.randomUUID());
//        Tablet tablet1 = new Tablet(TipoDispositivo.TABLET, "Samsung", "Galaxy S7",10.1, TipoMemoriaArchiviazione.SSD, SpazioDiArchiviazione.CENTOVENTOTTO, 249.99, 599.99, UUID.randomUUID());

        inventario.add(smartphone1);
        inventario.add(smartphone2);
        inventario.add(smartphone3);
//        inventario.add(notebook1);
//        inventario.add(tablet1);

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
