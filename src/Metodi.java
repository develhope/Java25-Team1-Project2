import java.util.ArrayList;

public class Metodi {

    // Metodo per stampare tutti i dispositivi presenti nel magazzino
    public ArrayList<Prodotti> stampaDispositiviMagazzino(Magazzino magazzino) {
        ArrayList<Prodotti> dispositivi = magazzino.getProdottiInMagazzino();

        if (dispositivi.isEmpty()) {
            System.out.println("Nessun dispositivo presente in magazzino.");
            return null;
        } else {
            System.out.println("Dispositivi in magazzino:");
            for (Prodotti dispositivo : dispositivi) {
                System.out.println(dispositivo);
            }
            return dispositivi;
        }
    }
}
