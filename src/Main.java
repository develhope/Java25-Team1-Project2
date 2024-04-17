public class Main {

    public static void main(String[] args) {
        Tablet tablet1 = new Tablet(TipoDispositivo.tablet, 1, "Samsung", "Galaxy Tab S9 Series", 14.6, 160, 1100.99, 1299.99);
        Nootebook notebook1 = new Nootebook(TipoDispositivo.notebook, 1, "Apple", "Macbook Pro", 16.0, 512, 2650.00, 3099.00);
        Smartphone smartphone1 = new Smartphone(TipoDispositivo.smartphone, 21, "Asus", "Rog Phone 7 Ultimate", 6.78,512, 1499.00,1599.00);

        System.out.println(notebook1);
        System.out.println("Descrizione: " + notebook1.leggiDescrizioneProdotto());

        System.out.println(tablet1);
        System.out.println("Modello: " + tablet1.leggiModello());
        System.out.println("Descrizione: " + tablet1.leggiDescrizioneProdotto());

        System.out.println(smartphone1);
        System.out.println("Modello: " + smartphone1.leggiModello());
        System.out.println("Descrizione: " + smartphone1.leggiDescrizioneProdotto());
    }

}
