
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        Magazzino magazzinoEuronics = new Magazzino("Euronics Bruno","Via Libica, 91100 TRAPANI (TP)");
        Magazzino magazzinoEsselunga = new Magazzino("Esselunga di Aprilia","Via Misurata 8, 04011 APRILIA (LT)" );
        Magazzino magazzinoArmani = new Magazzino("Emporio Armani", "Piazza dei Martiri 61-62, 80121 NAPOLI (NA)");
        Carrello carrello1 = new Carrello();
        Carrello carrello2 = new Carrello();

        // Prodotti ELETTRONICA
        Prodotto smartphone1 = new Smartphone(UUID.randomUUID(), TipologiaProdottoEnum.ELETTRONICA, TipoDispositivoEnum.SMARTPHONE, "Samsung Galaxy S8", "", 799.99, "", "", 5.6,
                TipoMemoriaArchiviazioneEnum.NVMe, SpazioDiArchiviazioneEnum.CINQUECENTODODICI, 300.00);

        Prodotto smartphone2 = new Smartphone(UUID.randomUUID(), TipologiaProdottoEnum.ELETTRONICA, TipoDispositivoEnum.SMARTPHONE, "Asus Rog Phone 7 Ultimate", "", 1299.99, "", "", 5.6,
                TipoMemoriaArchiviazioneEnum.NVMe, SpazioDiArchiviazioneEnum.CINQUECENTODODICI, 300.00);

        Prodotto notebook1 = new Notebook(UUID.randomUUID(), TipologiaProdottoEnum.ELETTRONICA, TipoDispositivoEnum.NOTEBOOK, "Acer Predator Helios 300", "", 23599.99, "", "", 15.0,
                TipoMemoriaArchiviazioneEnum.NVMe, SpazioDiArchiviazioneEnum.CINQUECENTODODICI, 300.00);

        Prodotto notebook2 = new Notebook(UUID.randomUUID(), TipologiaProdottoEnum.ELETTRONICA, TipoDispositivoEnum.NOTEBOOK, "MacBook pro", "", 1799.99, "", "", 14.6,
                TipoMemoriaArchiviazioneEnum.NVMe, SpazioDiArchiviazioneEnum.CINQUECENTODODICI, 300.00);

        Prodotto tablet1 = new Tablet(UUID.randomUUID(), TipologiaProdottoEnum.ELETTRONICA, TipoDispositivoEnum.TABLET, "Samsung Galaxy Note 3", "", 299.99, "", "", 5.6,
                TipoMemoriaArchiviazioneEnum.NVMe, SpazioDiArchiviazioneEnum.CINQUECENTODODICI, 300.00);

        Prodotto tablet2 = new Tablet(UUID.randomUUID(), TipologiaProdottoEnum.ELETTRONICA, TipoDispositivoEnum.TABLET, "Samsung Galaxy S12", "", 699.99, "", "", 5.6,
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

        //satampa magazzino prima della vendita
        magazzinoEuronics.stampaMagazzino();

        //simulazione acquisto
        magazzinoEuronics.aggiungiProdottoACarrello(carrello1,smartphone1);
        magazzinoEuronics.aggiungiProdottoACarrello(carrello1,notebook1);

        carrello1.stampaProdottiCarrello();
        carrello1.calcolaTotaleCarrello();
        carrello1.effettuaPagamento();

        //satampa magazzino dopo la vendita
        magazzinoEuronics.stampaMagazzino();
        //TODO aggiungere prodotti alimentari e abbigliamento
        // Esempio di utilizzo dei metodi di ricerca

        /*magazzinoEuronics.cercaPerTipoProdotto(TipologiaProdottoEnum.ELETTRONICA);

        magazzinoEuronics.cercaDispositiviPerModello("Galaxy S8");

        //test metodi

        carrello.aggiungiProdottoACarrello(smartphone1);
        carrello.finalizzaAcquistoCarrello();

        magazzinoEuronics.ricercaPerPrezzoVendita(500.00);

         */


    }
}