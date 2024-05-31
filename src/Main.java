import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

         List<Prodotto> magazzino1 = new ArrayList<>();
         List<Prodotto> magazzino2 = new ArrayList<>();
         List<Prodotto> magazzino3 = new ArrayList<>();

         List<Prodotto> carrello = new ArrayList<>();



      Smartphone smartphone1 = new Smartphone(TipoDispositivoEnum.SMARTPHONE, "Asus","Rog Phone 7 Ultimate",5.7,TipoMemoriaArchiviazioneEnum.NVMe,SpazioDiArchiviazioneEnum.CINQUECENTODODICI,
                                     899.99,1299.99, UUID.randomUUID());

      Smartphone smartphone2 = new Smartphone(TipoDispositivoEnum.SMARTPHONE, "Apple","Iphone X",4.5,TipoMemoriaArchiviazioneEnum.NVMe,SpazioDiArchiviazioneEnum.CENTOVENTOTTO,
                              799.99,1399.99, UUID.randomUUID());

      Notebook notebook1 = new Notebook(TipoDispositivoEnum.NOTEBOOK, "Apple", "MacBook Air 13", 15.0, TipoMemoriaArchiviazioneEnum.SSD, SpazioDiArchiviazioneEnum.CINQUECENTODODICI,
                              999.99, 1699.99, UUID.randomUUID());

      Notebook notebook2 = new Notebook(TipoDispositivoEnum.NOTEBOOK, "Acer", "Predator Helios 16", 16.0, TipoMemoriaArchiviazioneEnum.SSD, SpazioDiArchiviazioneEnum.DUEMILAQUARANTADUE,
                              999.99, 1599.99, UUID.randomUUID());

      Tablet tablet1 = new Tablet(TipoDispositivoEnum.TABLET, "Samsung", "Galaxy Tab a7", 10.4, TipoMemoriaArchiviazioneEnum.SSD, SpazioDiArchiviazioneEnum.TRENTADUE,
                              599.99, 799.99, UUID.randomUUID());

      Tablet tablet2 = new Tablet(TipoDispositivoEnum.TABLET, "Samsung", "Galaxy Tab a9+", 12.0, TipoMemoriaArchiviazioneEnum.SSD, SpazioDiArchiviazioneEnum.SESSANTAQUATTRO,
                              999.99, 1599.99, UUID.randomUUID());



         aggiungiProdottoAlMagazzino(magazzino1 , smartphone1);
         aggiungiProdottoAlMagazzino(magazzino1 , smartphone2);
         aggiungiProdottoAlMagazzino(magazzino2 , notebook1);
         aggiungiProdottoAlMagazzino(magazzino2 , notebook2);
         aggiungiProdottoAlMagazzino(magazzino3 , tablet1);
         aggiungiProdottoAlMagazzino(magazzino3 , tablet2);

        System.out.println(magazzino1);
        System.out.println(magazzino2);
        System.out.println(magazzino3);

    }


    // metedo magazzino per Aggiungere un prodotto all'inventario
    public static void aggiungiProdottoAlMagazzino(List<Prodotto> magazzino , Prodotto prodotto) {
         magazzino.add(prodotto);
    }

    // metodo magazzino per Rimuovere un prodotto dall'inventario
    public static void rimuoviProdottoDaMagazzino(List<Prodotto> magazzino , UUID id) {
         magazzino.removeIf(p -> p.getId().equals(id));
    }

    // metodo magazzino per Trovare un prodotto per id
   public static Prodotto trovaProdottoPerIdNelMagazzino(List<Prodotto> magazzino , UUID id) {
        for (Prodotto prodotto : magazzino) {
            if (prodotto.getId().equals(id)) {
                return prodotto;
            }
        }
        return null;
    }
    // Aggiungi un prodotto al carrello
    public static void aggiungiProdotto(List<Prodotto> carrello , Prodotto prodotto) {
        carrello.add(prodotto);
    }


}