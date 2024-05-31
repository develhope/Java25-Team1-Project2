import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        Magazzino magazzino1 = new Magazzino();
        Magazzino magazzino2 = new Magazzino();
        Magazzino magazzino3 = new Magazzino();

        Carrello carrello = new Carrello();

        Smartphone smartphone1 = new Smartphone(TipoDispositivoEnum.SMARTPHONE, "Asus", "Rog Phone 7 Ultimate", 5.7,
                TipoMemoriaArchiviazioneEnum.NVMe, SpazioDiArchiviazioneEnum.CINQUECENTODODICI, 899.99, 1299.99,
                UUID.randomUUID());

        Smartphone smartphone2 = new Smartphone(TipoDispositivoEnum.SMARTPHONE, "Apple", "Iphone X", 4.5,
                TipoMemoriaArchiviazioneEnum.NVMe, SpazioDiArchiviazioneEnum.CENTOVENTOTTO, 799.99, 1399.99,
                UUID.randomUUID());

        Notebook notebook1 = new Notebook(TipoDispositivoEnum.NOTEBOOK, "Apple", "MacBook Air 13", 15.0,
                TipoMemoriaArchiviazioneEnum.SSD, SpazioDiArchiviazioneEnum.CINQUECENTODODICI, 999.99, 1699.99,
                UUID.randomUUID());

        Notebook notebook2 = new Notebook(TipoDispositivoEnum.NOTEBOOK, "Acer", "Predator Helios 16", 16.0,
                TipoMemoriaArchiviazioneEnum.SSD, SpazioDiArchiviazioneEnum.DUEMILAQUARANTADUE, 999.99, 1599.99,
                UUID.randomUUID());

        Tablet tablet1 = new Tablet(TipoDispositivoEnum.TABLET, "Samsung", "Galaxy Tab a7", 10.4,
                TipoMemoriaArchiviazioneEnum.SSD, SpazioDiArchiviazioneEnum.TRENTADUE, 599.99, 799.99,
                UUID.randomUUID());

        Tablet tablet2 = new Tablet(TipoDispositivoEnum.TABLET, "Samsung", "Galaxy Tab a9+", 12.0,
                TipoMemoriaArchiviazioneEnum.SSD, SpazioDiArchiviazioneEnum.SESSANTAQUATTRO, 999.99, 1599.99,
                UUID.randomUUID());

        magazzino1.aggiungiProdotto(smartphone1);
        magazzino1.aggiungiProdotto(smartphone2);
        magazzino2.aggiungiProdotto(notebook1);
        magazzino2.aggiungiProdotto(notebook2);
        magazzino3.aggiungiProdotto(tablet1);
        magazzino3.aggiungiProdotto(tablet2);

        System.out.println("Magazzino 1:");
        magazzino1.getMagazzino().forEach(System.out::println);
        System.out.println("Magazzino 2:");
        magazzino2.getMagazzino().forEach(System.out::println);
        System.out.println("Magazzino 3:");
        magazzino3.getMagazzino().forEach(System.out::println);

    }

}