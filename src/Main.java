public class Main {

    public static void main(String[] args) {
        Nootebook notebook1 = new Nootebook(TipoDispositivo.notebook, 1, "Apple", "Macbook Pro", 17.5, 256, 1100.99, 1350.99);

        System.out.println(notebook1);
        System.out.println("Descrizione: " + notebook1.leggiDescrizioneProdotto());
    }

}
