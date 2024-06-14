
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        Magazzino magazzinoEuronics = new Magazzino();
        Magazzino magazzinoEsselunga = new Magazzino();
        Magazzino magazzinoArmani = new Magazzino();

        Carrello carrello = new Carrello();

        // Prodotti ELETTRONICA
        Prodotto smartphone1 = new Smartphone(UUID.randomUUID(), TipologiaProdottoEnum.ELETTRONICA, TipoDispositivoEnum.SMARTPHONE, "Samsung Galaxy S8", "", 599.99, "", "", 5.6,
                TipoMemoriaArchiviazioneEnum.NVMe, SpazioDiArchiviazioneEnum.CINQUECENTODODICI, 300.00);

        Prodotto smartphone2 = new Smartphone(UUID.randomUUID(), TipologiaProdottoEnum.ELETTRONICA, TipoDispositivoEnum.SMARTPHONE, "Samsung Galaxy S8", "", 599.99, "", "", 5.6,
                TipoMemoriaArchiviazioneEnum.NVMe, SpazioDiArchiviazioneEnum.CINQUECENTODODICI, 300.00);

        Prodotto notebook1 = new Notebook(UUID.randomUUID(), TipologiaProdottoEnum.ELETTRONICA, TipoDispositivoEnum.NOTEBOOK, "Samsung Galaxy S8", "", 599.99, "", "", 5.6,
                TipoMemoriaArchiviazioneEnum.NVMe, SpazioDiArchiviazioneEnum.CINQUECENTODODICI, 300.00);

        Prodotto notebook2 = new Notebook(UUID.randomUUID(), TipologiaProdottoEnum.ELETTRONICA, TipoDispositivoEnum.NOTEBOOK, "Samsung Galaxy S8", "", 599.99, "", "", 5.6,
                TipoMemoriaArchiviazioneEnum.NVMe, SpazioDiArchiviazioneEnum.CINQUECENTODODICI, 300.00);

        Prodotto tablet1 = new Tablet(UUID.randomUUID(), TipologiaProdottoEnum.ELETTRONICA, TipoDispositivoEnum.TABLET, "Samsung Galaxy S8", "", 599.99, "", "", 5.6,
                TipoMemoriaArchiviazioneEnum.NVMe, SpazioDiArchiviazioneEnum.CINQUECENTODODICI, 300.00);

        Prodotto tablet2 = new Tablet(UUID.randomUUID(), TipologiaProdottoEnum.ELETTRONICA, TipoDispositivoEnum.TABLET, "Samsung Galaxy S8", "", 599.99, "", "", 5.6,
                TipoMemoriaArchiviazioneEnum.NVMe, SpazioDiArchiviazioneEnum.CINQUECENTODODICI, 300.00);

        magazzinoEuronics.aggiungiProdotto(smartphone1);
        magazzinoEuronics.aggiungiProdotto(smartphone2);
        magazzinoEuronics.aggiungiProdotto(notebook1);
        magazzinoEuronics.aggiungiProdotto(notebook2);
        magazzinoEuronics.aggiungiProdotto(tablet1);
        magazzinoEuronics.aggiungiProdotto(tablet2);

        magazzinoEuronics.rimuoviProdotto(tablet1);

        // Prodotti Alimentari
        Prodotto cereali = new Prodotto(UUID.randomUUID(),TipologiaProdottoEnum.ALIMENTARE, "Cereali Kellogs", "", 3.99);
        Prodotto cocaCola = new Prodotto(UUID.randomUUID(),TipologiaProdottoEnum.ALIMENTARE, "Coca-Cola", "", 1.70);
        Prodotto fanta = new Prodotto(UUID.randomUUID(),TipologiaProdottoEnum.ALIMENTARE, "Fanta", "", 1.60);
        Prodotto patatine = new Prodotto(UUID.randomUUID(),TipologiaProdottoEnum.ALIMENTARE, "Patatine San Carlo", "", 1.20);
        Prodotto gelato = new Prodotto(UUID.randomUUID(),TipologiaProdottoEnum.ALIMENTARE, "Maxi-Bon", "", 1.50);

        magazzinoEsselunga.aggiungiProdotto(cereali);
        magazzinoEsselunga.aggiungiProdotto(cocaCola);
        magazzinoEsselunga.aggiungiProdotto(fanta);
        magazzinoEsselunga.aggiungiProdotto(patatine);
        magazzinoEsselunga.aggiungiProdotto(gelato);

        //
        //TODO aggiungere prodotti alimentari e abbigliamento
        // Esempio di utilizzo dei metodi di ricerca

        /*magazzinoEuronics.cercaPerTipoProdotto(TipologiaProdottoEnum.ELETTRONICA);
        //magazzinoEuronics.cercaPerTipoDispositivo(TipoDispositivoEnum.SMARTPHONE);
        magazzinoEuronics.cercaDispositiviPerModello("Galaxy S8");

        //test metodi

        carrello.aggiungiProdottoACarrello(smartphone1);
        carrello.finalizzaAcquistoCarrello();

        magazzinoEuronics.ricercaPerPrezzoVendita(500.00);

         */
        magazzinoEsselunga.stampaProdotti();

    }
}