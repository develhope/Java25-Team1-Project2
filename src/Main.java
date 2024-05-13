import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        /*MenuPrincipale menu = new MenuPrincipale();
        System.out.println("Benvenuto nel programma di gestione del magazzino!");
        menu.mostraMenu();*/

        Magazzino magazzino = new Magazzino();

        // Test dei metodi di ricerca
        System.out.println("Test ricerca per tipo di dispositivo:");
        Metodi.cercaDispositiviPerTipo(magazzino, TipoDispositivo.SMARTPHONE);
        System.out.println();

        System.out.println("Test ricerca per produttore:");
        Metodi.cercaDispositiviPerProduttore(magazzino, "Samsung");
        System.out.println();

        System.out.println("Test ricerca per modello:");
        Metodi.cercaDispositiviPerModello(magazzino, "Galaxy A71");
    }
}
// 46b224f6-ec7d-4fec-a4c1-b59bc74aeeb3
// 6c0a4bc6-ea47-46f0-9abb-fd6da43c7c5b