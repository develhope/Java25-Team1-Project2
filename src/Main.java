public class Main {

    public static void main(String[] args) {
        Nootebook notebook1 = new Nootebook(TipoDispositivo.notebook, 1, "Apple", "Macbook Pro", 16.0, 512, 2650.00, 3099.00);

        System.out.println(notebook1);
        System.out.println("Descrizione: " + notebook1.leggiDescrizioneProdotto());
    }

}
