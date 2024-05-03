public class Main {

    public static void main(String[] args) {

        Magazzino magazzino = new Magazzino();
        GestoreMagazzino gestoreMagazzino = new GestoreMagazzino();

        // Aggiungi 5 tablet al magazzino
        magazzino.aggiungiDispositivi(5, TipoDispositivo.TABLET);

        // Aggiungi 3 smartphone al magazzino
        magazzino.aggiungiDispositivi(3, TipoDispositivo.SMARTPHONE);

        // Aggiungi 2 notebook al magazzino
        magazzino.aggiungiDispositivi(2, TipoDispositivo.NOTEBOOK);

        GestoreMagazzino.aggiungiDispositivoManuale(magazzino);
    }
}
