import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Magazzino magazzino1 = new Magazzino();
        Magazzino magazzino2 = new Magazzino();
        Magazzino magazzino3 = new Magazzino();


      Smartphone smartphone1 = new Smartphone(TipoDispositivoEnum.SMARTPHONE, "Asus","Rog Phone 7 Ultimate",5.7,TipoMemoriaArchiviazioneEnum.NVMe,SpazioDiArchiviazioneEnum.CINQUECENTODODICI,
                                     899.99,1299.99, UUID.randomUUID());

      Smartphone smartphone2 = new Smartphone(TipoDispositivoEnum.SMARTPHONE, "Apple","Iphone X",4.5,TipoMemoriaArchiviazioneEnum.NVMe,SpazioDiArchiviazioneEnum.CENTOVENTOTTO,
                              799.99,1399.99, UUID.randomUUID());



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
*/
    }
}