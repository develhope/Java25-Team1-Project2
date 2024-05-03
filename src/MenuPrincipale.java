import java.util.Scanner;


public class MenuPrincipale {
    Magazzino magazzino = new Magazzino();
    GestoreMagazzino gestoreMagazzino = new GestoreMagazzino();
    //TODO aggiungere oggetto carrello
    // Metodo per gestire il menu principale
    public void menu(){

        Boolean continua = true;
        Scanner scanner= new Scanner(System.in);

        while (continua){
            System.out.println("Menu Principale:");
            System.out.println("1. Accedi al magazzino");
            System.out.println("2. Creazione carrello");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");

            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    menuMagazzino(scanner);
                    break;
                case 2:
                    menuCarrello(scanner);
                    break;
                case 0:
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida!");
                    break;
            }
        }
        // Chiude lo scanner alla fine del programma per liberare le risorse
        scanner.close();
    }
    // Metodo per gestire il menu del magazzino
    public void menuMagazzino(Scanner scanner) {
        boolean continua = true;
        while (continua) {
            System.out.println("Menu Magazzino:");
            System.out.println("1. Elenco prodotti");
            System.out.println("2. cerca prodotto");
            System.out.println("3. Aggiungi Prodotto");
            System.out.println("0. Torna al  menu principale ");
            System.out.print("Scelta: ");

            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    magazzino.stampaMagazzino();
                    break;

                case 2:

                    break;

                case 3:
                    gestoreMagazzino.aggiungiDispositivoManuale(magazzino);
                    break;

                case 0:
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida!");
                    break;
            }
        }
    }
    // Metodo per gestire il menu del carrello
    public void menuCarrello(Scanner scanner) {

        boolean continua = true;
        while (continua) {
            System.out.println("Menu Carrello:");
            System.out.println("1. Aggiungi prodotto al carrello: ");
            System.out.println("2. cerca prodotto");
            System.out.println("0. Torna al  menu principale ");
            System.out.print("Scelta: ");

            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:

                    break;

                case 2:
                    break;

                case 0:
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida!");
                    break;
            }
        }
    }
}
