public class Main {

    public static void main(String[] args) {

        Smartphone smartphone1 = new Smartphone(TipoDispositivo.smartphone, 21, "Asus", "Rog Phone 7 Ultimate", 6.78,512, 1499.00,1599.00);
        System.out.println(smartphone1);
        System.out.println("Modello: " + smartphone1.leggiModello());
        System.out.println("Descrizione: " + smartphone1.leggiDescrizioneProdotto());
    }

}
