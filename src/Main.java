public class Main {

    public static void main(String[] args) {
        Tablet tablet1 = new Tablet(TipoDispositivo.tablet, 1, "Samsung", "Galaxy Tab S9 Series", 14.6, 160, TipoMemoriaArchiviazione.NVMe, 1100.99, 1299.99);
        Nootebook notebook1 = new Nootebook(TipoDispositivo.notebook, 1, "Apple", "Macbook Pro", 16.0, 512, TipoMemoriaArchiviazione.SSD, 2650.00, 3099.00);
        Smartphone smartphone1 = new Smartphone(TipoDispositivo.smartphone, 21, "Asus", "Rog Phone 7 Ultimate", 6.78, 512, TipoMemoriaArchiviazione.NVMe, 1499.00, 1599.00);

        Prodotti prodotti = new Prodotti(TipoDispositivo.notebook, notebook1, 23);
        System.out.println(prodotti);
    }
}
